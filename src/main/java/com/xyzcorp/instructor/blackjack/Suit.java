package com.xyzcorp.instructor.blackjack;

public enum Suit {
    SPADES("♠"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    CLUBS("♣");


    private final String icon;

    Suit(String icon) {
        this.icon = icon;
    }

    public String icon() {
        return icon;
    }
}
