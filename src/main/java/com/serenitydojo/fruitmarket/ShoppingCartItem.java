package com.serenitydojo.fruitmarket;

public class ShoppingCartItem {

    private Fruits fruit;
    private Double quantity;
    private Double finalPrice;

    public ShoppingCartItem(Fruits fruit, Double quantity, Double finalPrice) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.finalPrice = finalPrice;
    }

    public Fruits getFruit() {
        return fruit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getFinalPrice() {
        finalPrice = (quantity > 5.00) ? finalPrice * 0.9 : finalPrice;
        return finalPrice;
    }
}
