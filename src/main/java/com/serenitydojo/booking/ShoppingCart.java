package com.serenitydojo.booking;

import com.serenitydojo.Shop.Fruits;
import com.serenitydojo.Shop.FruitsCatalog;
import com.serenitydojo.exception.FruitUnAvailableException;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private double totalPriceOfItemsInCart;
    private double discount;
    private final Map<Fruits, Integer> fruitAndQuantityAddedToBasket = new HashMap<>();
    public FruitsCatalog fruitsCatalog = new FruitsCatalog();

    public double getCartTotal() {
        return totalPriceOfItemsInCart;
    }

    public void addFruitToBasket(Fruits fruit, int quantity) {
        if (fruitsCatalog.getListOfFruitsInShop().contains(fruit)) {
            fruitAndQuantityAddedToBasket.put(fruit, quantity);
            calculateTotal(fruit, quantity);
        } else {
            throw new FruitUnAvailableException(fruit + " Is not available in shop");
        }
    }

    private void calculateTotal(Fruits fruit, int quantity) {
        discount = checkIfDiscountIsApplicable(quantity);
        totalPriceOfItemsInCart += (fruitsCatalog.getPriceForFruit(fruit) * quantity * discount);
    }

    private double checkIfDiscountIsApplicable(int quantity) {
        discount = quantity >= 5 ? 0.90 : 1;
        return discount;
    }


}
