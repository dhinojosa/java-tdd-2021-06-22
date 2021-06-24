package com.xyzcorp.instructor.fulfillment;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class FunctionalFulfillment implements Fulfillment {

    public FunctionalFulfillment(BiFunction<Integer, Product, Boolean> isProductAvailable, Supplier<Cart> cartSupplier) {
    }

    @Override
    public void order(Product product, int quantity) {

    }

    @Override
    public Cart getCart() {
        return null;
    }
}
