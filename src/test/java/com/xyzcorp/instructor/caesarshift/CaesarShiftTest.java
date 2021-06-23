package com.xyzcorp.instructor.caesarshift;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaesarShiftTest {

    //Encoding
    //Input: (word) String, (shift) Int
    //Output: (encoded) String

    //Decoding
    //Input: (encorded-word) String, (shift) Int
    //Output: (decoded) String

    //ZOMBIES

    private static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
            Arguments.of("", 0, ""),
            Arguments.of("a", 0, "a"),
            Arguments.of("A", 0, "A"), //Green Bar
            Arguments.of("a", 1, "b"),
            Arguments.of("g", 2, "i"), //Green Bar
            Arguments.of("z", 1, "a"),
            Arguments.of("A", 1, "B"),
            Arguments.of("~", 1, "~")
        );
    }

    @ParameterizedTest(name= "{index}: string={0}, shift={1}, expected={2}")
    @MethodSource("stringIntAndListProvider")
    void testCaesarShiftEncoding(String str, int shift, String expected) {
        CaesarShift cs = new CaesarShift(shift);
        String encoded = cs.encode(str);
        assertThat(encoded).isEqualTo(expected);
    }
}
