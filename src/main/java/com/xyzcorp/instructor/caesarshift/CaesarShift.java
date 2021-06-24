package com.xyzcorp.instructor.caesarshift;

public class CaesarShift {
    public static final int ALPHA_SIZE = 26;
    private final int shift;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    public String encode(String string) {
        return shiftString(string, shift);
    }

    private String shiftString(String string, int actualShift) {
        if (string.isEmpty() || actualShift == 0) return string;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            stringBuilder.append(shiftCharacter(c, actualShift));
        }
        return stringBuilder.toString();
    }

    private boolean isLatin(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private char shiftCharacter(char charAt, int actualShift) {
        if (!isLatin(charAt)) return charAt;
        char preferredA = Character.isLowerCase(charAt) ? 'a' : 'A';
        return (char) (((charAt - preferredA + (actualShift % 26) + ALPHA_SIZE) % ALPHA_SIZE) + preferredA);
    }

    public String decode(String string) {
        return shiftString(string, -shift);
    }
}
