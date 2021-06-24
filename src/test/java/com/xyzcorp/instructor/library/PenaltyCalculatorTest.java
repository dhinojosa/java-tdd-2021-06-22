package com.xyzcorp.instructor.library;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PenaltyCalculatorTest {

    @Test
    void testPenaltyIsZeroTodayDateAndCheckoutDateIsToday() {
        //Input: Today's Date
        //       Checkout Date
        //       Penalty (2.0 dollars)

        //Output: Cost
        PenaltyCalculator pc = new PenaltyCalculator(0, LocalDate::now);
        int penalty = pc.calculate(LocalDate.now());
        assertThat(penalty).isEqualTo(0);
    }

    @Test
    void testPenaltyIsTenTodayDateAndCheckoutDateIsOneMonthApart() {
        PenaltyCalculator pc = new PenaltyCalculator(10, () -> LocalDate.of(2018, 2, 1));
        int penalty = pc.calculate(LocalDate.of(2018, 1, 1));
        assertThat(penalty).isEqualTo(0);
    }


    @Test
    void testPenaltyIsTenTodayDateAndCheckoutDateIsExactlyOneMonthApart() {
        PenaltyCalculator pc = new PenaltyCalculator(10, () -> LocalDate.of(2018, 8, 15));
        int penalty = pc.calculate(LocalDate.of(2018, 7, 15));
        assertThat(penalty).isEqualTo(0);
    }

    @Test
    void testPenaltyIsTenTodayDateAndCheckoutDateIsTwoMonthsApart() {
        PenaltyCalculator pc = new PenaltyCalculator(10, () -> LocalDate.of(2018, 3, 1));
        int penalty = pc.calculate(LocalDate.of(2018, 1, 1));
        assertThat(penalty).isEqualTo(10);
    }

    @Test
    void testPenaltyIsTenTodayDateAndCheckoutDateIsExactlyOneMonthAndOneDayApart() {
        PenaltyCalculator pc = new PenaltyCalculator(10, () -> LocalDate.of(2018, 8, 16));
        int penalty = pc.calculate(LocalDate.of(2018, 7, 15));
        assertThat(penalty).isEqualTo(10);
    }

    @Test
    void testPenaltyIsTenTodayDateAndCheckoutDateIsExactlyTwoMonthsExact() {
        PenaltyCalculator pc = new PenaltyCalculator(10, () -> LocalDate.of(2018, 8, 16));
        int penalty = pc.calculate(LocalDate.of(2018, 6, 16));
        assertThat(penalty).isEqualTo(10);
    }

    @Test
    @Tag("integration")
    void testHowEndUsersWillUseThisObject() {
        PenaltyCalculator pc = PenaltyCalculator.of(10);
        int penalty = pc.calculate(LocalDate.of(2021, 5, 16));
        assertThat(penalty).isGreaterThan(0);
    }
}
