package com.cdl.supermarket.checkout.data;

import com.cdl.supermarket.checkout.data.interfaces.IItem;
import com.cdl.supermarket.checkout.data.interfaces.IOffer;

import java.util.Map;

public class CurrentOffers {
    private Map<IItem, IOffer> currentOffers;

    public Map<IItem, IOffer> getCurrentOffers() {
        return currentOffers;
    }

    public void setCurrentOffers(Map<IItem, IOffer> currentOffers) {
        this.currentOffers = currentOffers;
    }

    public boolean hasOffer(IItem item){
        return currentOffers.containsKey(item);
    }
}
