package com.assignment_1;
import com.assignment_1.model.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter the day: ");
    	
        Date date = new Date(2023, 6, 26);
        if (date.isValidDate()) {
            date.printNextDay();
        } else {
            System.out.println("Invalid date");
        }
    }
}

