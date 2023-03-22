package com.serenitydojo;

public class CatalogItem {

    private final Fruit fruit;
    private final int amountInKg;

    public CatalogItem(Fruit fruit, int amountInKg) {
        this.fruit = fruit;
        this.amountInKg = amountInKg;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getAmountInKg() {
        return amountInKg;
    }
}
