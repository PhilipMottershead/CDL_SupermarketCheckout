package com.cdl.supermarket.checkout;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTests {

    private Checkout checkout;

    @BeforeEach
    public void setUp() throws Exception {
        checkout = new Checkout();
    }

    @Test
    @DisplayName("Create a item")
    public void testMultiply() {
    }

}
