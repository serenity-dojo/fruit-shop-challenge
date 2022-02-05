package com.serenitydojo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingCartItem> items;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }

    public ShoppingCartAdder add(Double amount) {
        return new ShoppingCartAdder(this, amount);
    }
    public List<ShoppingCartItem> getItems() {
        return new ArrayList<>(items);
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(ShoppingCartItem::getTotalCost).sum();
    }

    public class ShoppingCartAdder {
        private final ShoppingCart shoppingCart;
        private final Double weight;

        public ShoppingCartAdder(ShoppingCart shoppingCart, Double weight) {
            this.shoppingCart = shoppingCart;
            this.weight = weight;
        }

        public ShoppingCart kgOf(Fruits fruit) {
            double basePrice = shoppingCart.catalog.getPriceOfAFruitInCatalog(fruit);
            double discountedPrice = (weight >= 5) ? basePrice * 0.9 : basePrice;
            ShoppingCartItem item = new ShoppingCartItem(fruit, weight, discountedPrice * weight);
            shoppingCart.items.add(item);
            return shoppingCart;
        }
    }

}
