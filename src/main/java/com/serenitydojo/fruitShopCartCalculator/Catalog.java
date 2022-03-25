package com.serenitydojo.fruitShopCartCalculator;

import java.util.*;
import java.util.stream.Collectors;

public class Catalog {

    Map<Fruit, Double> fruitWithPrice = new HashMap<>();
    Map<Fruit, Double> fruitWithQuantity = new HashMap<>();

    public void addFruitWithPriceAndQuantityInTheCatalog(Fruit fruit, double price, double quantity) {
        fruitWithPrice.put(fruit, price);
        fruitWithQuantity.put(fruit, quantity);
    }

    public double getPriceOf(Fruit fruit) {
        return fruitWithPrice.get(fruit);
    }

    public void updatedPriceOfAFruit(Fruit fruit, double price) {
        fruitWithPrice.replace(fruit, price);
    }

    public void updateQuantityOfAFruit(Fruit fruit, double quantity) {
        fruitWithQuantity.replace(fruit, quantity);
    }

    public double getQuantityOf(Fruit fruit) {
        double quantityOfFruit = fruitWithQuantity.get(fruit);

        isThereEnoughFruitsToAddInTheCart(quantityOfFruit, fruit);

        return quantityOfFruit;
    }

    public List<String> getAllListedFruitsInAlphabeticalOrder() {
        List <String> listInAlphabeticalOrder = new ArrayList<>();

        for (Map.Entry<Fruit, Double> fruit : fruitWithPrice.entrySet()) {
            listInAlphabeticalOrder.add(fruit.getKey().toString());
        }

        return listInAlphabeticalOrder.stream().sorted().collect(Collectors.toList());
    }

    protected Double calculateRemainingQuantity(Fruit fruit, Double quantityInKiloPutInTheCart) {
        Double remainingQuantity = getQuantityOf(fruit) - quantityInKiloPutInTheCart;
        updateQuantityOfAFruit(fruit, remainingQuantity);

        return getQuantityOf(fruit);
    }

    //Simple case : if there is 2kg left in the shop but the consumer want to put 3kg, it returns an exception
    //In reality it should add the 2kg to the cart and calculate the running total
    private void isThereEnoughFruitsToAddInTheCart(Double remainingQuantity, Fruit fruit) {
        if(remainingQuantity.compareTo(0.0) < 0 || remainingQuantity.compareTo(0.0) == 0) {
            throw new FruitUnavailableException("There is no more or not enough " + fruit);
        }
    }


}
