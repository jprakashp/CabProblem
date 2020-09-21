package com.app.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CabAlreadyExistsException.class)
	public ResponseEntity<?> cabAlreadyExistsExceptionHandling(CabAlreadyExistsException exception, WebRequest request){
		ErrorMessage errorMessage = 
				new ErrorMessage(new Date(),exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.ALREADY_REPORTED);
	}
	@ExceptionHandler(NoCabsAvailableException.class)
	public ResponseEntity<Object> noCabsAvailableExceptionHandling(NoCabsAvailableException exception, WebRequest request){
		ErrorMessage errorMessage = 
				new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RiderAlreadyExistsException.class)
	public ResponseEntity<Object> riderAlreadyExistsExceptionHandling(RiderAlreadyExistsException exception, WebRequest request){
		ErrorMessage errorMessage = 
				new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.ALREADY_REPORTED);
	}
	@ExceptionHandler(RiderNotFoundException.class)
	public ResponseEntity<Object> riderNotFoundExceptionHandling(RiderNotFoundException exception, WebRequest request){
		ErrorMessage errorMessage = 
				new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(TripNotFoundException.class)
	public ResponseEntity<Object> tripNotFoundExceptionHandling(TripNotFoundException exception, WebRequest request){
		ErrorMessage errorMessage = 
				new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CabNotFoundException.class)
	public ResponseEntity<Object> cabNotFoundExceptionHandling(CabNotFoundException exception, WebRequest request){
		ErrorMessage errorMessage = 
				new ErrorMessage(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
