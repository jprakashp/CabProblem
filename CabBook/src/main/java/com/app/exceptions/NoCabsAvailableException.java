package com.app.exceptions;

public class NoCabsAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5242904201442327330L;
	public NoCabsAvailableException(String message) {
		super(message);
	}
}
