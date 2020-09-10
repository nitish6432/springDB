package com.microservice.emicalculator.exception;

public class EMIException extends RuntimeException {

	public EMIException() {

		super(String.format("Internal Server Error. Please try after Some time"));
	}
}
