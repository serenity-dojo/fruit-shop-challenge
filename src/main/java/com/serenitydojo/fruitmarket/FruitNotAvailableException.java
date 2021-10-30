package com.serenitydojo.fruitmarket;

public class FruitNotAvailableException extends RuntimeException {
    public FruitNotAvailableException(String message) {
        super(message);
    }
}
