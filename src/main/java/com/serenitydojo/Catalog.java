package com.serenitydojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Contains list of currently available items: name, price
public class Catalog {

    private ArrayList<Fruit> fruitCatalog;

    public Catalog(ArrayList<Fruit> fruitCatalog) {
        this.fruitCatalog = fruitCatalog;
    }

    // Add a fruit to Catalog stock
    public void addFruitToCatalog(FruitName name, double price) {
        Fruit addNewFruit = new Fruit(name, price);
        fruitCatalog.add(addNewFruit);
    }

    // Sort current catalog item list
    public List<String> getSortedFruitCatalog() {
        List<String> sortedCatalog = new ArrayList<>();

        for(Fruit fruit : fruitCatalog) {
            sortedCatalog.add(fruit.getName().toString());
        }

        Collections.sort(sortedCatalog);

        return sortedCatalog;
    }

    // Get price of a given fruit
    // Throw an exception if a fruit is not in the Catalog
    public double getFruitPrice(FruitName name) throws FruitPriceException{
        double fruitPrice = 0;
        ArrayList<FruitName> availableFruits = new ArrayList<>();
        for(Fruit fruit : fruitCatalog) {
            availableFruits.add(fruit.getName());
        }

        for(Fruit fruit : fruitCatalog){
            if(!availableFruits.contains(name)) {
                throw new FruitPriceException("Cannot get a price of an unavailable fruit!");
            } else if (fruit.getName().equals(name)) {
                return fruit.getPrice();
            }
        }
        return fruitPrice;
    }

    // Get price of a given fruit
    // Throw an exception if a fruit is not in the Catalog
    public double updateFruitPrice(FruitName name, double newPrice) throws FruitPriceException {
        double updatedPrice = 0;
        if (newPrice <= 0){
            throw new FruitPriceException("Price cannot be 0 or a negative number!");
        } else {
            for (Fruit fruit : fruitCatalog) {
                if (fruit.getName().equals(name)) {
                    fruit.setPrice(newPrice);
                    return fruit.getPrice();
                }
            }
            return updatedPrice;
        }
    }

    // Check if a given fruit is in catalog list
    // Throw an exception if a fruit is unavailable
    public String catalogContainsFruit(FruitName name) throws FruitUnavailableException {
        String fruitAvailability = "";
        for (Fruit fruit : fruitCatalog) {
            if (fruit.getName() == name) {
                return "The fruit is in Catalog!";
            } else {
                throw new FruitUnavailableException("Fruit name not in catalog!");
            }
        }
        return fruitAvailability;
    }
}