package com.cdl.supermarket.checkout.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CurrentOffersTest {
    private final static IItem ITEM_A = new Item('A', 50);
    private final static IItem ITEM_B = new Item('B', 30);
    private final static IItem ITEM_C = new Item('C', 20);

    private final static IOffer OFFER_A = new Offer(ITEM_A,3,130);
    private final static IOffer OFFER_B = new Offer(ITEM_B,2,45);
    private CurrentOffers currentOffers;

    @BeforeEach
    public void setup(){
        Map<IItem, IOffer> currentOffersMap = Map.of(
                ITEM_A, OFFER_A,
                ITEM_B, OFFER_B
        );
        currentOffers = new CurrentOffers(currentOffersMap);

    }

    @Nested
    @DisplayName("Has Offer")
    class HasOffer{
        @Test
        public void testItemWithOffer(){
           assertThat(currentOffers.hasOffer(ITEM_A)).isTrue();
        }

        @Test
        public void testItemWithoutOffer(){
            assertThat(currentOffers.hasOffer(ITEM_C)).isFalse();
        }
    }

    @Nested
    @DisplayName("Has Offer")
    class CalculateOffer {

        private IBasket basket;

        @BeforeEach
        public void setup(){
            basket = new Basket();
            Map<IItem,Integer> mapBasket = new HashMap<>(Map.of(
                    ITEM_A, 3,
                    ITEM_B, 2
            ));
            basket.setBasket(mapBasket);
        }

        @Test
        public void TestItemHasOffer(){
            int offer = currentOffers.calculateOfferDiscount(ITEM_A,basket);
            assertThat(offer).isEqualTo(-20);
        }

        @Test
        public void TestItemHasNoOffer(){
            int offer = currentOffers.calculateOfferDiscount(ITEM_C,basket);
            assertThat(offer).isEqualTo(0);
        }
    }

}