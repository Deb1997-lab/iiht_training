package com.assignment5;

import java.util.Scanner;

import com.assignment5.model.Clock;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter hours: ");
        int hours = scanner.nextInt();

        System.out.print("Enter minutes: ");
        int minutes = scanner.nextInt();

        System.out.print("Enter seconds: ");
        int seconds = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter AM/PM: ");
        String amPm = scanner.nextLine();

        Clock clock = new Clock(hours, minutes, seconds, amPm);

        System.out.println("\nClock created!");
        clock.displayTime();

        scanner.close();
    }
}
