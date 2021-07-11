package com.cdl.supermarket.checkout.data;

import com.cdl.supermarket.checkout.data.interfaces.IBasket;
import com.cdl.supermarket.checkout.data.interfaces.IItem;

import java.util.*;

/**
 * Class to store items
 */
public class Basket implements IBasket {

    private Map<IItem,Integer> basket;

    public Basket() {
        this.basket = new HashMap<>();
    }

    public Map<IItem, Integer> getBasket() {
        return basket;
    }

    public int getAmountOfItemInBasket(IItem item){
        return basket.get(item);
    }


    public Set<IItem> getItemsInBasket(){
        return basket.keySet();
    }

    public void setBasket(Map<IItem, Integer> basket) {
        this.basket = basket;
    }

    public void addToBasket(IItem item){
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
