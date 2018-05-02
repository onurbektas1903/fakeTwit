package com.fakeTwit.exception;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 6648725043534411041L;
    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message,Throwable cause) {
        super(message,cause);
    }
}
