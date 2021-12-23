package com.serenitydojo;

import com.serenitydojo.Shop.Fruits;
import com.serenitydojo.Shop.FruitsCatalog;
import com.serenitydojo.exception.FruitUnAvailableException;
import org.junit.Test;

import java.util.List;

import static com.serenitydojo.Shop.Fruits.*;
import static org.assertj.core.api.Assertions.*;

public class WhenUpdatingCatalogForMarketPrice {

    FruitsCatalog fruit = new FruitsCatalog();

    @Test
    public void shouldUpdateTheCatalogWithPriceForAGivenFruit(){
        fruit.updateCatatlogWithMarketpriceFor(APPLE,4);
    }

    @Test(expected = FruitUnAvailableException.class)
    public void shouldNotUpdateTheCatalogWithAFruitDoesNotExist(){
        fruit.updateCatatlogWithMarketpriceFor(PEACHES,4);
    }

    @Test
    public void shouldBeAbleToRetrieveThePriceForAGiveFruit(){
        double priceForOrage = fruit.getPriceForFruit(ORANGE);
        assertThat(priceForOrage).isEqualTo(5.50);
    }

    @Test(expected = FruitUnAvailableException.class)
    public void shouldGetExceptionWhenFruitDoesNotExist(){
        double priceForOrage = fruit.getPriceForFruit(PEACHES);
        assertThat(priceForOrage).isEqualTo(5.50);
    }

    @Test
    public void shouldGetTheListOfFruitsInShop(){
        List<Fruits> listOfFruits = fruit.getListOfFruitsInShop();
        System.out.println(listOfFruits);
        //assertThat(listOfFruits).containsExactlyInAnyOrder(APPLE,ORANGE,PEARS,BANANAS);
    }

    @Test
    public void shouldNotContainPeachesInFruitsInShop(){
        List<Fruits> listOfFruits = fruit.getListOfFruitsInShop();
        assertThat(listOfFruits).doesNotContain(PEACHES);
    }

}
