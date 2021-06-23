package com.xyzcorp.instructor.wallet;

public class MiddleClassWallet implements Wallet {

    private int balance = 0;

    @Override
    public boolean isEmpty() {
        return balance == 0;
    }

    @Override
    public void addMoney(int amount) {
        ensureAmountIsPositive(amount);
        try {
            balance = Math.addExact(balance, amount);
        } catch (ArithmeticException e) {
            throw new IllegalStateException("Maybe it's time you use a bank");
        }
    }

    private void ensureAmountIsPositive(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Argument must be positive");
    }

    @Override
    public int balance() {
        return balance;
    }

    @Override
    public void spend(int amount) {
        if (amount > balance) throw new IllegalArgumentException("Overdraft");
        ensureAmountIsPositive(amount);
        this.balance -= amount;
    }
}
