package com.cdl.supermarket.checkout.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class TransactionTests {

    private final static IItem ITEM_A = new Item('A', 50);
    private final static IItem ITEM_B = new Item('B', 30);
    private final static IItem ITEM_C = new Item('C', 20);
    private final static IItem ITEM_D = new Item('B', 15);
    private final static IOffer OFFER_A = new Offer(ITEM_A,3,130);
    private final static IOffer OFFER_B = new Offer(ITEM_B,2,45);

    private Transaction transaction;


    @BeforeEach
    public void setup(){
        CurrentOffers currentOffers = new CurrentOffers();
        Map<IItem,IOffer> offerMap = Map.of(
                ITEM_A,OFFER_A,
                ITEM_B,OFFER_B
        );
        currentOffers.setCurrentOffers(offerMap);
        transaction = new Transaction(currentOffers);
    }

    @Nested
    @DisplayName("Tests related to final total")
    class FinalTotal{

        @Test
        @DisplayName("Basket Meets Requirement of Offer A")
        public void testOBasketMeetRequirementsOfOffer(){
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);

            transaction.calculateFinalTotal();
            assertEquals(130,transaction.getFinalTotal());
        }

        @Test
        @DisplayName("Basket Meets Requirement of Offer A")
        public void test2(){
            // Given
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);

            transaction.calculateFinalTotal();
            assertEquals(100,transaction.getFinalTotal());
        }

        @Test
        @DisplayName("Basket Meets Requirement of Offer A")
        public void test3(){
            // Given
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);
            transaction.calculateFinalTotal();

            assertEquals(90,transaction.getFinalTotal());
        }

    }

    @Nested
    @DisplayName("Tests Related to Offers")
    class Offers{

        @Test
        @DisplayName("Offers for other items ignored")
        public void testOffersForOtherItemsIgnored(){
            // Given
            transaction.addItem(ITEM_C);
            transaction.addItem(ITEM_C);
            transaction.addItem(ITEM_C);

            assertEquals(60,transaction.getRunningTotal());

        }

        @Test
        @DisplayName("Offers not applied when not enough items")
        public void testOBasketDoesNotMeetRequirements(){
            // Given
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);

            assertEquals(100,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Basket Meets Requirement of Offer A")
        public void testOBasketMeetRequirementsOfOffer(){
            // Given
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);

            assertEquals(130,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Basket Meets Requirement of Offer A and has additonal items ")
        public void testOBasketMeetRequirementsOfOfferPlus1(){
            // Given

            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);

            assertEquals(180,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Baskets meet requirement of offer twice")
        public void testOBasketStacksOffer(){
            // Given

            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);

            assertEquals(90,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Basket Contains multiple valid offers")
        public void testBasketWithMultipleOffers(){
            // Given

            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_B);

            assertEquals(220,transaction.getRunningTotal());
        }
    }

    @Nested
    @DisplayName("Test for addToBasket method")
    class AddToBasket {

        @Test
        @DisplayName("Add item to empty basket")
        public void testAddToBasketWithEmptyBasket() {
            // Given
            IBasket basket = new Basket();
            basket.addToBasket(ITEM_A);
            //When
            transaction.addItem(ITEM_A);
            //Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(50,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add it to basket already containing item")
        public void testAddToBasketWithItemAlreadyInBasket() {
            // Given
            IBasket basket = new Basket();
            basket.addToBasket(ITEM_A);
            basket.addToBasket(ITEM_A);

            // When
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_A);

            // Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(100,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add a different item to a basket")
        public void testAddDifferentItemToBasket() {
            // Given
            Basket basket = new Basket();
            basket.addToBasket(ITEM_A);
            basket.addToBasket(ITEM_B);

            // When
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_B);

            // Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(80,transaction.getRunningTotal());
        }

        @Test
        @DisplayName("Add a different item to a basket")
        public void testAddMultiplesItemToBasketInDifferentOrders() {
            // Given

            Basket basket = new Basket();
            basket.addToBasket(ITEM_A);
            basket.addToBasket(ITEM_B);
            basket.addToBasket(ITEM_C);
            basket.addToBasket(ITEM_A);
            basket.addToBasket(ITEM_C);

            transaction.setBasket(basket);

            // When
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_B);
            transaction.addItem(ITEM_C);
            transaction.addItem(ITEM_A);
            transaction.addItem(ITEM_C);
            // Then
            assertEquals(basket, transaction.getBasket());
            assertEquals(135,transaction.getRunningTotal());
        }
    }
}
