package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/aytek";
    private static final String user = "postgres";
    private static final String password = "123456123";
    private static Connection connection;

    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Successfully connected to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
        return connection;
    }
    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection: " + e.getMessage());
        }
    }
}
