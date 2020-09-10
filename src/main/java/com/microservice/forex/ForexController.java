package com.microservice.forex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

	@Autowired
	public ExchangeValueRepository repository;
	@Autowired
    private ILocalCurrencyConverter currencyService;
	public static final String DEFAULT_CURRENCY = "EUR";

	// GET to http://localhost:8000/currency-exchange/from/EUR/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		if (!from.equalsIgnoreCase(DEFAULT_CURRENCY)) {
			return currencyService.getCurrencyConversionMultiple(from, to);

		} else {
			return repository.findByFromAndTo(from, to);

		}
	}

}