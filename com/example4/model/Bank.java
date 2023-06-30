package com.example4.model;

import java.util.Vector;

public class Bank {
	private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added to the bank");
    }
}
