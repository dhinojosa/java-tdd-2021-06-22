package com.xyzcorp.instructor.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryParserTest {

    @Test
    void testParseSingleLine() {
        String line = "Brian Sletten~A Supposedly Fun Thing I Will Never Do Again~2015-02-12";
        Checkout checkout = LibraryParser.parse(line);
        String name = checkout.getName();
        String title = checkout.getTitle();
        LocalDate checkoutDate = checkout.getDate();
        assertThat(name).isEqualTo("Brian Sletten");
        assertThat(title).isEqualTo("A Supposedly Fun Thing I Will Never Do Again");
        assertThat(checkoutDate).isEqualTo(LocalDate.of(2015, 2, 12));
    }
}
