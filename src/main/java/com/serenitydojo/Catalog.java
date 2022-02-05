package com.serenitydojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {
    Map<Fruits, Double> fruitsInCatalog = new HashMap<>();
    Double totalPrice;


    public setPriceOfAFruit setPriceOf(Fruits fruit) {
        return new setPriceOfAFruit(this, fruit);
    }

    public static class setPriceOfAFruit {
        private final Catalog catalog;
        private final Fruits fruits;

        public setPriceOfAFruit(Catalog catalog, Fruits fruit) {
            this.catalog = catalog;
            this.fruits = fruit;
        }

        public Catalog to(Double price) {
            catalog.fruitsInCatalog.put(fruits, price);
            return catalog;
        }
    }

    public Double getPriceOfAFruitInCatalog(Fruits fruitName) {
        if (fruitsInCatalog.containsKey(fruitName)) {
            return fruitsInCatalog.get(fruitName);
        }
        throw new FruitUnavailableException(fruitName.name() + " is not available");
    }

    public Double getTotalPriceOfCatalog() {
        return fruitsInCatalog.values()
                .stream()
                .reduce(0.0, Double::sum);
    }

    public List<String> getSortedListOfAvailableFruit() {
        return fruitsInCatalog.keySet()
                .stream()
                .map(Enum::name)
                .sorted()
                .collect(Collectors.toList());
    }

}



