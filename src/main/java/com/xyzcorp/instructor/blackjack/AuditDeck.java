package com.xyzcorp.instructor.blackjack;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditDeck implements Deck{
    private final ArrayList<String> history;
    private Deck deck;

    public AuditDeck(Deck deck) {
        this.deck = deck;
        this.history = new ArrayList<String>();
    }

    @Override
    public int size() {
        return deck.size();
    }

    @Override
    public Card draw() {
        Card card = deck.draw();
        history.add(String.format("%s: card: %s size: %d", LocalDateTime.now().toString(), card, size()));
        return card;
    }

    public List<String> getHistory() {
        return history;
    }
}
