package org.maktab.entity;

import java.sql.Date;

public class Book {

    private int id;
    private final String name;
    private final String category;
    private final Date createDate;
    private boolean isHire;

    public Book(String name, String category, Date createDate) {
        this.name = name;
        this.category = category;
        this.createDate = createDate;
        isHire = false;
    }

    public String getName() {
        return name;
    }

   /* public String getAuthorName() {
        return authorName;
    }*/

    public String getCategory() {
        return category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHire() {
        return isHire;
    }

    public void setHire(boolean hire) {
        isHire = hire;
    }
}
