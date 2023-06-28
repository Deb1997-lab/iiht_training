package com.assignment5.model;

public class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    private String amPm;

    public Clock(int hours, int minutes, int seconds, String amPm) {
        if (isValidTime(hours, minutes, seconds)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            System.out.println("Invalid time provided.");
            // Set default time values or handle the error as desired
        }
        this.amPm = amPm;
    }

    private boolean isValidTime(int hours, int minutes, int seconds) {
        return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59 && seconds >= 0 && seconds <= 59;
    }

    public void setTime(int hours, int minutes, int seconds) {
        if (isValidTime(hours, minutes, seconds)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            System.out.println("Invalid time provided.");
        }
    }

    public void setAmPm(String amPm) {
        if (amPm.equalsIgnoreCase("AM") || amPm.equalsIgnoreCase("PM")) {
            this.amPm = amPm;
            System.out.println("AM/PM mode set to: " + amPm);
        } else {
            System.out.println("Invalid AM/PM mode provided.");
        }
    }

    public void displayTime() {
        System.out.printf("Current time: %02d:%02d:%02d %s%n", hours, minutes, seconds, amPm);
    }
}

