package com.cdl.supermarket.checkout.data;

import java.util.HashMap;
import java.util.Map;

public class CurrentOffers {
    private Map<IItem, IOffer> currentOffers;

    public CurrentOffers() {
        currentOffers = new HashMap<>();
    }

    public Map<IItem, IOffer> getCurrentOffers() {
        return currentOffers;
    }

    public void setCurrentOffers(Map<IItem, IOffer> currentOffers) {
        this.currentOffers = currentOffers;
    }

    public boolean hasOffer(IItem item){
        return currentOffers.containsKey(item);
    }

    public int applyOffer(IItem item,boolean isFinalCheck,IBasket basket){
        if (hasOffer(item)) {
            IOffer offer = currentOffers.get(item);
            int amount = basket.getAmountOfItemInBasket(item);
            int requiredAmount = offer.getRequiredAmount();
            if (amount % requiredAmount == 0) {
                if(isFinalCheck){
                    return offer.getDiscount() * amount / requiredAmount;
                }else {
                    return offer.getDiscount();
                }
            }
        }
        return 0;
    }



}
