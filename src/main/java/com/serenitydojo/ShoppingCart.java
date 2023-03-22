package com.serenitydojo;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final Catalog catalog;
    private final List<CatalogItem> items = new ArrayList<>();

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
    }

    public double getTotal() {
        double sum = items.stream().mapToDouble(it -> catalog.getPriceOf(it.getFruit()) * it.getAmountInKg()).sum();
        int amountInKg = items.stream().mapToInt(CatalogItem::getAmountInKg).sum();
        if (amountInKg <= 5) {
            return sum;
        } else {
            int discountInPercent = 10;
            return sum * (1 - (discountInPercent/ 100.));
        }
    }

    public void addItem(Fruit fruit, int amountInKg) {
        items.add(catalog.getFruit(fruit, amountInKg));
    }
}
