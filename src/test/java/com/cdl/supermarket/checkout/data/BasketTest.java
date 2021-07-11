package com.cdl.supermarket.checkout.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    private final static IItem ITEM_A = new Item('A', 50);
    private final static IItem ITEM_B = new Item('B', 30);
    private final static IItem ITEM_C = new Item('C', 20);
    private final static IItem ITEM_D = new Item('B', 15);

    private IBasket basket;

    @BeforeEach
    public void setup(){
        basket = new Basket();
    }

    @Test
    public void TestBasketInitialisedOnCreation(){
        assertEquals(basket.getBasket(),new HashMap<>());
    }

    @Test
    public void TestAlreadyExistedItemAreIncremented(){

        Map<IItem,Integer> mapBasket = new HashMap<>(Map.of(
                ITEM_A, 1
        ));
        basket.setBasket(mapBasket);

        basket.addToBasket(ITEM_A);

        assertThat(basket.getBasket()).isEqualTo(mapBasket);
        assertThat(mapBasket.get(ITEM_A)).isEqualTo(2);
        assertThat(basket.getAmountOfItemInBasket(ITEM_A)).isEqualTo(2);

    }

    @Test
    public void TestNewItemIsAdded(){
        Map<IItem,Integer> mapBasket = new HashMap<>(Map.of(
                ITEM_A, 1
        ));
        basket.addToBasket(ITEM_A);
        assertThat(basket.getBasket()).isEqualTo(mapBasket);
        assertThat(basket.getAmountOfItemInBasket(ITEM_A)).isEqualTo(1);
    }

    @Test
    public void TestGetItemInBasket(){
        Set<IItem> expectedItems = Set.of(ITEM_A,ITEM_B);

        basket.addToBasket(ITEM_A);
        basket.addToBasket(ITEM_B);

        Set<IItem> items = basket.getItemsInBasket();

        assertThat(items).isEqualTo(expectedItems);
    }

}
