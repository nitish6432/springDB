package com.microservice.emicalculator.exception;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {


		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getField())
				.collect(Collectors.toList());
		List<String> errors1 = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		
		
		Map<String,String> map = new LinkedHashMap<String,String>();  
		map.put("status", status.toString());
		map.put("status Description", status.getReasonPhrase());
	    for (int i=0; i<errors.size(); i++) {
	      map.put(errors.get(i), errors1.get(i));   
	    }
	    

		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
}
