package com.cdl.supermarket.checkout.data;

import java.util.Map;

/**
 * Interface to for the Basket Class
 */
public interface IBasket {
    Map<IItem, Integer> getBasket();
    void setBasket(Map<IItem, Integer> basket);
    void addToBasket(IItem item);
}
