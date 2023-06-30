package com.example4.model;

public class CurrentAccount implements Account {

private double balance;
	
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		balance += amount;
        System.out.println("Amount deposited: " + amount);

	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
	}

	@Override
	public double calculateInterest() {
		// TODO Auto-generated method stub
		System.out.println("No interest generated in current account");
		return 0;
	}

	@Override
	public double viewBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	
	public void applyOverdraft() {
        double overdraftLimit = 500;
        if (balance >= overdraftLimit) {
            balance -= overdraftLimit;
            System.out.println("Overdraft applied: " + overdraftLimit);
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }

}
