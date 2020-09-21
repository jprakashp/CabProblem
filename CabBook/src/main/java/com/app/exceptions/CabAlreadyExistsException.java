package com.app.exceptions;

public class CabAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1062865773078304100L;
	
	public CabAlreadyExistsException(String message) {
		super(message);
	}

}
