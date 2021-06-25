package com.xyzcorp.instructor.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    void dealFrom(Deck deck) {
        cards.add(deck.draw());
    }

    //I don't want people access this directly
    public int handValueOf() {
        int handValue = cards
            .stream()
            .mapToInt(card1 -> card1.rank().value())
            .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cards
            .stream()
            .anyMatch(card -> card.rank().value() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue < 11) {
            handValue += 10;
        }

        return handValue;
    }

    void displayHand() {
        System.out.println(cards.stream()
                                     .map(Card::display)
                                     .collect(Collectors.joining(
                                   ansi().cursorUp(6).cursorRight(1).toString())));
    }

    void displayFirstCard() {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        System.out.println(cards.get(0).display()); // first card is
        // Face Up
    }

    boolean push(Hand otherHand) {
        return handValueOf() == otherHand.handValueOf();
    }

    boolean beats(Hand otherHand) {
        return otherHand.handValueOf() < handValueOf();
    }
}
