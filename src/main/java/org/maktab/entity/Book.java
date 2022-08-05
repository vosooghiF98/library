package org.maktab.entity;

import java.sql.Date;

public class Book {

    private int id;
    private final String name;
    private final String authorName;
    private final String category;
    private final Date createDate;

    public Book(String name, String authorName, String category, Date createDate) {
        this.name = name;
        this.authorName = authorName;
        this.category = category;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

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
}
