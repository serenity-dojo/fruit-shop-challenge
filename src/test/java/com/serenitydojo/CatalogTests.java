package com.serenitydojo;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;
import static com.serenitydojo.FruitName.*;

public class CatalogTests {

    Catalog initialCatalog;

    @Before
    public void initialCatalogStock() {

        ArrayList<Fruit> initialStock = new ArrayList<>();
        Fruit apple = new Fruit(APPLE, 4.0);
        Fruit orange = new Fruit(ORANGE, 5.0);
        Fruit pear = new Fruit(PEAR, 4.0);
        Fruit banana = new Fruit(BANANA, 5.5);

        initialStock.add(apple);
        initialStock.add(orange);
        initialStock.add(pear);
        initialStock.add(banana);
        initialCatalog = new Catalog(initialStock);

    }

    @Test
    public void checkAvailableCatalogFruitNames() {
        assertThat(initialCatalog.getSortedFruitCatalog()).containsExactly("APPLE", "BANANA", "ORANGE", "PEAR");
    }

    @Test
    public void confirmFruitIsAvailableInCatalog() throws Exception{
        assertThat(initialCatalog.catalogContainsFruit(APPLE)).isEqualTo("The fruit is in Catalog!");
    }

    @Test(expected = FruitUnavailableException.class)
    public void whenFruitIsNotAvailableInCatalog() throws Exception{
        assertThat(initialCatalog.catalogContainsFruit(KIWI)).isEqualTo("kiwi");
    }

    @Test
    public void addFruitToCatalog(){
        initialCatalog.addFruitToCatalog(WATER_MELON, 7.0);
        assertThat(initialCatalog.getSortedFruitCatalog()).containsExactly("APPLE", "BANANA", "ORANGE", "PEAR", "WATER_MELON");
    }

    @Test
    public void checkFruitPrice() throws Exception{
        assertThat(initialCatalog.getFruitPrice(BANANA)).isEqualTo(5.5);
    }

    @Test(expected = FruitPriceException.class)
    public void cannotGetPriceOfUnavailableFruit() throws Exception{
        assertThat(initialCatalog.getFruitPrice(KIWI)).isEqualTo(5.5);
    }

    @Test
    public void checkUpdatedFruitPrice() throws Exception{
        assertThat(initialCatalog.getFruitPrice(BANANA)).isEqualTo(5.5);
        initialCatalog.updateFruitPrice(BANANA, 6.0);
        assertThat(initialCatalog.getFruitPrice(BANANA)).isEqualTo(6.0);
    }

    @Test(expected = FruitPriceException.class)
    public void updatedFruitPriceMustBePositiveNumber() throws Exception{
        initialCatalog.updateFruitPrice(BANANA, -2.0);
    }
}