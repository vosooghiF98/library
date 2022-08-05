package org.maktab.interfaces;

import java.sql.SQLException;

public interface Repository {
    void save(Object o) throws SQLException;
    void remove(Object o);
    Object load();
    void edit(Object o);
    Object load(int id);
}
