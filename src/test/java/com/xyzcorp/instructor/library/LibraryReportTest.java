package com.xyzcorp.instructor.library;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class LibraryReportTest {
    @Test
    void testFindOffendersWithEmptyStream() {
        List<CheckoutOffender> checkoutOffenderList =
            LibraryReport.findTopFivePenaltyOffenders(Stream.<Checkout>empty());

    }
}
