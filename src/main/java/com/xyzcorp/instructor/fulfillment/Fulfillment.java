package com.xyzcorp.instructor.fulfillment;

public interface Fulfillment {
    void order(Product product, int quantity);

    Cart getCart();
}
