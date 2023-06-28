package com.assignment4.model;

public class BankDataBase extends Account {
    private String accountNumber;

    public BankDataBase(String accountHolderName, String accountNumber, double initialBalance) {
        super(accountHolderName, initialBalance);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
