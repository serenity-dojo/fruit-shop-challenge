package com.serenitydojo.fruitShopCartCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    Map<Fruit, Integer> fruitAndQuantityForCart = new HashMap<>();

    public void addFruits(Map<Fruit, Integer> fruitAndQuantityForCart) {
        this.fruitAndQuantityForCart = fruitAndQuantityForCart;

        List<String> listInAlphabeticalOrder = new ArrayList<>();

        for (Map.Entry<Fruit, Integer> fruit : fruitAndQuantityForCart.entrySet()) {
            listInAlphabeticalOrder.add(fruit.getKey().toString());
        }
        // TODO
        //iterate throught the maps
        // get the quantity of each fruits
        // multiply the qtt with the price
        //return the price

    }
}
