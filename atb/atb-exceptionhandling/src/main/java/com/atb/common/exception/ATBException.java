package com.atb.common.exception;

public class ATBException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int errorCode;

	public ATBException() {

		super();
	}

	public ATBException(String message) {

		super(message);
	}

	public ATBException(String message, Throwable cause) {

		super(message, cause);
	}

	public ATBException(Throwable cause) {

		super(cause);
	}

	public int getErrorCode() {

		return errorCode;
	}

	public void setErrorCode(int errorCode) {

		this.errorCode = errorCode;
	}
}
