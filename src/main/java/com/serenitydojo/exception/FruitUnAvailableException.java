package com.serenitydojo.exception;

public class FruitUnAvailableException extends RuntimeException {

    public FruitUnAvailableException(String message) {
        super(message);
    }

    public FruitUnAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

}
