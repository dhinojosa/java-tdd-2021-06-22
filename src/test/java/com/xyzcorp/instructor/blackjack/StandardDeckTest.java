package com.xyzcorp.instructor.blackjack;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StandardDeckTest {

  @Test
  public void fullDeckHas52Cards() throws Exception {
    Deck deck = new StandardDeck();

    assertThat(deck.size())
        .isEqualTo(52);
  }

  @Test
  public void drawCardFromDeckReducesDeckSizeByOne() throws Exception {
    Deck deck = new StandardDeck();

    deck.draw();

    assertThat(deck.size())
        .isEqualTo(51);
  }

  @Test
  public void drawCardFromDeckReturnsValidCard() throws Exception {
    Deck deck = new StandardDeck();

    Card card = deck.draw();

    assertThat(card)
        .isNotNull();

    assertThat(card.rank().value())
        .isGreaterThan(0);
  }

  @Test
  public void drawAllCardsResultsInSetOf52UniqueCards() throws Exception {
    Deck deck = new StandardDeck();

    Set<Card> drawnCards = new HashSet<>();
    for (int i = 1; i <= 52; i++) {
      drawnCards.add(deck.draw());
    }

    assertThat(drawnCards)
        .hasSize(52);
  }

}
