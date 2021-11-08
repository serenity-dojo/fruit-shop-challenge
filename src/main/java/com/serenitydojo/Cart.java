package com.serenitydojo;

import java.util.HashMap;

public class Cart {

    private HashMap<FruitName, Double> shoppingCart;

    public Cart(HashMap<FruitName, Double> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    // Add an item to your cart
    // Add 10% discount for buying more than 5 kilos of any fruit
    public void addItemToCart(FruitName name, double price, double kilos) {
        if (kilos < 5) {
            shoppingCart.put(name, price * kilos);
        } else if (kilos > 5) {
            shoppingCart.put(name, price * kilos * 0.9);
        }
    }

    // Get current cart contents
    public HashMap<FruitName, Double> getCartContents() {
        return shoppingCart;
    }

    // Get current running total of items in your cart
    public double cartTotal() {
        double total = 0;
        for (FruitName cartItem : shoppingCart.keySet()) {
           total += shoppingCart.get(cartItem);
        }
        return total;
    }
}