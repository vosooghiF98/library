package org.maktab.util.list;

import org.maktab.entity.Book;

import java.util.Arrays;

public class BookList {

    private Book[] books = new Book[1000];
    int index = 0;


    public void add(Book book) {
        if (index > books.length - 1) {
            books = Arrays.copyOf(books, books.length * 2);
        }
        books[index] = book;
        index++;
    }

    public void remove(int id) {
        if (id < index) {
            books[id] = null;
        }
        if (index - id >= 0) System.arraycopy(books, id + 1, books, id, index - id);
        /*for (int i = id; i < index; i++) {
            books[i] = books[i + 1];
        }*/
    }


}
