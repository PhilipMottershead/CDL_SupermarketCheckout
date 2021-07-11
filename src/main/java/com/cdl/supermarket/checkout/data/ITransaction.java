package com.cdl.supermarket.checkout.data;

public interface ITransaction {
    IBasket getBasket();
    void setBasket(IBasket basket);
    IBasket addItem(IItem item);
    CurrentOffers getCurrentOffers();
    void setCurrentOffers(CurrentOffers currentOffers);
    void setRunningTotal(int runningTotal);
    int getRunningTotal();
    int getFinalTotal();
    int calculateFinalTotal();
}
