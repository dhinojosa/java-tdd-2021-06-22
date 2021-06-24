package com.xyzcorp.instructor.fulfillment;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class FulfillmentTestMockito {
    @Test
    void testFulfillmentWithZeroInventory() {
        Warehouse warehouse = mock(Warehouse.class);
        Cart cart = mock(CartMap.class);
        Product skyGalaxyEarbuds = new Product("Sky Galaxy Earbuds");
        when(warehouse.canFulfill(3, skyGalaxyEarbuds)).thenReturn(false);
        Fulfillment fulfillment = new WarehouseFulfillment(warehouse, () -> cart);
        fulfillment.order(skyGalaxyEarbuds, 3);
        verify(cart, never()).add(3, skyGalaxyEarbuds);
    }

    @Test
    void testFulfillmentWithThreeInventory() {
        Warehouse warehouse = mock(Warehouse.class);
        Cart cart = mock(Cart.class);
        Product skyGalaxyEarbuds = new Product("Sky Galaxy Earbuds");
        when(warehouse.canFulfill(3, skyGalaxyEarbuds)).thenReturn(true);
        Fulfillment fulfillment = new WarehouseFulfillment(warehouse, () -> cart);
        fulfillment.order(skyGalaxyEarbuds, 3);
        verify(cart).add(3,skyGalaxyEarbuds);
    }
}
