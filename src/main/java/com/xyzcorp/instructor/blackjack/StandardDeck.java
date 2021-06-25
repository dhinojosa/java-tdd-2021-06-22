package com.xyzcorp.instructor.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck { //data object
    private final List<Card> cards = new ArrayList<>();  // NOT primitive
    // obsession

    public StandardDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public Card draw() {
        return cards.remove(0);
    }
}
