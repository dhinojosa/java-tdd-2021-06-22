package com.xyzcorp.instructor.caesarshift;

public class CaesarShift {
    public static final int ALPHA_SIZE = 26;
    private final int shift;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    //Extract Variable is CMD_OPT+V
    public String encode(String string) {
        if (string.isEmpty() || shift == 0) return string;
        char charAt = string.charAt(0);
        char shiftedChar = shiftCharacter(charAt);
        return String.valueOf(shiftedChar);
    }

    private char shiftCharacter(char charAt) {
        if (!Character.isAlphabetic(charAt)) return charAt;
        char preferredA = Character.isLowerCase(charAt) ? 'a' : 'A';
        char shiftedChar =
            (char) (((charAt - preferredA + shift) % ALPHA_SIZE) + preferredA);
        return shiftedChar;
    }
}
