package com.xyzcorp.instructor.caesarshift;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;

import static org.assertj.core.api.Assertions.assertThat;

public class CaesarShiftProperty {

    @Property()
    @Label("An encoded string after decoding should be the same string")
    public void verifyThatEncodeThenDecodeShouldBeThatSame(@ForAll @AlphaChars String string, @ForAll int shift) {
        System.out.printf("%s : %d\n", string, shift);
        CaesarShift cs = new CaesarShift(shift);
        assertThat(cs.decode(cs.encode(string))).isEqualTo(string);
    }
}
