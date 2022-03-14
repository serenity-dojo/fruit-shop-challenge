package com.serenitydojo.fruitShop;

import java.io.IOException;

public class FruitDoesntExistException extends RuntimeException {
    public FruitDoesntExistException(String text) {super (text);}
}
