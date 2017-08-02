package com.atomicity.customExceptions;

public class UserNameTakenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2684951458106809440L;

	public UserNameTakenException() {
		// TODO Auto-generated constructor stub
	}

	public UserNameTakenException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNameTakenException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameTakenException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameTakenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
