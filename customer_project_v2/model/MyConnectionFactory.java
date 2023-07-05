package com.ibm.customer_project_v2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionFactory {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hr";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
