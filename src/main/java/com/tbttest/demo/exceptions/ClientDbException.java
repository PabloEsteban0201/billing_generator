package com.tbttest.demo.exceptions;

public class ClientDbException extends BasicException {

	private static final long serialVersionUID = -5018059108908422783L;

	public ClientDbException(String message) {
		super(message, "500");
	}

	public ClientDbException(String detailMessage, String message, Throwable cause) {
		super(detailMessage, message, cause, "500");
	}

	public ClientDbException(String detailMessage, Throwable cause) {
		super(detailMessage, cause, "500");
	}

}