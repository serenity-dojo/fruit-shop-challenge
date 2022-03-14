package com.serenitydojo.fruitShop;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.fruitShop.Fruit.*;

public class AShoppingCart {
    Catalog catalog;
    ShoppingCart shoppingCart;
    @Before
    public void makeAFruitCatalog() {
        catalog = new Catalog();
        catalog.setPriceFruit(Apple).to(4.0);
        catalog.setPriceFruit(Orange).to(5.5);
        catalog.setPriceFruit(Banana).to(6.0);
        catalog.setPriceFruit(Pear).to(4.5);
        shoppingCart = new ShoppingCart(catalog);
    }
    @Test
    public void addItemsAndTrackThem() {
        //also checks it starts on 0
        Assertions.assertThat(shoppingCart.getGoods()).hasSize(0);
        shoppingCart.add(10.0).kiloFruit(Apple);
        Assertions.assertThat(shoppingCart.getGoods()).hasSize(1);
    }
    @Test
    public void totalPriceChecker() {
        System.out.println(shoppingCart.shoppingCartTotalCost());
        shoppingCart.add(4.2).kiloFruit(Apple);
        shoppingCart.add(5.0).kiloFruit(Banana);
        System.out.println(shoppingCart.shoppingCartTotalCost());
    }
    @Test
    public void checkTheDiscount() {
        //also checks it doesnt work for < 5.
        shoppingCart.add(5.0).kiloFruit(Apple);
        Assertions.assertThat(3 * catalog.getPriceFruit(Apple) == shoppingCart.shoppingCartTotalCost());
        System.out.println(5 * catalog.getPriceFruit(Apple));
        shoppingCart.add(2.0).kiloFruit(Apple);
        System.out.println(shoppingCart.shoppingCartTotalCost());
        Assertions.assertThat(5 * catalog.getPriceFruit(Apple) < shoppingCart.shoppingCartTotalCost());

    }


}
