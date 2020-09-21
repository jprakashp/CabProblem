package com.app.exceptions;

public class TripNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3036115038542885166L;
	public TripNotFoundException(String message) {
		super(message);
	}
}
