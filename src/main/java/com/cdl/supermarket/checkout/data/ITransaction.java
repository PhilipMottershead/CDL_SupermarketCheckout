package com.cdl.supermarket.checkout.data;

import java.util.Map;

public interface ITransaction {
    Basket getBasket();
    Map<Item, Offer> getCurrentOffers();
    int getRunningTotal();
    int getFinalTotal();
}
