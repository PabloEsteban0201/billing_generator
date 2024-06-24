package com.tbttest.demo.exceptions;

public class ClientNotFoundException extends BasicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6791038525705711645L;

	public ClientNotFoundException(String detailMessage, String message, Throwable cause) {
		super(detailMessage, message, cause, "404");
	}

	public ClientNotFoundException(String message) {
		super(message, "404");
	}

	public ClientNotFoundException(String detailMessage, Throwable cause) {
		super(detailMessage, cause, "404");
	}
	
	

}
