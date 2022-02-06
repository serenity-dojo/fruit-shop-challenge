package com.serenitydojo;

import com.serenitydojo.fruitshop.Catalog;
import com.serenitydojo.fruitshop.Fruit;
import com.serenitydojo.fruitshop.FruitUnAvailableException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WhenTestingAFruitShopCatalog {

    Catalog catalog = new Catalog();

    @Test
    public void createANewCatalog(){
        catalog.setPriceOf(Fruit.Apple).to(4.00)
                .setPriceOf(Fruit.Orange).to(5.50)
                .setPriceOf(Fruit.Banana).to(6.00)
                .setPriceOf(Fruit.Pear).to(4.50);
        Assertions.assertThat(catalog.getAvailableFruits()).hasSize(4); //["Apple", "Banana", "Orange", "Pear"]

        catalog.setPrice(Fruit.Peache,7.00);
        Assertions.assertThat(catalog.getAvailableFruits()).hasSize(5); //["Apple", "Banana", "Orange", "Peaches","Pear"]
    }
    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit(){
        catalog.setPriceOf(Fruit.Apple).to(5.00);
        Assertions.assertThat(catalog.getPrice(Fruit.Apple)).isEqualTo(5.00);

        catalog.setPrice(Fruit.Peache,7.00);
        Assertions.assertThat(catalog.getPrice(Fruit.Peache)).isEqualTo(7.00);
    }
    @Test
    public void shouldReturnTheCorrectPriceOfAvailableEachFurit(){
        catalog.setPriceOf(Fruit.Apple).to(6.00)
       .setPriceOf(Fruit.Orange).to(3.50)
        .setPriceOf(Fruit.Banana).to(2.00)
        .setPriceOf(Fruit.Pear).to(1.50);
        Assertions.assertThat(catalog.getPrice(Fruit.Apple)).isEqualTo(6.00);
        Assertions.assertThat(catalog.getPrice(Fruit.Orange)).isEqualTo(3.50);
        Assertions.assertThat(catalog.getPrice(Fruit.Banana)).isEqualTo(2.00);
        Assertions.assertThat(catalog.getPrice(Fruit.Pear)).isEqualTo(1.50);
    }
    @Test(expected = FruitUnAvailableException.class)
    public void shouldReportAnExceptionIfAFruitIsNotAvailable(){
        catalog.getPrice(Fruit.Apple);
    }
}

