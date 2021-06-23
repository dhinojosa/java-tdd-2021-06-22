package com.xyzcorp.instructor.caesarshift;

public class CaesarShift {
    private int shift;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    public String encode(String string) {
        if (string.isEmpty() || shift == 0) return string;
        return String.valueOf((char)(((string.charAt(0) - 'a' + shift) % 26) + 'a'));
    }
}
