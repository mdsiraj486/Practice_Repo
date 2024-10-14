package com.spring.exception.hnadlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public Map<String, Object> handleRNFException(ResourceNotFoundException ex){
		HashMap<String, Object> msg = new HashMap<>();
		msg.put(ex.getMessage(),HttpStatus.NOT_FOUND);
		
		return msg;
	}
	
	

}
