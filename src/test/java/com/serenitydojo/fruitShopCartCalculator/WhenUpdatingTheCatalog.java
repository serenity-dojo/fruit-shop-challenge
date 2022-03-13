package com.serenitydojo.fruitShopCartCalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenUpdatingTheCatalog {

    @Test
    public void it_is_possible_to_add_a_fruit_and_its_price_in_the_catalog(){
        Catalog catalog = new Catalog();

        //Given Oliver there is fruits in the catalog
        catalog.addFruitWithPrice(Fruit.Apple, 4.0);

        //When oliver ask the price of a particular fruit
        double price = catalog.priceOf(Fruit.Apple);

        //Then Oliver gets the price of the fruit
        assertThat(price).isEqualTo(4.0);
    }


}
