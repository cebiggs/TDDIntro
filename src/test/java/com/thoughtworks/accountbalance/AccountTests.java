package com.thoughtworks.accountbalance;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AccountTests {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account();
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        account.setBalance(100);
        account.deposit(50);
        assertThat(account.getBalance(), is(150.00));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        account.setBalance(100);
        account.withdraw(50);
        assertThat(account.getBalance(), is(50.00));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        account.setBalance(50);
        account.withdraw(100);
        assertThat(account.getBalance(), is(50.00));
    }
}
