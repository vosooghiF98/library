package org.maktab.repository;

import org.maktab.config.DBConfig;
import org.maktab.entity.Book;
import org.maktab.util.list.BookList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository {
    public void save(Book book) throws SQLException {
        String query = """
                insert into book (name, category, createdate, ishire) 
                values (?,?,?,?);
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getCategory());
        preparedStatement.setDate(3, book.getCreateDate());
        preparedStatement.setBoolean(4, book.isHire());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void remove(Book book) throws SQLException {
        String query = """
                delete from book where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, book.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public BookList loadAll() throws SQLException {
        String query = """
                select * from book;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        BookList bookList = new BookList();
        while (resultSet.next()) {
            Book book = new Book(resultSet.getString("name"), resultSet.getString("category"), resultSet.getDate("createdate"));
            bookList.add(book);
        }
        resultSet.close();
        preparedStatement.close();
        return bookList;
    }

    public void edit(Book book) throws SQLException {
        String query = """
                update book set name = ? , category = ? , createdate = ? where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getCategory());
        preparedStatement.setDate(3, book.getCreateDate());
        preparedStatement.setInt(4, book.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Book load(int id) throws SQLException {
        String query = """
                select * from book where id = ?;
                """;
        PreparedStatement preparedStatement = DBConfig.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Book(resultSet.getString("name"), resultSet.getString("category"), resultSet.getDate("createdate"));
        } else return null;
    }
}
