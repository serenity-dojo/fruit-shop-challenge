package com.serenitydojo.fruitshop;

public class ShoppingCartItem {
    private final Fruit fruit;
    private final Double quantity;
    private final Double totalPrice;
    public ShoppingCartItem(Fruit fruit, Double quantity, Double totalPrice) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    /**
     *
     * @return Total Cost of quantity of fruit Item purchased.
     */
    public double getTotalCost() {
        return totalPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }
}
