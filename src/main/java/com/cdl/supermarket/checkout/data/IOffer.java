package com.cdl.supermarket.checkout.data;

import com.cdl.supermarket.checkout.data.IItem;

public interface IOffer {
    void setItem(IItem item);
    int getRequiredAmount();
    void setRequiredAmount(int requiredAmount);
    void setTotalCost(int totalCost);
    int getDiscount();
}
