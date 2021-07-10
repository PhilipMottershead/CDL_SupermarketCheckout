package com.cdl.supermarket.checkout.data;

public interface IOffer {
    Item getItem();
    int getRequiredAmount();
    int getTotalCost();
}
