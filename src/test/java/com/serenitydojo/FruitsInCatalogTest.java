package com.serenitydojo;

import org.junit.Before;
import org.junit.Test;

import static com.serenitydojo.Fruits.*;
import static org.assertj.core.api.Assertions.*;

public class FruitsInCatalogTest {
    Catalog catalog;

    @Before
    public void CreateANewCatalog() {
        catalog = new Catalog();
        catalog.setPriceOf(APPLE).to(4.0)
                .setPriceOf(BANANA).to(8.0)
                .setPriceOf(PEAR).to(7.0)
                .setPriceOf(ORANGE).to(5.0);
    }

    @Test
    public void ICanViewAllFruitsInCatalog() {
        System.out.println("Catalog has -> " + catalog.getSortedListOfAvailableFruit());
    }
    
    @Test
    public void ICanPrintCatalog() {
        //System.out.println(catalog.getSortedListOfAvailableFruit());
        assertThat(catalog.getSortedListOfAvailableFruit()).containsExactly("APPLE", "BANANA", "ORANGE", "PEAR");
    }

    @Test
    public void ICanSearchForPriceOfAFruit() {
        Double applePrice = catalog.getPriceOfAFruitInCatalog(APPLE);
        assertThat(applePrice).isEqualTo(4.0);
    }

    @Test(expected = FruitUnavailableException.class)
    public void ICanViewExceptionIFAFruitNotInCatalog() {
       catalog.getPriceOfAFruitInCatalog(PEACH);
    }
}


