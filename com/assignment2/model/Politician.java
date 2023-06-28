package com.assignment2.model;

public class Politician extends Person {
    private int terms;
    private double salaryPerTerm;

    public Politician(String name, int age, int terms, double salaryPerTerm) {
        super(name, age);
        this.terms = terms;
        this.salaryPerTerm = salaryPerTerm;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public double getSalaryPerTerm() {
        return salaryPerTerm;
    }

    public void setSalaryPerTerm(double salaryPerTerm) {
        this.salaryPerTerm = salaryPerTerm;
    }

    public double calculateSalary() {
        return terms * salaryPerTerm;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Terms: " + terms);
        System.out.println("Salary per Term: $" + salaryPerTerm);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}
