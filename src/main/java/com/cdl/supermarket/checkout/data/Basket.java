package com.cdl.supermarket.checkout.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class to store items
 */
public class Basket {

    private Map<Item,Integer> basket;

    public Basket() {
        this.basket = new HashMap<>();
    }

    public Map<Item, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Item, Integer> basket) {
        this.basket = basket;
    }

    public void addToBasket(Item item){
        if (basket.containsKey(item)) {
            int currentAmount = basket.get(item);
            basket.replace(item,++currentAmount);
        }else {
            basket.put(item,1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket1 = (Basket) o;
        return Objects.equals(basket, basket1.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basket);
    }
}
