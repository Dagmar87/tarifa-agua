package com.tarifa.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(
            String message) {

        super(message);
    }

}
