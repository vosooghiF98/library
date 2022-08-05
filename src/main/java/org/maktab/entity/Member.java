package org.maktab.entity;

import java.sql.Date;

public class Member extends Person {
    private int id;
    private final Date signUpDate;
    private Date expireDate;

    private Grade grade;

    public Member(String firstName, String lastName, String nationalCode, Grade grade) {
        super(firstName, lastName, nationalCode);
        signUpDate = Date.valueOf(java.time.LocalDate.now());
        updateExpireDate(grade);
    }

    public void updateExpireDate(Grade grade) {
        this.grade = grade;
        if (grade == Grade.NORMAL)
            expireDate = Date.valueOf(java.time.LocalDate.now().plusMonths(3));
        else if (grade == Grade.PREMIUM)
            expireDate = Date.valueOf(java.time.LocalDate.now().plusMonths(6));
        else
            expireDate = Date.valueOf(java.time.LocalDate.now().plusYears(1));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpireDate() {
        return expireDate;
    }


    public Grade getGrade() {
        return grade;
    }
}
