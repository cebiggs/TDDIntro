package com.thoughtworks.accountbalance;

/**
 * Created by cannon on 6/5/15.
 */
public class Account {

    private double balance;

    public void setBalance(double amount) {
        balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double deposit) {
        makeTransaction(deposit);
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            return;
        }
        makeTransaction(-amount);
    }

    private void makeTransaction(double amount) {
        balance += amount;
    }
}
