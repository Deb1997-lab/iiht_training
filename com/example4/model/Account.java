package com.example4.model;

public interface Account {
	void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
    double viewBalance();

}
