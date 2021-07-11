package com.cdl.supermarket.checkout.data;

import java.util.HashMap;
import java.util.Map;

public class CurrentOffers {
    private Map<IItem, IOffer> currentOffers;

    public CurrentOffers(Map<IItem, IOffer> currentOffers) {
        this.currentOffers = currentOffers;
    }

    public CurrentOffers() {
        this.currentOffers = new HashMap<>();
    }

    public void setCurrentOffers(Map<IItem, IOffer> currentOffers) {
        this.currentOffers = currentOffers;
    }

    public boolean hasOffer(IItem item){
        return currentOffers.containsKey(item);
    }

    public int calculateOfferDiscount(IItem item,IBasket basket){
        return calculateOffer(item,false,basket);
    }

    public int calculateFinalOfferDiscount(IItem item,IBasket basket){
        return  calculateOffer(item,true,basket);
    }

    public int calculateOffer(IItem item,boolean isFinalCheck,IBasket basket){
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
