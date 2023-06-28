package com.assignment2.model;

public class Sportsman extends Person {
    private String sport;
    private double annualSalary;

    public Sportsman(String name, int age, String sport, double annualSalary) {
        super(name, age);
        this.sport = sport;
        this.annualSalary = annualSalary;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sport: " + sport);
        System.out.println("Annual Salary: $" + annualSalary);
    }
}
