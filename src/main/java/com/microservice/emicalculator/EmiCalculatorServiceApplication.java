/*
 * PricingServiceApplication.java
 *
 * Copyright (c) 2019 Lufthansa Cargo AG. All Rights Reserved.
 * Developed by LH Industry Solutions AS GmbH.
 *
 */

package com.microservice.emicalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class EmiCalculatorServiceApplication.
 *
 * @author Nitish Kashyap
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.microservice.emicalculator"})
public class EmiCalculatorServiceApplication {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(EmiCalculatorServiceApplication.class, args);
    }

}
