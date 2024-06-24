package com.tbttest.demo.exceptions;

public class BasicException extends Exception {

	private static final long serialVersionUID = 8522215661401071324L;

	private final String code;

	private final String detailMessage;

	public BasicException(String detailMessage, Throwable cause, String code) {
		super(cause);
		this.code = code;
		this.detailMessage = detailMessage;
	}

	public BasicException(String detailMessage, String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
		this.detailMessage=detailMessage;

	}

	public BasicException(String message, String code) {
		super(message);
		this.code = code;
		this.detailMessage = "";

	}

	public String getCode() {
		return code;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

}
