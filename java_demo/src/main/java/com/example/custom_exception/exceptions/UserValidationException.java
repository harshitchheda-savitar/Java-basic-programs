package com.example.custom_exception.exceptions;

public class UserValidationException extends Exception {

	/**
	 * this is a custom exception class for user validation
	 */
	private static final long serialVersionUID = 1L;

	public UserValidationException(String msg) {
		super(msg);
	}
}
