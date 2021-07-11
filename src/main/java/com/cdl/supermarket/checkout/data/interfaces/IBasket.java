package com.cdl.supermarket.checkout.data.interfaces;

import java.util.Map;
import java.util.Set;

/**
 * Interface to for the Basket Class
 */
public interface IBasket {
    Map<IItem, Integer> getBasket();
    Set<IItem> getItemsInBasket();
    int getAmountOfItemInBasket(IItem item);
    void setBasket(Map<IItem, Integer> basket);
    void addToBasket(IItem item);
}
