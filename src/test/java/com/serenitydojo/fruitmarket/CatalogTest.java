package com.serenitydojo.fruitmarket;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static com.serenitydojo.fruitmarket.Fruits.*;

public class CatalogTest {

    Catalog catalog;

    @Before
    public void create_a_catalog() {
        HashMap<Fruits, Double> newCatalog = new HashMap<>();
        newCatalog.put(Apple, 4.00);
        newCatalog.put(Orange, 5.50);
        newCatalog.put(Banana, 6.00);

        catalog = new Catalog(newCatalog);
    }

    @Test
    public void update_price_of_a_fruit() {

        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);

        catalog.setPriceOf(Apple, 3.45);
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(3.45);
    }

    @Test
    public void list_all_available_fruits() {

        assertThat(catalog.getAvailableFruits()).containsExactlyInAnyOrder("Apple", "Banana", "Orange");

    }

    @Test
    public void get_price_of_a_fruit() {

        assertThat(catalog.getPriceOf(Banana)).isEqualTo(6.00);
    }

    @Test(expected = FruitNotAvailableException.class)
    public void unavailable_fruit_exception() {

        assertThat(catalog.getPriceOf(Pear)).isEqualTo(4.50);
    }
}
