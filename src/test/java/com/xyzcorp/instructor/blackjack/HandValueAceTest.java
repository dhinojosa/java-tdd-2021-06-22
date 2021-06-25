package com.xyzcorp.instructor.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HandValueAceTest {
    Suit dummySuit = Suit.CLUBS;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Game game = new Game();
        List<Card> cards =List.of(new Card(dummySuit, Rank.ACE),
            new Card(dummySuit, Rank.FIVE)) ;

        Hand hand = new Hand(cards);
        assertThat(hand.handValueOf())
            .isEqualTo(11 + 5);
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Game game = new Game();
        List<Card> cards = List.of(new Card(dummySuit, Rank.ACE),
            new Card(dummySuit, Rank.EIGHT),
            new Card(dummySuit, Rank.THREE));

        Hand hand = new Hand(cards);
        assertThat(hand.handValueOf())
            .isEqualTo(1 + 8 + 3);
    }

}
