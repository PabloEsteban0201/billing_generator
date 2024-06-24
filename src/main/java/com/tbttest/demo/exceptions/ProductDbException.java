package com.tbttest.demo.exceptions;

public class ProductDbException extends BasicException {

	private static final long serialVersionUID = 8628335393261306299L;

	public ProductDbException(String message) {
		super(message, "500");
	}

	public ProductDbException(String detailMessage, String message, Throwable cause) {
		super(detailMessage, message, cause, "500");
	}

	public ProductDbException(String detailMessage, Throwable cause) {
		super(detailMessage, cause, "500");
	}

	
}