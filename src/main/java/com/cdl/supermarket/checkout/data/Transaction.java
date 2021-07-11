package com.cdl.supermarket.checkout.data;

import com.cdl.supermarket.checkout.data.interfaces.IBasket;
import com.cdl.supermarket.checkout.data.interfaces.IItem;
import com.cdl.supermarket.checkout.data.interfaces.IOffer;
import com.cdl.supermarket.checkout.data.interfaces.ITransaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class to store information about transactions.
 */
public class Transaction implements ITransaction {

    public IBasket getBasket() {
        return basket;
    }

    public void setBasket(IBasket basket) {
        this.basket = basket;
    }

    private IBasket basket;

    private Map<IItem, IOffer> currentOffers;

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
    public void addItem(IItem item){
        basket.addToBasket(item);
        runningTotal = runningTotal + item.getUnitPrice();
        runningTotal = runningTotal + applyOffer(item);
    }

    public int applyOffer(IItem item){
        boolean hasOffer = currentOffers.containsKey(item);
        if (hasOffer) {
            IOffer offer = currentOffers.get(item);
            int amount = basket.getAmountOfItemInBasket(item);
            int requiredAmount = offer.getRequiredAmount();
            if (amount % requiredAmount == 0) {
                return offer.getDiscount();
            }
        }
        return 0;
    }

    public int calculateFinalTotal(){
        Set<IItem> items = basket.getItemsInBasket();
        for (IItem item : items) {
            finalTotal = finalTotal + item.getUnitPrice();
            finalTotal = finalTotal + applyOffer(item);
        }
        return finalTotal;
    }


    public Map<IItem, IOffer> getCurrentOffers() {
        return currentOffers;
    }

    public void setCurrentOffers(Map<IItem, IOffer> currentOffers) {
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
