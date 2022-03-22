package com.serenitydojo.fruitShopCartCalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenCheckingWhatIsInsideTheCatalog {
    Catalog catalog = new Catalog();

    @Before
    public void setUpTheCatalog(){
        catalog.addFruitWithPrice(Fruit.Banana, 4.5);
        catalog.addFruitWithPrice(Fruit.Abricot, 5.5);
        catalog.addFruitWithPrice(Fruit.Apple, 4.0);
        catalog.addFruitWithPrice(Fruit.Strawberry, 6.0);
    }

    //You can update the catalog with the current market price of a fruit
    @Test
    public void the_catalog_should_be_updatable_with_the_current_market_price_of_a_fruit(){
        catalog.updatedPriceOfAFruit(Fruit.Apple, 5.0);
        double applePrice = catalog.getPriceOf(Fruit.Apple);

        assertThat(applePrice).isEqualTo(5.0);
    }

    @Test
    public void The_catalog_should_list_the_names_of_the_currently_available_fruit_in_alphabetical_order() {
        catalog.addFruitWithPrice(Fruit.Cherry, 6.0);

        assertThat(catalog.getAllListedFruitsInAlphabeticalOrder()).hasSize(5);
        assertThat(catalog
                .getAllListedFruitsInAlphabeticalOrder())
                .containsExactly("Abricot", "Apple", "Banana", "Cherry", "Strawberry");
    }

    @Test
    public void the_catalog_should_report_the_price_of_a_given_fruit() {
        assertThat(catalog.getPriceOf(Fruit.Abricot)).isEqualTo(5.5);
    }

    @Test(expected = FruitUnavailableException.class)
    public void The_catalog_should_throw_a_FruitUnavailableException_if_the_fruit_is_not_currently_available () {
       catalog.getPriceOf(Fruit.Cherry);
    }


}

