package com.cdl.supermarket.checkout.data;

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
}
