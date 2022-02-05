package com.serenitydojo;

import org.junit.Test;
import org.junit.Before;
import static com.serenitydojo.Fruits.*;
import static org.assertj.core.api.Assertions.*;



public class ItemsInShoppingCart {

    Catalog catalog;
    ShoppingCart cart;

    @Before
    public void CreateANewCatalog() {
        catalog = new Catalog();
        catalog.setPriceOf(APPLE).to(4.00)
                .setPriceOf(ORANGE).to(5.50)
                .setPriceOf(BANANA).to(4.50)
                .setPriceOf(PEAR).to(4.50);

        cart = new ShoppingCart(catalog);
    }


    @Test
    public void shouldStartWithNoItems() {
        assertThat(cart.getItems()).isEmpty();
    }

    @Test
    public void shouldKeepTrackOfItemsAddedToTheCart() {
        cart.add(2.0).kgOf(APPLE)
                .add(3.0).kgOf(ORANGE);

        assertThat(cart.getItems()).hasSize(2);
    }

    @Test
    public void shouldUseTheCatalogToCalculateThePriceOfItemsAddedToTheCart() {
        cart.add(2.0).kgOf(APPLE)
                .add(2.0).kgOf(ORANGE)
                .add(1.0).kgOf(PEAR);

        assertThat(cart.getTotalPrice()).isEqualTo(23.50);
    }

    @Test
    public void shouldKeepTrackOfTheTotalPrice() {
        cart.add(2.0).kgOf(APPLE);
        ShoppingCartItem apples = cart.getItems().get(0);
        assertThat(apples.getFruit()).isEqualTo(APPLE);
        assertThat(apples.getQuantity()).isEqualTo(2.0);
        assertThat(apples.getTotalCost()).isEqualTo(8.00);
    }

    @Test
    public void discountApplyIfFruitIs5KgOrAbove() {
        cart.add(10.0).kgOf(APPLE);
        System.out.println(catalog.fruitsInCatalog);
        System.out.println(cart.getTotalPrice());

        assertThat(cart.getTotalPrice()).isEqualTo(36.00);
    }

    @Test
    public void discountsOnlyApplyIfFruitIs5KgOrMore() {
        cart.add(2.00).kgOf(APPLE);
        cart.add(6.00).kgOf(ORANGE);

        assertThat(cart.getTotalPrice()).isEqualTo(37.70);
    }

}
