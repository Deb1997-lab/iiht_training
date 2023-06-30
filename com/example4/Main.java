package com.example4;

import com.example4.model.*;

public class Main {
	public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(1000);
        savingsAccount.applySpecialOffer();

        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(5000);
        currentAccount.applyOverdraft();

        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);
	}
}
