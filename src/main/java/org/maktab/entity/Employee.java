package org.maktab.entity;

public class Employee extends Person {
    private int id;
    private double salary;
    private AccessModifier accessModifier;

    public Employee(String firstName, String lastName, String nationalCode, AccessModifier accessModifier) {
        super(firstName, lastName, nationalCode);
        this.accessModifier = accessModifier;
        this.salary = 1_000_000;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public void calculateSalary() {
        if (accessModifier == AccessModifier.ADMIN)
            this.salary += this.salary * 25 / 100;
        else
            this.salary += this.salary * 5 / 100;
    }

}
