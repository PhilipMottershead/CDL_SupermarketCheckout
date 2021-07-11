package com.cdl.supermarket.checkout.data;

/**
 * Class to store information about special offers
 */
public class Offer implements IOffer {

    private IItem item;

    private int requiredAmount;

    private int totalCost;

    private int discount;

    public Offer(IItem item, int requiredAmount, int totalCost) {
        this.item = item;
        this.requiredAmount = requiredAmount;
        this.totalCost = totalCost;
        this.discount = totalCost - (item.getUnitPrice() * requiredAmount);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public IItem getItem() {
        return item;
    }

    public void setItem(IItem item) {
        this.item = item;
    }
}
