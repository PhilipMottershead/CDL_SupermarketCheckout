package com.cdl.supermarket.checkout.data;

import java.util.Map;

public interface ITransaction {
    IBasket getBasket();
    void setBasket(IBasket basket);
    void addItem(IItem item);
    CurrentOffers getCurrentOffers();
    void setCurrentOffers(CurrentOffers currentOffers);
    void setRunningTotal(int runningTotal);
    int getRunningTotal();
    int getFinalTotal();
    int calculateFinalTotal();
}
