package com.microservice.emicalculator.controller;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

/**
 * Common base for all Controllers
 * Unifies the context Path of the common Endpoints
 *
 * Nitish Kashyap
 */
@RequestMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
)
@Api(value = "emi")
@EnableCircuitBreaker
interface BaseController {
    // no methods, just using as a base for common annotations
}
