package com.cdl.supermarket.checkout.data;

import java.util.Map;

public interface IBasket {

    Map<IItem, Integer> getBasket();
    void addToBasket(IItem item);
}
