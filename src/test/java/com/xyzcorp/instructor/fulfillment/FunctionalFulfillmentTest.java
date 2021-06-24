package com.xyzcorp.instructor.fulfillment;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FunctionalFulfillmentTest {

    @Test
    void testFunctionalFulfillmentUsingAnActualWarehouse() {
        BiFunction<Integer, Product, Boolean> bif = (i, p) -> true;
        Cart cart = mock(Cart.class);
        FunctionalFulfillment ff = new FunctionalFulfillment(bif, () -> cart);
    }
}
