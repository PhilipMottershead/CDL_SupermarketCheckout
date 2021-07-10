package com.cdl.supermarket.checkout.data;

/**
 * Class to store information about special offers
 */
public class Offer {

    private Item item;

    private int requiredAmount;

    private int totalCost;

    public Offer(Item item, int requiredAmount, int totalCost) {
        this.item = item;
        this.requiredAmount = requiredAmount;
        this.totalCost = totalCost;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
