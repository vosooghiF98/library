package org.maktab.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static Connection connection;

    static {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "a*1294278F");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    public static Connection getConnection(){
        return connection;
    }
}
