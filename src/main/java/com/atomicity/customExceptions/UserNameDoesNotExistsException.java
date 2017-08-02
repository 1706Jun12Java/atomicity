package com.atomicity.customExceptions;

public class UserNameDoesNotExistsException extends Exception {

	private static final long serialVersionUID = 4282773534563523822L;

	public UserNameDoesNotExistsException() {
		// TODO Auto-generated constructor stub
	}

	public UserNameDoesNotExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNameDoesNotExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameDoesNotExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameDoesNotExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
