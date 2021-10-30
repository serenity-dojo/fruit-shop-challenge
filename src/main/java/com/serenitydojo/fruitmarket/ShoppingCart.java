package com.serenitydojo.fruitmarket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<ShoppingCartItem> items;
    private final Catalog catalog;

    public ShoppingCart(Catalog catalog) {
        this.items = new ArrayList<>();
        this.catalog = catalog;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getFinalPrice() * item.getQuantity())
                .sum();
    }

    public void addItemToCart(Fruits fruit, double quantity){
        ShoppingCartItem newItem = new ShoppingCartItem(
                fruit, quantity, catalog.getPriceOf(fruit));

        items.add(newItem);
    }

    public List<ShoppingCartItem> getItems() {
        return new ArrayList<>(items);
    }
}
