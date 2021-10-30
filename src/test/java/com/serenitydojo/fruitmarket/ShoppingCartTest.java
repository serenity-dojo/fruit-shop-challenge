package com.serenitydojo.fruitmarket;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static com.serenitydojo.fruitmarket.Fruits.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    Catalog catalog;
    ShoppingCart shoppingCart;

    @Before
    public void create_a_catalog() {
        HashMap<Fruits, Double> newCatalog = new HashMap<>();
        newCatalog.put(Apple, 4.00);
        newCatalog.put(Orange, 5.50);
        newCatalog.put(Banana, 6.00);

        catalog = new Catalog(newCatalog);
        shoppingCart = new ShoppingCart(catalog);
    }

    @Test
    public void check_shopping_cart_is_empty() {
        assertThat(shoppingCart.getItems()).isEmpty();
    }

    @Test
    public void total_cost_of_empty_shopping_cart_is_0() {
        assertThat(shoppingCart.getTotalPrice()).isEqualTo(0.00);
    }
    @Test
    public void add_item_to_shopping_cart() {

        shoppingCart.addItemToCart(Apple, 2.00);
        assertThat(shoppingCart.getItems()).hasSize(1);
        assertThat(shoppingCart.getItems().get(0).getFruit().name()).isEqualTo("Apple");

    }

    @Test
    public void buy_with_no_discount() {
        shoppingCart.addItemToCart(Orange, 2.00);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(11.00);

    }

    @Test
    public void buy_with_discount() {
        shoppingCart.addItemToCart(Orange, 10.00);

        assertThat(shoppingCart.getTotalPrice()).isEqualTo(49.50);
    }

    @Test
    public void calculate_total_cost_of_cart() {
        shoppingCart.addItemToCart(Banana, 3.00);
        shoppingCart.addItemToCart(Apple, 2.00);
        assertThat(shoppingCart.getTotalPrice()).isEqualTo(26.00);
    }
}
