package com.cdl.supermarket.checkout.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TransactionTests {


    @Nested
    @DisplayName("Test for addToBasket method")
    class AddToBasket {

        @Test
        @DisplayName("Add item to empty basket")
        public void testAddToBasketWithEmptyBasket() {
            // Given
            ITransaction transaction = new Transaction();
            IItem item = new Item('A', 50);
            IBasket basket = new Basket();
            basket.addToBasket(item);
            //When
            transaction.addItem(item);
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
            Basket basket = new Basket();
            basket.addToBasket(item);
            basket.addToBasket(item);

            // When
            transaction.addItem(item);
            transaction.addItem(item);

            // Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(100,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add a different item to a basket")
        public void testAddDifferentItemToBasket() {
            // Given
            Transaction transaction = new Transaction();
            Item item = new Item('A', 50);
            Item item2 = new Item('B', 30);
            Basket basket = new Basket();
            basket.addToBasket(item);
            basket.addToBasket(item2);

            // When
            transaction.addItem(item);
            transaction.addItem(item2);

            // Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(80,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add a different item to a basket")
        public void testAddMultiplesItemToBasketInDifferentOrders() {
            // Given
            ITransaction transaction = new Transaction();
            IItem item = new Item('A', 50);
            IItem item2 = new Item('B', 30);
            IItem item3 = new Item('C', 20);
            Basket basket = new Basket();
            basket.addToBasket(item);
            basket.addToBasket(item2);
            basket.addToBasket(item3);
            basket.addToBasket(item);
            basket.addToBasket(item3);

            transaction.setBasket(basket);
            transaction.setRunningTotal(10);

            // When
            transaction.addItem(item);
            transaction.addItem(item2);
            transaction.addItem(item3);
            transaction.addItem(item);
            transaction.addItem(item3);
            // Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(180,transaction.getRunningTotal());
        }
    }
}
