package com.spring.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException() {
		super("Resource Not found ");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}


}
