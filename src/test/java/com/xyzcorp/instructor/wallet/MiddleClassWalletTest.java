package com.xyzcorp.instructor.wallet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MiddleClassWalletTest {
    /*
     * Z = Zero yes
     * O = One  yes
     * M = Many yes
     * B = Boundary yes!
     * I = Interface
     * E = Exception yes!
     * s = simple
     */

    //SHIFT+F6 = Rename
    //CMD+OPT+N = Inline
    //CTRL+T = Refactoring Menu
    //F2 = Go to a problem area
    //CMD (CTRL) + SHIFT + T Toggle between test and prod
    //CTRL + SHIFT + R = Run AND establish the test
    //CTRL + R = Run previous established test
    @Test
    void testIsEmpty() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        boolean result = middleClassWallet.isEmpty();
        assertThat(result).isTrue();
    }

    @Test
    void testAddMoneyAndWalletShouldNotBeEmpty() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(10);
        assertThat(middleClassWallet.isEmpty()).isFalse();
    }


    @Test
    void testStartWithZeroAndAddZeroMoney() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(0);
        assertThat(middleClassWallet.isEmpty()).isTrue();
    }

    @Test
    void testStartWithZeroAndAddANegativeThenThrowAnIllegalArgException() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        assertThatThrownBy(() -> middleClassWallet.addMoney(-10))
            .hasMessage("Argument must be positive")
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testAddOneShouldHaveABalanceOfOne() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(1);
        int balance = middleClassWallet.balance();
        assertThat(balance).isEqualTo(1);
    }

    @Test
    void testAddTwoShouldHaveABalanceOfTwo() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(2);
        int balance = middleClassWallet.balance();
        assertThat(balance).isEqualTo(2);
    }

    @Test
    void testBoundaryWithMaxValue() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(Integer.MAX_VALUE);

        assertThatThrownBy(() -> middleClassWallet.addMoney(2))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("Maybe it's time you use a bank");
    }

    @Test
    void testAddTwoOnesShouldHaveABalanceOfTwo() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(1);
        middleClassWallet.addMoney(1);
        assertThat(middleClassWallet.balance()).isEqualTo(2);
    }

    @Test
    void testAddOneAndSpendOneShouldBeEmpty() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(1);
        middleClassWallet.spend(1);
        assertThat(middleClassWallet.isEmpty()).isTrue();
    }

    @Test
    void testStartWithZeroAndSpendANegativeThenThrowAnIllegalArgException() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        assertThatThrownBy(() -> middleClassWallet.spend(-10))
            .hasMessage("Argument must be positive")
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testAddOneAndSpendTwoShouldThrowException() {
        MiddleClassWallet middleClassWallet = new MiddleClassWallet();
        middleClassWallet.addMoney(1);
        assertThatThrownBy(() -> middleClassWallet.spend(2))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
