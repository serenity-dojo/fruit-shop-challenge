package com.serenitydojo;

public class FruitPriceException extends Exception{
    public FruitPriceException(String message) {
        super(message);
    }

    public FruitPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}