package org.maktab.interfaces;

import org.maktab.entity.Library;

import java.sql.SQLException;

public interface Repository {
    void save(Object o) throws SQLException;
    void remove(Object o) throws SQLException;
    void loadAll(Library library) throws SQLException;
    void edit(Object o);
    Object load(int id);
}
