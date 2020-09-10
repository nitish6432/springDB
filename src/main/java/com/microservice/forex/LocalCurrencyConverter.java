package com.microservice.forex;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LocalCurrencyConverter implements ILocalCurrencyConverter {
	@Autowired
	private ExchangeValueRepository repository;
	public static final String DEFAULT_CURRENCY = "EUR";
	private static final int DEFAULT_ROUNDING_MODE = 4;

	@Override
	public ExchangeValue getCurrencyConversionMultiple(String from, String to) {
		ExchangeValue exchangeValue = new ExchangeValue();
		BigDecimal fromValue = repository.findByFromAndTo(ForexController.DEFAULT_CURRENCY, from)
				.getConversionMultiple();
		BigDecimal toValue = repository.findByFromAndTo(DEFAULT_CURRENCY, to).getConversionMultiple();

		BigDecimal conversionMultiple = toValue.divide(fromValue, DEFAULT_ROUNDING_MODE, RoundingMode.HALF_DOWN);
		exchangeValue.setConversionMultiple(conversionMultiple);
		exchangeValue.setFrom(from);
		exchangeValue.setTo(to);
		if(exchangeValue.getId() == null) {
			exchangeValue.setId((long) 1);
		}
		return exchangeValue;
	}
}
