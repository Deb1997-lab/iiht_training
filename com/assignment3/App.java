package com.assignment3;

import com.assignment3.model.IncomeTaxCalculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee's earnings: Rs. ");
        double earnings = scanner.nextDouble();

        double taxAmount = IncomeTaxCalculator.calculateIncomeTax(earnings);

        System.out.println("Income tax to be paid: Rs. " + taxAmount);

        scanner.close();
    }
}
