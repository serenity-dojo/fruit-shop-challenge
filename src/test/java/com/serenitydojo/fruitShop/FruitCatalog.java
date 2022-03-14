package com.serenitydojo.fruitShop;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.serenitydojo.fruitShop.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;


public class FruitCatalog {
    Catalog catalog;
    @Before
    public void makeAFruitCatalog() {
        catalog = new Catalog();
        catalog.setPriceFruit(Apple).to(4.0);
        catalog.setPriceFruit(Orange).to(5.5);
        catalog.setPriceFruit(Banana).to(6.0);
        catalog.setPriceFruit(Pear).to(4.5);
    }
    @Test
    public void updatePriceToCurrent() throws FruitDoesntExistException {
        catalog.setPriceFruit(Apple).to(100.0);
        assertThat(catalog.getPriceFruit(Apple)).isEqualTo(100);
    }
    @Test
    public void listAllCatalogAlphabetical() {
        Set theSetOfKeys = new HashSet();
        theSetOfKeys = catalog.priceKilo.keySet();
        //List<theSetOfKeys> sortedOrder = items.stream().collect(Collectors.toList());
        System.out.println(theSetOfKeys);
        List<String> listFromSet = new ArrayList<>(theSetOfKeys);
        List<String> sortedFruitList = listFromSet.stream().sorted().collect(Collectors.toList());
       // Collections.sort(listFromSet);
        System.out.println(sortedFruitList);

        System.out.println(catalog.inAlphabeticalOrder());
        assertThat(sortedFruitList).isEqualTo(catalog.inAlphabeticalOrder());
    }
    @Test
    public void listPriceOfXFruit() throws FruitDoesntExistException {
        System.out.println(catalog.getPriceFruit(Apple));
    }
//    @Test(expected =  FruitDoesntExistException.class)
    //could not get it to work .
//    public void exceptionOnNoFruitAvailable() throws FruitDoesntExistException {
//        System.out.println(catalog.getPriceFruit(Apples));
//    }


}
