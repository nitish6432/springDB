package com.microservice.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Enable Feign Clients
 * 
 * Before we are able to use Feign, we need to enable 
 * it by using @EnableFeignClients annotation on 
 * the appropriate package where the client proxies are defined.

 * @author Nitish Kashyap
 *
 */
@SpringBootApplication
@EnableFeignClients("com.microservice.currencyconversion")
@EnableDiscoveryClient
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}
}
