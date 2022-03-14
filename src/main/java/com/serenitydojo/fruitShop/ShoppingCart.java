package com.serenitydojo.fruitShop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Catalog catalog;
    private List<ItemInCart> goods;
    //public Double reducedPrice;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.goods = new ArrayList<ItemInCart>();
    }
    public AddToShoppingCart add(Double sum) { return new AddToShoppingCart(this, sum);
    }
    public class AddToShoppingCart {
        public  ShoppingCart shoppingCart;
        public Double sum;

        public AddToShoppingCart(ShoppingCart shoppingCart, Double sum) {
            this.shoppingCart = shoppingCart;
            this.sum = sum;
        }

        public ShoppingCart kiloFruit(Fruit fruit) {
            double normalPrice = shoppingCart.catalog.getPriceFruit(fruit);
            double reducedPrice = 0;
            if (sum >= 5) {
                reducedPrice = normalPrice * 0.9;
            }
            ItemInCart item = new ItemInCart(fruit, sum, reducedPrice * sum);
            shoppingCart.goods.add(item);
            return shoppingCart;
        }
    }
    public Double shoppingCartTotalCost() {
        return goods.stream().mapToDouble(ItemInCart::getTotal).sum();
    }
    public List<ItemInCart> getGoods() { return new ArrayList<>(goods);}


}

