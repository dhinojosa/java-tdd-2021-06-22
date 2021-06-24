package com.xyzcorp.instructor.library;

import java.time.LocalDate;
import java.util.function.Supplier;

import static java.time.temporal.ChronoUnit.MONTHS;

public class PenaltyCalculator {
    private int penalty;
    private Supplier<LocalDate> todaysDateSupplier;

    protected PenaltyCalculator(int penalty,
                                Supplier<LocalDate> todaysDateSupplier) {
        this.penalty = penalty;
        this.todaysDateSupplier = todaysDateSupplier;
    }

    public static PenaltyCalculator of(int penalty) {
        return new PenaltyCalculator(penalty, LocalDate::now);
    }

    public int calculate(LocalDate checkoutDate) {
        int months = (int) MONTHS.between(checkoutDate.plusDays(1), todaysDateSupplier.get());
        return months * penalty;
    }
}
