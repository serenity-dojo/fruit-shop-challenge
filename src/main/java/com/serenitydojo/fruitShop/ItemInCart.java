package com.serenitydojo.fruitShop;

public class ItemInCart {
    public Fruit fruit;
    public Double amount;
    public Double totals;

    public ItemInCart(Fruit fruit, Double amount, Double totals) {
        this.fruit = fruit;
        this.amount = amount;
        this.totals = totals;
    }
    public Fruit getFruit() {return  fruit;};
    public  Double getAmount() {return amount;};
    public Double getTotal() {return  totals;};
}
