package com.app.exceptions;

public class RiderNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7196835762799244242L;
	public RiderNotFoundException(String message) {
		super(message);
	}
}
