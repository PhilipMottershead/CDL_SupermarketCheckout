package com.cdl.supermarket.checkout.data;

import java.util.Map;

/**
 * Class to store information about transactions.
 */
public class Transaction {

    private Map<Item,Integer> basket;

    private Map<Item,Offer> currentOffers;

    private int runningTotal;

    private int finalTotal;

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
