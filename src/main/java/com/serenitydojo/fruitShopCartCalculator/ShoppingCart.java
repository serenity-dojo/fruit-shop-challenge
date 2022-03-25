package com.serenitydojo.fruitShopCartCalculator;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Catalog catalog;
    private Map<Fruit, Double> fruitsFromCartWithQuantity = new HashMap<>();
    private Double priceOfTheCart = 0.0;
    private Double quantityInKilo = 0.0;


    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addFruitsIntoTheCartAndGetThePrice(Fruit fruit, Double quantityInKilo) {
        this.quantityInKilo = quantityInKilo;

        fruitsFromCartWithQuantity.put(fruit, quantityInKilo);
        calculateThePriceOfTheCart(fruit);
        catalog.calculateRemainingQuantity(fruit, quantityInKilo);
    }

    private Double calculateThePriceOfTheCart(Fruit fruit) {
        return this.priceOfTheCart = calculateDiscount(this.priceOfTheCart + (catalog.getPriceOf(fruit) * this.quantityInKilo));
    }

    public Double displayTheTotalOfTheCart() { return this.priceOfTheCart; }

    private Double calculateDiscount(Double price) {
        if(this.quantityInKilo >= 5)
            return price * 0.9;

        return price;
    }

}
