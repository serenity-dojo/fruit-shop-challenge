package com.serenitydojo.fruitshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {

    /**
     * Fruit Shop Cart Calculator Challenge
     * In this exercise, your challenge is to write a Fruit Shop Cart Calculator. Write tests code to illustrate the following requirements, and write the additional application code you need to make them work:
     *
     * The shop sells apples, oranges, bananas, pears, peaches and other fruit, depending on availability. For example the prices per kilo for the currently available fruit are:
     * Apples: $4.00
     * Oranges: $5.50
     * Bananas: $6.00
     * Pears: $4.50
     * You can update the catalog with the current market price of a fruit
     * The Catalog should list the names of the currently available fruit in alphabetical order
     * The Catalog should report the price of a given type of fruit
     * The Catalog should throw a FruitUnavailableException if the fruit is not currently available
     * You can add items to your shopping cart, which should keep a running total.
     * When you buy 5 kilos or more of any fruit, you get a 10% discount.
     * You should end up with at least 10 test cases. The first one is written for you.
     */


    private final Map<Fruit,Double> pricePerKilo = new HashMap<>();

    public PriceSetter setPriceOf(Fruit fruit){
        return new PriceSetter(this,fruit);
    }

    /**
     * to get the available fruits in the fruits shop.
     * Returns list of names of (type String)currently available fruits sorted in alphabetical order.
     */
public List<String> getAvailableFruits() {
    return pricePerKilo.keySet()
            .stream()
            .map(Enum::name)
            .sorted()
            .collect(Collectors.toList());
}
/**
 * to get the price of available fruits in the fruits shop.
 * Returns the price of available fruit in double ex : 3.00.
 * For example the prices per kilo for the currently available fruit are:
 *      * Apples: $4.00
 *      * Oranges: $5.50
 *      * Bananas: $6.00
 *      * Pears: $4.50
 *     ##### EXCEPTION #######################
 *      The Catalog should throw a FruitUnavailableException if the fruit is not currently available
 */
public Double getPrice(Fruit fruit){
    if(pricePerKilo.containsKey(fruit)) {
        return pricePerKilo.get(fruit);
    }
    throw new FruitUnAvailableException(fruit.name());
}
/**
 * You can update the catalog with the current market price of a fruit
 *
 * sets the price of a fruit. Done using a Method and a Builder InnerClass.
 * 1. public void setPrice(Fruit fruit,Double price){pricePerKilo.put(fruit, price);}
 * 2. using the Builder pattern InnerClass.
 *
 */
  public void setPrice(Fruit fruit,Double price){
      pricePerKilo.put(fruit, price);
  }

    public class PriceSetter {
      private final Catalog catalog;
      private final Fruit fruit;

        public PriceSetter(Catalog catalog, Fruit fruit) {
            this.catalog = catalog;
            this.fruit = fruit;
        }
        public Catalog to(Double price){
            catalog.pricePerKilo.put(fruit, price);
            return catalog;
        }
    }
}
