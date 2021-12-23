package com.serenitydojo.Shop;

import com.serenitydojo.Shop.Fruits;
import com.serenitydojo.exception.FruitUnAvailableException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.serenitydojo.Shop.Fruits.*;

public class FruitsCatalog {

    private static final Map<Fruits, Double> FRUITS_IN_SHOP = new HashMap<>();

    static {
        FRUITS_IN_SHOP.put(APPLE, 4.00);
        FRUITS_IN_SHOP.put(ORANGE, 5.50);
        FRUITS_IN_SHOP.put(BANANAS, 6.00);
        FRUITS_IN_SHOP.put(PEARS, 4.50);
    }

    public void updateCatatlogWithMarketpriceFor(Fruits fruit, double updatedPrice) {
        if (FRUITS_IN_SHOP.containsKey(fruit)) {
            FRUITS_IN_SHOP.put(fruit, updatedPrice);
        } else {
            throw new FruitUnAvailableException("Given friut is not available in catalog");
        }

    }

    public double getPriceForFruit(Fruits fruit) {
        try {
            return FRUITS_IN_SHOP.get(fruit);
        } catch (Exception e) {
            throw new FruitUnAvailableException("Given friut is not available in catalog", e);
        }
    }

    public List<Fruits> getListOfFruitsInShop() {
        List<Fruits> listofFruits = FRUITS_IN_SHOP.keySet()
                .stream()
                .collect(Collectors.toList());
        listofFruits.sort(Fruits.compareFruits());
        return listofFruits;
    }


}
