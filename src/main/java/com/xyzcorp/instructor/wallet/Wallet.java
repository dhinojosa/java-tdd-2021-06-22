package com.xyzcorp.instructor.wallet;

public interface Wallet {
    boolean isEmpty();

    void addMoney(int amount);

    int balance();

    void spend(int amount);
}
