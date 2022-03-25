package com.serenitydojo.fruitShopCartCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenBuyingSomeFruits {
    Catalog catalog = new Catalog();
    ShoppingCart shoppingCart;


    @Before
    public void populating_the_catalog() {

        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Bananas, 4.5, 15);
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Abricots, 5.5, 23);
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Apples, 4.0, 57);
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Strawberries, 6.0, 8);
        shoppingCart = new ShoppingCart(catalog);
    }

    @Test
    public void adding_items_to_the_shopping_cart_keep_a_running_total() {
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Apples, 3.0);
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Bananas, 4.0);

        assertThat(shoppingCart.displayTheTotalOfTheCart()).isEqualTo(30);

    }

    @Test
    public void buying_5_kilos_or_more_of_any_fruit_get_a_10_percent_discount(){
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Strawberries, 6.0);

        assertThat(shoppingCart.displayTheTotalOfTheCart()).isEqualTo(32.4);
    }

    @Test
    public void discount_only_apply_on_fruit_with_more_than_5_kg_in_the_cart(){
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Strawberries, 6.0);
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Bananas, 3.0);

        assertThat(shoppingCart.displayTheTotalOfTheCart()).isEqualTo(45.9);
    }

    @Test
    public void buying_less_than_5_kilos_of_fruit_does_not_get_any_discount(){
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Strawberries, 4.0);

        assertThat(shoppingCart.displayTheTotalOfTheCart()).isEqualTo(24.0);
    }

    @Test
    public void if_the_weight_of_each_fruit_is_less_than_5kg_but_the_total_is_more_no_discount_is_apply(){
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Strawberries, 4.0);
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Bananas, 3.0);
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Apples, 3.0);

        assertThat(shoppingCart.displayTheTotalOfTheCart()).isEqualTo(49.5);
    }

    @Test(expected = FruitUnavailableException.class)
    public void The_catalog_should_throw_a_FruitUnavailableException_if_the_fruit_is_not_currently_available () throws Exception {
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Cherries, 4.2, 2);

        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Cherries, 6.0);
    }

}
