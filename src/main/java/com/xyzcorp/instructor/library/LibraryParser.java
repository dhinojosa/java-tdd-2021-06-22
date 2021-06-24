package com.xyzcorp.instructor.library;

import java.time.LocalDate;
import java.util.stream.Stream;

public class LibraryParser {
    public static Checkout parse(String line) {
        String[] strings = line.split("~");
        return new Checkout(strings[0], strings[1], LocalDate.parse(strings[2]));
    }

    public static Stream<Checkout> convertStreamStringToStreamCheckout(Stream<String> lines) {
        return lines.map(LibraryParser::parse);
    }
}
