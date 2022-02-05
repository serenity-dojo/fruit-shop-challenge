package com.serenitydojo;

public class ShoppingCartItem {
    private Fruits fruit;
    private Double quantity;
    private Double totalCost;

    public ShoppingCartItem(Fruits fruit, Double quantity, Double totalCost) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public Fruits getFruit() {
        return fruit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}
