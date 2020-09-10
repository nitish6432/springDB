package com.microservice.emicalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.microservice.emicalculator.api.Duration;
import com.microservice.emicalculator.api.EMI;
import com.microservice.emicalculator.api.EmiCalculatorResponse;
import com.microservice.emicalculator.api.EmiCalculatorServiceRequest;
import com.microservice.emicalculator.api.EmiCalculatorServiceResponse;
import com.microservice.emicalculator.api.EmiDetails;
import com.microservice.emicalculator.exception.EMIException;
import com.microservice.emicalculator.model.EMIBean;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@EnableCircuitBreaker
@DefaultProperties(defaultFallback = "getEMIDetailsfallback")
public class EmiService {

	private static final double TWELVE = 12;
	private static final double HUNDRED = 100;
	private static final int THIRTY = 30;
	private static final int ROUND_OFF = 4;
	private static final int ZERO = 0;
	private static final String URL = "http://localhost:8100/currency-converter/from/{from}/to/{to}/quantity/{quantity}";
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public EmiCalculatorServiceResponse getEMIDetails(EmiCalculatorServiceRequest request) {
		EmiCalculatorServiceResponse res = new EmiCalculatorServiceResponse();
		res.setEmiCalculatorResponse(getEMIcalculatorRes(request));

		return res;
	}

	private EmiCalculatorResponse getEMIcalculatorRes(EmiCalculatorServiceRequest request) {
		EmiCalculatorResponse res = new EmiCalculatorResponse();
		res.setEmiDetails(setEMIDetails(request));
		return res;
	}

	@HystrixCommand(fallbackMethod = "getEMIDetailsfallback")
	public EmiDetails setEMIDetails(EmiCalculatorServiceRequest request) {
		LOGGER.debug("Stll not Inside fallback");
		EmiDetails res = new EmiDetails();
		if (request != null) {
			res.setEmi(getEMIList(request));
		}
		return res;
	}

	private EMI getEMI(EmiCalculatorServiceRequest request, String toCurrency) {

		String reqCurrency = request.getEmiCalculatorRequest().getLoanRequestedCurrency();
		try {
			if (!reqCurrency.equalsIgnoreCase(toCurrency)) {
				Map<String, Object> uriVariables = new HashMap<>();
				uriVariables.put("from", reqCurrency);
				uriVariables.put("to", toCurrency);
				uriVariables.put("quantity", request.getEmiCalculatorRequest().getLoanAmount());
				ResponseEntity<EMIBean> responseEntity = new RestTemplate().getForEntity(URL, EMIBean.class,
						uriVariables);
				EMIBean response = responseEntity.getBody();

				request.getEmiCalculatorRequest().setLoanAmount(response.getTotalCalculatedAmount());
				request.getEmiCalculatorRequest().setLoanRequestedCurrency(response.getTo());
			}
		} catch (ResourceAccessException e) {
			LOGGER.info(e.getLocalizedMessage());
			throw new EMIException();
		}

		double pricipal = request.getEmiCalculatorRequest().getLoanAmount().doubleValue();
		double roi = request.getEmiCalculatorRequest().getRateOfInterestInPercent().doubleValue();
		double tenure = (getDurationInMonths(request.getEmiCalculatorRequest().getDuration())).doubleValue();

		double emi;

		roi = roi / (TWELVE * HUNDRED);
		emi = (pricipal * roi * (float) Math.pow(1 + roi, tenure)) / (float) (Math.pow(1 + roi, tenure) - 1);

		BigDecimal totalIntesrestAndPricipalPayable = (BigDecimal.valueOf(emi * tenure));
		BigDecimal totalIntesrestPayable = totalIntesrestAndPricipalPayable.subtract(BigDecimal.valueOf(pricipal));

		EMI res = new EMI();
		res.setEmiAmountInLoanPayableCurr(
				BigDecimal.valueOf(emi).setScale(ROUND_OFF, RoundingMode.HALF_UP).toString() + " In " + toCurrency);
		res.setTotalpayableamountInLoanPayableCurr(
				totalIntesrestAndPricipalPayable.setScale(ROUND_OFF, RoundingMode.HALF_UP).toString() + " In "
						+ toCurrency);
		res.setTotalinterestInLoanPayableCurr(
				totalIntesrestPayable.setScale(ROUND_OFF, RoundingMode.HALF_UP).toString() + " In " + toCurrency);
		return res;
	}

	private BigDecimal getDurationInMonths(@Valid Duration duration) {
		if (duration != null) {
			BigDecimal noYearMonths = new BigDecimal(ZERO);
			BigDecimal months = duration.getNumberOfMonths();
			boolean addMonths = duration.getNumberOfYears().compareTo(noYearMonths) > ZERO;
			if (addMonths) {
				noYearMonths = (duration.getNumberOfYears().multiply(BigDecimal.valueOf(TWELVE)));
				months = months.add(noYearMonths);
			}

			if (duration.getNumberOfDays() > ZERO) {
				int noDaysMonths = (duration.getNumberOfDays() / THIRTY);
				if (noDaysMonths >= 1) {
					months = months.add(noYearMonths).add(BigDecimal.valueOf(noDaysMonths));
				} else if (!addMonths) {
					months = months.add(noYearMonths);
				}
			}
			return months;
		}
		return null;
	}

	private List<EMI> getEMIList(EmiCalculatorServiceRequest request) {
		List<EMI> res = new ArrayList<>();
		int loanCurrListSize = request.getEmiCalculatorRequest().getLoanPayableCurrency().size();
		for (int i = ZERO; i < loanCurrListSize; i++) {
			String toCurrency = request.getEmiCalculatorRequest().getLoanPayableCurrency().get(i);
			res.add(getEMI(request, toCurrency));
		}

		return res;
	}
}
