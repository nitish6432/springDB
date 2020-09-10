package com.microservice.emicalculator.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.emicalculator.api.EmiCalculatorServiceRequest;
import com.microservice.emicalculator.api.EmiCalculatorServiceResponse;
import com.microservice.emicalculator.service.EmiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@Api(value = "EmiOffers")
@Validated
@RequiredArgsConstructor
@EnableCircuitBreaker
public class EmiCalculatorController implements BaseController {
	@Autowired
	private EmiService emiService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = "/emi")
	@ApiOperation(value = "Calculate EMI", response = EmiCalculatorServiceResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "EMI retrieved successfully"),
			@ApiResponse(code = 400, message = "The input data of the POST body is not valid. The response will give a hint about the invalid data."),
			@ApiResponse(code = 500, message = "Unexpected server error.") })
	
	public ResponseEntity<EmiCalculatorServiceResponse> calculateEmiDetails(
			@Valid @RequestBody EmiCalculatorServiceRequest request) {

		return new ResponseEntity<EmiCalculatorServiceResponse>(emiService.getEMIDetails(request),
				org.springframework.http.HttpStatus.OK);

		/*
		 * com.lhcargo.booking.pricing.domain.CalculateRouteRateRequest dtoRequest =
		 * CalculateRouteRateMapper.INSTANCE.map(request);
		 * 
		 * return new ResponseEntity<>( CalculateRouteRateMapper.INSTANCE.map(
		 * pricingService.calculateRouteRate(dtoRequest)), HttpStatus.OK );
		 */

	}
}