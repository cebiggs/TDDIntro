package com.thoughtworks.accountbalance;

/**
 * Created by cannon on 6/5/15.
 */
public class Account {

    public double balance;

    public void deposit( double deposit ) {
        balance += deposit;
    }

    public void withdraw( double amount ) {
        balance -= amount;
    }
}
