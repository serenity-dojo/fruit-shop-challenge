package com.serenitydojo.Shop;

import java.util.Comparator;

public enum Fruits {
    APPLE,ORANGE,BANANAS,PEARS,PEACHES;

    public static Comparator<Fruits> compareFruits() {
        return Comparator.comparing(Enum::toString);
    }
}

