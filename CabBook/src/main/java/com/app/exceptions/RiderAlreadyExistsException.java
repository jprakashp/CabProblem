package com.app.exceptions;

public class RiderAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952289791204071204L;
	
	public RiderAlreadyExistsException(String message) {
		super(message);
	}
}
