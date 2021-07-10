package com.cdl.supermarket.checkout.data;

public interface IOffer {
    IItem getItem();
    void setItem(IItem item);
    int getRequiredAmount();
    void setRequiredAmount(int requiredAmount);
    int getTotalCost();
    void setTotalCost(int totalCost);
}
