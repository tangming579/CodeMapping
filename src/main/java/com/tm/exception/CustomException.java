package com.tm.exception;

public class CustomException extends Exception {
	
	private static final long serialVersionUID = -3608667856397125671L;

    public CustomException(String message) {
        super(message);
    }
}
