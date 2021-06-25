package com.xyzcorp.instructor.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fusesource.jansi.Ansi.ansi;

class RankTest {
  Suit dummySuit = Suit.CLUBS;

  @Test
  public void withNumberCardHasNumericValueOfTheNumber() throws Exception {

    assertThat(Rank.SEVEN.value())
        .isEqualTo(7);
  }

  @Test
  public void withValueOfQueenHasNumericValueOf10() throws Exception {
    assertThat(Rank.QUEEN.value())
        .isEqualTo(10);
  }

  @Test
  public void withAceHasNumericValueOf1() throws Exception {
      assertThat(Rank.ACE.value())
          .isEqualTo(1);
  }

  @Test
  public void suitOfHeartsOrDiamondsIsDisplayedInRed() throws Exception {
    // given a card with Hearts or Diamonds
    Card heartsCard = new Card(Suit.HEARTS, Rank.TEN);
    Card diamondsCard = new Card(Suit.DIAMONDS, Rank.EIGHT);

    // when we ask for its display representation
    String ansiRedString = ansi().fgRed().toString();

    // then we expect a red color ansi sequence
    assertThat(heartsCard.display())
        .contains(ansiRedString);
    assertThat(diamondsCard.display())
        .contains(ansiRedString);
  }

}
