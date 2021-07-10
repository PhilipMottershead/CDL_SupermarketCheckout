package com.cdl.supermarket.checkout.data;

public interface IOffer {
    IItem getItem();
    int getRequiredAmount();
    int getTotalCost();
}
