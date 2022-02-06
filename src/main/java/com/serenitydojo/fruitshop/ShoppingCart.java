package com.serenitydojo.fruitshop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingCartItem> items;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }

    /**
     *
     * @param quantity : Enter the  quantiry of fruits to be purchased.
     * @return  : new ShoppingCartAdder(this,quantity);
     */

    public ShoppingCartAdder add(double quantity) {
        return new ShoppingCartAdder(this,quantity);
    }

    /**
     *
     * @return : list of ShoppingCartItems in the cart.
     */
    public List<ShoppingCartItem> getItems() {
        return items;
    }

    /**
     *
     * @return : Total Cost Price of all the fruits purchased from store.
     */
  public Double getTotalPrice(){
        return items.stream().mapToDouble((ShoppingCartItem ::getTotalCost)).sum();
  }

    public class ShoppingCartAdder {
        private final ShoppingCart shoppingCart;
        private final Double quantity;

        public ShoppingCartAdder(ShoppingCart shoppingCart, double quantity) {
            this.shoppingCart = shoppingCart;
            this.quantity = quantity;
        }

        public ShoppingCart kilosOf(Fruit fruit) {
            Double basePrice = shoppingCart.catalog.getPrice(fruit);
            Double discountedPrice = (quantity >= 5.0) ? basePrice * 0.9 : basePrice;
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem(fruit,quantity,discountedPrice * quantity);
            shoppingCart.items.add(shoppingCartItem);
            return shoppingCart;
        }
    }
}
