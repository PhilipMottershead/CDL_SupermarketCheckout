package com.cdl.supermarket.checkout.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to store information about transactions.
 */
public class Transaction implements ITransaction {

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    private Basket basket;

    private Map<Item,Offer> currentOffers;

    private int runningTotal;

    private int finalTotal;

    public Transaction() {
        basket = new Basket();
        currentOffers = new HashMap<>();
        runningTotal = 0;
        finalTotal = 0;
    }

    /**
     * Method called to update transaction with new item
     * @param item item to add to basket
     */
    public void addItem(Item item){
        basket.addToBasket(item);
        runningTotal = runningTotal + item.getUnitPrice();
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
