package com.assignment_1.model;

public class Date {
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isValidDate() {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            return false;
        }

        if (day < 1 || day > getDaysInMonth()) {
            return false;
        }

        return true;
    }

    private int getDaysInMonth() {
        int daysInMonth = DAYS_IN_MONTH[month];
        if (month == 2 && isLeapYear()) {
            daysInMonth = 29;
        }
        return daysInMonth;
    }

    private boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public void printNextDay() {
        if (isValidDate()) {
            int nextDay = day + 1;
            int nextMonth = month;
            int nextYear = year;

            if (nextDay > getDaysInMonth()) {
                nextDay = 1;
                nextMonth++;
                if (nextMonth > MAX_MONTH) {
                    nextMonth = 1;
                    nextYear++;
                }
            }

            System.out.println("Next day: " + nextYear + "-" + nextMonth + "-" + nextDay);
        } else {
            System.out.println("Invalid date");
        }
    }
}

