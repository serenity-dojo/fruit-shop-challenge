package com.serenitydojo.fruitmarket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {

    private Map<Fruits, Double> fruitCatalog;

    public Catalog(Map<Fruits, Double> fruitCatalog) {
        this.fruitCatalog = fruitCatalog;
    }

    public List<String> getAvailableFruits() {
        return fruitCatalog.keySet()
                .stream()
                .map(Enum::name)
                .sorted()
                .collect(Collectors.toList());
    }

    public double getPriceOf(Fruits fruit) {
        if(fruitCatalog.containsKey(fruit)) {
            return fruitCatalog.get(fruit);
        }
        throw new FruitNotAvailableException(fruit.name() + " is not available");
    }

    public void setPriceOf(Fruits fruit, Double price) {
        if(fruitCatalog.containsKey(fruit)) {
            fruitCatalog.replace(fruit, price);
        }
    }


}
