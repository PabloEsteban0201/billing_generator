package com.tbttest.demo.exceptions;

public class InvoiceDbException extends BasicException {

	private static final long serialVersionUID = 8628335393261306299L;

	public InvoiceDbException(String message) {
		super(message, "500");
	}

	public InvoiceDbException(String detailMessage, String message, Throwable cause) {
		super(detailMessage, message, cause, "500");
	}

	public InvoiceDbException(String detailMessage, Throwable cause) {
		super(detailMessage, cause, "500");
	}

	
}
