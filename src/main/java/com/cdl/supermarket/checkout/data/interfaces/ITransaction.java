package com.cdl.supermarket.checkout.data.interfaces;

import java.util.Map;

public interface ITransaction {
    IBasket getBasket();
    void setBasket(IBasket basket);
    void addItem(IItem item);
    Map<IItem, IOffer> getCurrentOffers();
    void setCurrentOffers(Map<IItem, IOffer> currentOffers);
    void setRunningTotal(int runningTotal);
    int getRunningTotal();
    int getFinalTotal();
}
