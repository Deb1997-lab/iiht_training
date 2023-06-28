package com.assignment2;
import java.util.Scanner;
import com.assignment2.model.Politician;
import com.assignment2.model.Sportsman;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter politician's name: ");
        String politicianName = scanner.nextLine();
        System.out.print("Enter politician's age: ");
        int politicianAge = scanner.nextInt();
        System.out.print("Enter number of terms: ");
        int terms = scanner.nextInt();
        System.out.print("Enter salary per term: ");
        double salaryPerTerm = scanner.nextDouble();

        Politician politician = new Politician(politicianName, politicianAge, terms, salaryPerTerm);

        System.out.print("Enter sportsman's name: ");
        scanner.nextLine(); // Consume newline character
        String sportsmanName = scanner.nextLine();
        System.out.print("Enter sportsman's age: ");
        int sportsmanAge = scanner.nextInt();
        System.out.print("Enter sport: ");
        scanner.nextLine(); // Consume newline character
        String sport = scanner.nextLine();
        System.out.print("Enter annual salary: ");
        double annualSalary = scanner.nextDouble();

        Sportsman sportsman = new Sportsman(sportsmanName, sportsmanAge, sport, annualSalary);

        scanner.close();

        System.out.println("\nPolitician Details:");
        politician.displayInfo();
        System.out.println();

        System.out.println("Sportsman Details:");
        sportsman.displayInfo();
    }
}

