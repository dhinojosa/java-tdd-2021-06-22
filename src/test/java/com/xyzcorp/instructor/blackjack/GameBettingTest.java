package com.xyzcorp.instructor.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBettingTest {

    @Test
    void testNewGameWhereThePlayerBalanceZero() {
        Game game = new Game();
        int balance = game.getBalance();
        assertThat(balance).isEqualTo(0);
    }

    @Test
    void testPlayerThatDeposits100() {
        Game game = new Game();
        game.playerDeposits(100);
        int balance = game.getBalance();
        assertThat(balance).isEqualTo(100);
    }

    @Test
    void testPlayerThatDeposits100Bets50AndWinsThenTheBalanceIs150() {
        Game game = new Game();
        game.playerDeposits(100);
        game.playerBets(50);
        game.playerWins();
        int balance = game.getBalance();
        assertThat(balance).isEqualTo(100 - 50 + 100);
    }
}
