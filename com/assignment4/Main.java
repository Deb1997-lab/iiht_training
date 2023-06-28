package com.assignment4;

import com.assignment4.model.BankDataBase;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder's name: ");
        String accountHolderName = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankDataBase bankDatabase = new BankDataBase(accountHolderName, accountNumber, initialBalance);

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Display User Details");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayUserDetails(bankDatabase);
                    break;
                case 2:
                    withdrawMoney(scanner, bankDatabase);
                    break;
                case 3:
                    depositMoney(scanner, bankDatabase);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayUserDetails(BankDataBase bankDatabase) {
        System.out.println("Account holder's name: " + bankDatabase.getAccountHolderName());
        System.out.println("Account number: " + bankDatabase.getAccountNumber());
        System.out.println("Current balance: " + bankDatabase.getBalance());
    }

    private static void withdrawMoney(Scanner scanner, BankDataBase bankDatabase) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        bankDatabase.withdraw(amount);
    }

    private static void depositMoney(Scanner scanner, BankDataBase bankDatabase) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        bankDatabase.deposit(amount);
    }
}

