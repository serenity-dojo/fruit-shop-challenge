package com.serenitydojo.fruitShop;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {
    Map<Fruit, Double> priceKilo = new HashMap<>();
    //set price
    public  SetPrice setPriceFruit(Fruit fruit) { return new SetPrice(this, fruit);}

    //get price + error handling - coudltnt get it to work
    public Double getPriceFruit(Fruit fruit) throws FruitDoesntExistException {
        if (priceKilo.containsKey(fruit) == true) {
            //System.out.println(priceKilo.get(fruit));
        return priceKilo.get(fruit); }
//        else {
//        System.out.println(priceKilo.get(fruit));
        throw new FruitDoesntExistException(fruit.name() + " does not exist in the list");
//    }
    }
    //list fruits alphab
    public List<Fruit> inAlphabeticalOrder() {
        return priceKilo.keySet().stream().sorted().collect(Collectors.toList());
    }

    //set price
    public static class SetPrice {
        private Catalog catalog;
        private Fruit fruit;

        public SetPrice(Catalog catalog, Fruit fruit) {
            this.catalog = catalog;
            this.fruit = fruit;

        }
        public  Catalog to(Double price) {
            catalog.priceKilo.put(fruit, price);
            return catalog;
        }

    }



}
