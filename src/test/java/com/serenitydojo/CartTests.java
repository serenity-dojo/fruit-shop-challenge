package com.serenitydojo;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.*;
import static com.serenitydojo.FruitName.*;

public class CartTests {

    Catalog initialCatalog;
    Cart shoppingCart;

    @Before
    public void initialCartContent() {

        ArrayList<Fruit> initialStock = new ArrayList<>();
        HashMap<FruitName, Double> initialCartState = new HashMap<>();

        Fruit apple = new Fruit(APPLE, 4.0);
        Fruit orange = new Fruit(ORANGE, 5.0);
        Fruit pear = new Fruit(PEAR, 4.0);
        Fruit banana = new Fruit(BANANA, 5.5);

        initialStock.add(apple);
        initialStock.add(orange);
        initialStock.add(pear);
        initialStock.add(banana);

        initialCatalog = new Catalog(initialStock);
        shoppingCart = new Cart(initialCartState);
    }

    @Test
    public void initialCartShouldBeEmpty(){
        assertThat(shoppingCart.getCartContents()).isEmpty();
    }


    @Test
    public void addedItemShouldBeInCart() throws FruitPriceException {
        shoppingCart.addItemToCart(APPLE, initialCatalog.getFruitPrice(APPLE), 2);
        assertThat(shoppingCart.getCartContents().containsKey(APPLE)).isTrue();
    }

    @Test
    public void addDiscountWhenClientBuysMoreThanFiveKilos() throws FruitPriceException {
        double applePrice = initialCatalog.getFruitPrice(APPLE);
        shoppingCart.addItemToCart(APPLE, applePrice, 6);

        assertThat(shoppingCart.getCartContents().get(APPLE)).isEqualTo(applePrice*6*0.9);
    }

    @Test
    public void checkClientCartTotalValue() throws FruitPriceException {
        shoppingCart.addItemToCart(APPLE, initialCatalog.getFruitPrice(APPLE), 6);
        assertThat(shoppingCart.cartTotal()).isEqualTo(6*4*0.9);

        shoppingCart.addItemToCart(PEAR, initialCatalog.getFruitPrice(PEAR), 2);
        assertThat(shoppingCart.cartTotal()).isEqualTo(6*4*0.9+2*4);
    }
}