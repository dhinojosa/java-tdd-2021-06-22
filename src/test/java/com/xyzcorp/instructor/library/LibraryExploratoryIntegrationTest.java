package com.xyzcorp.instructor.library;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

public class LibraryExploratoryIntegrationTest {

    @Test
    @Tag("integration")
    void testReadingAFileFromResourcesAndPluggingInLibraryParser() throws URISyntaxException, IOException {
        Stream<String> lines = Util.convertResourceToStream("/library.txt");
        Stream<Checkout> checkoutStream = LibraryParser.convertStreamStringToStreamCheckout(lines);
    }

}
