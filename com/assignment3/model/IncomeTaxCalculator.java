package com.assignment3.model;

public class IncomeTaxCalculator {
    public static double calculateIncomeTax(double earnings) {
        double taxAmount = 0;

        if (earnings <= 50000) {
            // No tax for earnings up to Rs. 50,000
            taxAmount = 0;
        } else if (earnings <= 60000) {
            // 10% tax on additional earnings between Rs. 50,001 - Rs. 60,000
            taxAmount = (earnings - 50000) * 0.10;
        } else if (earnings <= 150000) {
            // 20% tax on additional earnings between Rs. 60,001 - Rs. 1,50,000
            taxAmount = 10000 + (earnings - 60000) * 0.20;
        } else {
            // 30% tax on additional earnings above Rs. 1,50,000
            taxAmount = 10000 + 18000 + (earnings - 150000) * 0.30;
        }

        return taxAmount;
    }
}







