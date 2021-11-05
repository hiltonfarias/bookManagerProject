package com.github.hiltonfarias.bookManager.exceptions;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -7507642233804283142L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Exception exception) {
        super(message, exception);
    }
}
