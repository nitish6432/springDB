package com.microservice.forex;

public interface ILocalCurrencyConverter {
	 ExchangeValue getCurrencyConversionMultiple(String from, String to);
}
