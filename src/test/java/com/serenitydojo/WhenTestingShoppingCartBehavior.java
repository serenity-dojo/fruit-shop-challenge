package com.serenitydojo;

import com.serenitydojo.Shop.Fruits;
import com.serenitydojo.Shop.FruitsCatalog;
import com.serenitydojo.booking.ShoppingCart;
import com.serenitydojo.exception.FruitUnAvailableException;
import org.junit.Test;

import static com.serenitydojo.Shop.Fruits.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WhenTestingShoppingCartBehavior {

    FruitsCatalog fruit = new FruitsCatalog();
    ShoppingCart shopItem = new ShoppingCart();

    @Test
    public void shouldBeAbleToPurchaseFruitsWithDiscount(){

        shopItem.addFruitToBasket(APPLE,5);
        shopItem.addFruitToBasket(ORANGE,5);
        shopItem.addFruitToBasket(BANANAS,5);

        assertThat(shopItem.getCartTotal()).isEqualTo(69.75);
    }

    @Test
    public void shouldBeAbleToPurchaseFruitsWithoutDiscount(){
        shopItem.addFruitToBasket(APPLE,4);
        shopItem.addFruitToBasket(ORANGE,4);
        shopItem.addFruitToBasket(BANANAS,4);

        assertThat(shopItem.getCartTotal()).isEqualTo((4*4)+(5.50*4)+(6*4));
    }

    @Test(expected = FruitUnAvailableException.class)
    public void shouldBeAbleToPurchaseFruitsWithoutDiscountAndIgnoreUnavailableItem(){
        shopItem.addFruitToBasket(APPLE,4);
        shopItem.addFruitToBasket(ORANGE,4);
        shopItem.addFruitToBasket(BANANAS,4);
        shopItem.addFruitToBasket(PEACHES,4);

        assertThat(shopItem.getCartTotal()).isEqualTo((4*4)+(5.50*4)+(6*4));
    }
}
