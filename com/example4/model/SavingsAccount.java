package com.example4.model;

public class SavingsAccount implements Account {
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
		double interestRate = 0.05; // 5%
        return balance * interestRate;
	}

	@Override
	public double viewBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	
	public void applySpecialOffer() {
        double specialOffer = 100;
        balance += specialOffer;
        System.out.println("Special offer applied: " + specialOffer);
    }

}
