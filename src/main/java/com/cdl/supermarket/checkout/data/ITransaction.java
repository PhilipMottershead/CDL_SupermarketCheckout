package com.cdl.supermarket.checkout.data;

public interface ITransaction {
    IBasket getBasket();
    void setBasket(IBasket basket);
    IBasket addItem(IItem item);
    void setCurrentOffers(CurrentOffers currentOffers);
    int getRunningTotal();
    int getFinalTotal();
    int calculateFinalTotal();
}
