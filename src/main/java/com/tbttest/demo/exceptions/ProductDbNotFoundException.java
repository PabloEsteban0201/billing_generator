package com.tbttest.demo.exceptions;

public class ProductDbNotFoundException extends BasicException {

	
	private static final long serialVersionUID = 6213752340512247649L;

	public ProductDbNotFoundException(String detailMessage, String message, Throwable cause) {
		super(detailMessage, message, cause, "404");
		
	}

	public ProductDbNotFoundException(String message) {
		super(message, "404");
		
	}

	public ProductDbNotFoundException(String detailMessage, Throwable cause) {
		super(detailMessage, cause, "404");
		
	}

	
}