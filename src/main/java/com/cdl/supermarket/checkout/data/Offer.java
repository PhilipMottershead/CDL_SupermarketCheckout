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
        calculateDiscount();
    }

    public int getDiscount() {
        return discount;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
        calculateDiscount();
    }

    private void calculateDiscount(){
        discount = totalCost - (item.getUnitPrice() * requiredAmount);
        if(discount > 0){
            discount = 0;
        }
    }


    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
        calculateDiscount();
    }

    public void setItem(IItem item) {
        this.item = item;
        calculateDiscount();
    }
}
