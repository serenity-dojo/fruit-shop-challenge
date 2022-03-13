package com.serenitydojo.fruitShopCartCalculator;

import java.util.HashMap;
import java.util.Map;

public class Catalog {

    Map<Fruit, Double> fruitWithPrice = new HashMap<>();

    public void addFruitWithPrice(Fruit fruit, double price) {
        fruitWithPrice.put(fruit, price);
    }

    public double priceOf(Fruit fruit) {
        return fruitWithPrice.get(fruit);
    }
}
