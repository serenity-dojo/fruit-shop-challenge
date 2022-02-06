package com.serenitydojo;

import com.serenitydojo.fruitshop.Catalog;
import com.serenitydojo.fruitshop.Fruit;
import com.serenitydojo.fruitshop.ShoppingCart;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class WhenTestingFruitShopShoppingCart {

    private final Catalog catalog = new Catalog();
    private ShoppingCart shoppingCart;

    @Before
    public void setUpCatalog(){
        catalog.setPriceOf(Fruit.Apple).to(4.00)
                .setPriceOf(Fruit.Orange).to(5.50)
                .setPriceOf(Fruit.Banana).to(6.00)
                .setPriceOf(Fruit.Pear).to(4.50);
        shoppingCart = new ShoppingCart(catalog);
    }
    @Test
    public void shouldStartWithNoItems(){
        Assertions.assertThat(shoppingCart.getItems()).isEmpty();
    }
    @Test
    public void shouldAddItemsToTheCart(){
        shoppingCart.add(3.0).kilosOf(Fruit.Apple)
                .add(3.0).kilosOf(Fruit.Orange);
        Assertions.assertThat(shoppingCart.getItems()).hasSize(2);

    }
    @Test
    public void shouldUseTheCatalogToCalculateThePriceOfItemsAddedToTheCart(){
        catalog.setPriceOf(Fruit.Apple).to(3.00)
                .setPriceOf(Fruit.Orange).to(2.50);
        shoppingCart.add(1.00).kilosOf(Fruit.Apple)
                    .add(1.00).kilosOf(Fruit.Orange);
        Assertions.assertThat(shoppingCart.getTotalPrice()).isLessThanOrEqualTo(5.50);
    }
    @Test
    public void shouldKeepTrackOfTheTotalPrice(){
        catalog.setPriceOf(Fruit.Apple).to(3.00)
                .setPriceOf(Fruit.Orange).to(2.50);
        shoppingCart.add(1.00).kilosOf(Fruit.Apple)
                .add(1.00).kilosOf(Fruit.Orange);
        Assertions.assertThat(shoppingCart.getTotalPrice()).isEqualTo(5.50);
        shoppingCart.add(2.00).kilosOf(Fruit.Banana) //2 * 6.00
                .add(2.00).kilosOf(Fruit.Pear); // 2 * 4.50
        Assertions.assertThat(shoppingCart.getTotalPrice()).isEqualTo(26.50);
    }
    @Test
    public void shouldGiveBulkDiscount(){
        catalog.setPriceOf(Fruit.Apple).to(3.00);

        shoppingCart.add(10.00).kilosOf(Fruit.Apple);
        Assertions.assertThat(shoppingCart.getTotalPrice()).isLessThanOrEqualTo(27.00);
    }
    @Test
    public void shouldGiveDiscountsOnlyApplyToQuantitiesOverFiveKgs(){
        shoppingCart.add(5.0).kilosOf(Fruit.Banana)// 6
        .add(2.0).kilosOf(Fruit.Apple);// 4
        Assertions.assertThat(shoppingCart.getTotalPrice()).isEqualTo(35.00);
    }
}
