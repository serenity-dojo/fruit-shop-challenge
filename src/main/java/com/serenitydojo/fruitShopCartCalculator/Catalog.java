package com.serenitydojo.fruitShopCartCalculator;

import java.util.*;
import java.util.stream.Collectors;

public class Catalog {

    Map<Fruit, Double> fruitWithPrice = new HashMap<>();
    Map<Fruit, Integer> quantityOfFruit = new HashMap<>();

    public void addFruitWithPrice(Fruit fruit, double price) { fruitWithPrice.put(fruit, price); }

    public double getPriceOf(Fruit fruit) {
        return fruitWithPrice.get(fruit);
    }

    public void updatedPriceOfAFruit(Fruit fruit, double price) {
        fruitWithPrice.replace(fruit, price);
    }


    public void addFruitWithQuantity(Map<Fruit, Integer> fruitAndQuantity) {
        this.quantityOfFruit = fruitAndQuantity;
    }

    public double getQuantityOf(Fruit fruit) {
        return quantityOfFruit.get(fruit);
    }

    public void updatedQuantityOfAFruit(Fruit fruit, Integer quantity) {
        quantityOfFruit.replace(fruit, quantity);
    }


    public List<String> getAllListedFruitsInAlphabeticalOrder() {
        List <String> listInAlphabeticalOrder = new ArrayList<>();

        for (Map.Entry<Fruit, Double> fruit : fruitWithPrice.entrySet()) {
            listInAlphabeticalOrder.add(fruit.getKey().toString());
        }

        return listInAlphabeticalOrder.stream().sorted().collect(Collectors.toList());

    }

}
