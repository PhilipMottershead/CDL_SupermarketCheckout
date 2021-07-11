package com.cdl.supermarket.checkout.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class OfferTest {

    private final static IItem ITEM_A = new Item('A', 50);
    private final static IItem ITEM_B = new Item('B', 30);

    private IOffer offer;

    @BeforeEach
    public void setup(){
            offer =  new Offer(ITEM_A,3,130);
    }

    @Test
    public void testCalculateDiscount(){
        assertThat(offer.getDiscount()).isEqualTo(-20);
    }

    @Test
    public void testCalculateDiscount2(){
        offer.setRequiredAmount(4);
        assertThat(offer.getDiscount()).isEqualTo(-70);
    }

    @Test
    public void testCalculateDiscount3(){
        offer.setRequiredAmount(2);
        assertThat(offer.getDiscount()).isEqualTo(0);
    }

    @Test
    public void testCalculateDiscount4(){
        offer.setTotalCost(100);
        assertThat(offer.getDiscount()).isEqualTo(-50);
    }

    @Test
    public void testCalculateDiscount5(){
        offer.setItem(ITEM_B);
        offer.setRequiredAmount(4);
        offer.setTotalCost(100);
        assertThat(offer.getDiscount()).isEqualTo(-20);
    }



}