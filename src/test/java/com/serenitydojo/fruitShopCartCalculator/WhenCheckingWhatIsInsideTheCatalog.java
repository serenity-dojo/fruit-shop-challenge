package com.serenitydojo.fruitShopCartCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenCheckingWhatIsInsideTheCatalog {
    Catalog catalog = new Catalog();

    @Before
    public void setUpTheCatalog(){

        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Bananas, 4.5, 15);
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Abricots, 5.5, 23);
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Apples, 4.0, 57);
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Strawberries, 6.0, 8);
    }

    @Test
    public void the_catalog_should_be_updatable_with_the_current_market_price_of_a_fruit(){
        catalog.updatedPriceOfAFruit(Fruit.Apples, 5.0);
        double applePrice = catalog.getPriceOf(Fruit.Apples);

        assertThat(applePrice).isEqualTo(5.0);
    }

    @Test
    public void The_catalog_should_list_the_names_of_the_currently_available_fruit_in_alphabetical_order() {
        catalog.addFruitWithPriceAndQuantityInTheCatalog(Fruit.Cherries, 6.0, 42);

        assertThat(catalog.getAllListedFruitsInAlphabeticalOrder()).hasSize(5);
        assertThat(catalog
                .getAllListedFruitsInAlphabeticalOrder())
                .containsExactly("Abricots", "Apples", "Bananas", "Cherries", "Strawberries");
    }

    @Test
    public void the_catalog_should_report_the_price_of_a_given_fruit() {
        assertThat(catalog.getPriceOf(Fruit.Abricots)).isEqualTo(5.5);
    }

    @Test
    public void it_should_be_possible_to_know_the_right_amount_of_quantity_left_someone_bought_some_fruits(){
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addFruitsIntoTheCartAndGetThePrice(Fruit.Apples, 6.0);

        assertThat(catalog.getQuantityOf(Fruit.Apples)).isEqualTo(51.0);
    }


}

