package com.maikon.os.services.exceptions;

public class ObjectNotFondException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFondException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFondException(String message) {
		super(message);
	}

}
