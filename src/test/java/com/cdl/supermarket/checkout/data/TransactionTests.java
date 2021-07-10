package com.cdl.supermarket.checkout.data;

import com.cdl.supermarket.checkout.Checkout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class TransactionTests {


    @Nested
    @DisplayName("Test for addToBasket method")
    class AddToBasket {

        @Test
        @DisplayName("Add item to empty basket")
        public void testAddToBasketWithEmptyBasket() {
            // Given
            Transaction transaction = new Transaction();
            Item item = new Item('A', 50);
            Map<Item, Integer> basket = Map.of(
                    item, 1
            );
            //When
            transaction.addToBasket(item);
            //Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(50,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add it to basket already containing item")
        public void testAddToBasketWithItemAlreadyInBasket() {
            // Given
            Transaction transaction = new Transaction();
            Item item = new Item('A', 50);
            Map<Item, Integer> existingBasket = new HashMap<>() {{
                put(item, 1);
            }};
            Map<Item, Integer> expectedBasket = Map.of(
                    item, 2
            );
            transaction.setBasket(existingBasket);
            transaction.setRunningTotal(50);

            // When
            transaction.addToBasket(item);

            // Then
            assertEquals(expectedBasket, transaction.getBasket());
            assertEquals(100,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add a different item to a basket")
        public void testAddDifferentItemToBasket() {
            // Given
            Transaction transaction = new Transaction();
            Item item = new Item('A', 50);
            Item item2 = new Item('B', 30);

            Map<Item, Integer> existingBasket = new HashMap<>() {{
                put(item, 1);
            }};
            Map<Item, Integer> expectedBasket = Map.of(
                    item, 1,
                    item2, 1
            );
            transaction.setBasket(existingBasket);
            transaction.setRunningTotal(50);

            // When
            transaction.addToBasket(item2);

            // Then
            assertEquals(expectedBasket, transaction.getBasket());
            assertEquals(80,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add a different item to a basket")
        public void testAddMultiplesItemToBasketInDifferentOrders() {
            // Given
            Transaction transaction = new Transaction();
            Item item = new Item('A', 50);
            Item item2 = new Item('B', 30);
            Item item3 = new Item('C', 20);

            Map<Item, Integer> existingBasket = new HashMap<>() {{
                put(item, 1);
            }};
            Map<Item, Integer> expectedBasket = Map.of(
                    item, 3,
                    item2, 1,
                    item3,2
            );
            transaction.setBasket(existingBasket);
            transaction.setRunningTotal(10);

            // When
            transaction.addToBasket(item);
            transaction.addToBasket(item2);
            transaction.addToBasket(item3);
            transaction.addToBasket(item);
            transaction.addToBasket(item3);
            // Then
            assertEquals(expectedBasket, transaction.getBasket());
            assertEquals(180,transaction.getRunningTotal());
        }
    }
}
