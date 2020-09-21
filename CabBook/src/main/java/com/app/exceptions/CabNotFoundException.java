package com.app.exceptions;

public class CabNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1369808671106376998L;
	
	public CabNotFoundException(String message) {
		super(message);
	}
}
