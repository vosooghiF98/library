package org.maktab.entity;

public class Employee extends Person{
    private int id;
    private double salary;
    public Employee(String firstName, String lastName, String nationalCode) {
        super(firstName, lastName, nationalCode);
    }

}
