package com.xyzcorp.instructor.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {

    private final Deck deck;
    private final Hand playerHand = new Hand();
    private final Hand dealerHand = new Hand();
    private int balance;
    private int bet;

    public static void main(String[] args) {
        Game game = new Game();
        displayWelcomeScreen();
        playGame(game);
        resetScreen();
    }

    private static void resetScreen() {
        System.out.println(ansi().reset());
    }

    private static void playGame(Game game) {
        game.initialDeal();
        game.play();
    }

    private static void displayWelcomeScreen() {
        System.out.println(ansi()
            .bgBright(Ansi.Color.WHITE)
            .eraseScreen()
            .cursor(1, 1)
            .fgGreen().a("Welcome to")
            .fgRed().a(" Jitterted's")
            .fgBlack().a(" BlackJack"));
    }

    public Game() {
        deck = new
            StandardDeck();
    }

    public void initialDeal() {
        dealRound();
        dealRound();
    }

    private void dealRound() {
        playerHand.dealFrom(deck);
        dealerHand.dealFrom(deck);
    }

    public void play() {
        // get Player's decision: hit until they stand, then they're done (or
        // they go bust)

        boolean playerBusted = playerTurn();

        dealerTurn(playerBusted);

        displayFinalGameState();

        displayOutcome(playerBusted);
    }

    private boolean playerTurn() {
        boolean playerBusted = false;
        while (!playerBusted) {
            displayGameState();
            String playerChoice = inputFromPlayer().toLowerCase();
            if (playerChoice.startsWith("s")) {
                break;
            }
            if (playerChoice.startsWith("h")) {
                playerHand.dealFrom(deck);
                if (isBust(playerHand)) {
                    playerBusted = true;
                }
            } else {
                System.out.println("You need to [H]it or [S]tand");
            }
        }
        return playerBusted;
    }

    private void displayOutcome(boolean playerBusted) {
        if (playerBusted) {
            //playerBusts
            System.out.println("You Busted, so you lose.  💸");
        } else if (isBust(dealerHand)) {
            //dealerBusts
            System.out.println("Dealer went BUST, Player wins! Yay for you!! " +
                "💵");
        } else if (playerHand.beats(dealerHand)) {
            //playerWins();
            System.out.println("You beat the Dealer! 💵");
        } else if (dealerHand.push(playerHand)) {
            //playerPushes()
            System.out.println("Push: You tie with the Dealer. 💸");
        } else {
            //playerLoses()
            System.out.println("You lost to the Dealer. 💸");
        }
    }

    private boolean isBust(Hand hand) {
        return hand.handValueOf() > 21;
    }

    private void dealerTurn(boolean playerBusted) {
        // Dealer makes its choice automatically based on a simple heuristic
        // (<=16, hit, 17>=stand)
        if (!playerBusted) {
            while (dealerHand.handValueOf() <= 16) {
                dealerHand.dealFrom(deck);
            }
        }
    }

    private String inputFromPlayer() {
        System.out.println("[H]it or [S]tand?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void displayGameState() {
        dealerHand.displayFirstCard();
        displayBackOfCard();
        displayPlayerCards();
    }

    private void displayPlayerCards() {
        System.out.println();
        System.out.println("Player has: ");
        playerHand.displayHand();
        System.out.println(" (" + playerHand.handValueOf() + ")");
    }

    private void displayBackOfCard() {
        System.out.print(
            ansi()
                .cursorUp(7)
                .cursorRight(12)
                .a("┌─────────┐").cursorDown(1).cursorLeft(11)
                .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                .a("│░ J I T ░│").cursorDown(1).cursorLeft(11)
                .a("│░ T E R ░│").cursorDown(1).cursorLeft(11)
                .a("│░ T E D ░│").cursorDown(1).cursorLeft(11)
                .a("│░░░░░░░░░│").cursorDown(1).cursorLeft(11)
                .a("└─────────┘"));
    }

    private void displayFinalGameState() {
        displayCompleteDealerHand();
        displayPlayerCards();
    }

    private void displayCompleteDealerHand() {
        System.out.print(ansi().eraseScreen().cursor(1, 1));
        System.out.println("Dealer has: ");
        dealerHand.displayHand();
        System.out.println(" (" + dealerHand.handValueOf() + ")");
    }

    public int getBalance() {
        return balance;
    }

    public void playerDeposits(int amount) {
        this.balance += amount;
    }

    public void playerBets(int amount) {
        this.balance -= amount;
        this.bet = amount;
    }

    public void playerWins() {
        this.balance += bet * 2;
    }


}
