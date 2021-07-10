package com.cdl.supermarket.checkout.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to store information about transactions.
 */
public class Transaction {

    private Map<Item,Integer> basket;

    private Map<Item,Offer> currentOffers;

    private int runningTotal;

    private int finalTotal;

    public Transaction() {
        basket = new HashMap<>();
        currentOffers = new HashMap<>();
        runningTotal = 0;
        finalTotal = 0;
    }

    /**
     * Add item to basket
     * @param item item to add to basket
     */
    public void addToBasket(Item item){
        if (basket.containsKey(item)) {
            int currentAmount = basket.get(item);
            basket.replace(item,++currentAmount);
        }else {
            basket.put(item,1);
        }
        runningTotal = runningTotal + item.getUnitPrice();

    }


    public Map<Item, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Item, Integer> basket) {
        this.basket = basket;
    }

    public Map<Item, Offer> getCurrentOffers() {
        return currentOffers;
    }

    public void setCurrentOffers(Map<Item, Offer> currentOffers) {
        this.currentOffers = currentOffers;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public int getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(int finalTotal) {
        this.finalTotal = finalTotal;
    }
}
