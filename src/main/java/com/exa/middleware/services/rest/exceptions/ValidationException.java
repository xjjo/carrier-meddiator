package com.exa.middleware.services.rest.exceptions;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String error;
	private String message;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void throwException() throws ValidationException {		
		throw new ValidationException(this.error, this.message);
	}
	
	public ValidationException(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	public ValidationException() {
		super();
	}
	
}
