package com.serenitydojo;


public class Fruit {
    private FruitName name;
    private double price;

    public Fruit(FruitName name, double price) {
        this.name = name;
        this.price = price;
    }

    public FruitName getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}