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
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = string.toCharArray();
        for (char c: chars) {
            stringBuilder.append(shiftCharacter(c));
        }
        return stringBuilder.toString();
    }

    private boolean isLatin(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private char shiftCharacter(char charAt) {
        if (!isLatin(charAt)) return charAt;
        char preferredA = Character.isLowerCase(charAt) ? 'a' : 'A';
        return (char) (((charAt - preferredA + shift) % ALPHA_SIZE) + preferredA);
    }
}
