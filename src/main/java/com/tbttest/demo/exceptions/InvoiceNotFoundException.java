package com.tbttest.demo.exceptions;

public class InvoiceNotFoundException extends BasicException {

	
	private static final long serialVersionUID = 6213752340512247649L;

	public InvoiceNotFoundException(String detailMessage, String message, Throwable cause) {
		super(detailMessage, message, cause, "404");
		
	}

	public InvoiceNotFoundException(String message) {
		super(message, "404");
		
	}

	public InvoiceNotFoundException(String detailMessage, Throwable cause) {
		super(detailMessage, cause, "404");
		
	}

	
}
