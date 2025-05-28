package com.example.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:h2:mem:inventory;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    
    public DatabaseManager() {
        initializeDatabase();
    }
    
    private void initializeDatabase() {
        try {
            Connection conn = getConnection();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS products " +
                    "(id VARCHAR(50) PRIMARY KEY, name VARCHAR(100), price DOUBLE)";
            
            try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
                stmt.execute();
            }
            
        } catch (SQLException e) {
            System.err.println("Failed to initialize database: " + e.getMessage());
        }
    }
    
    public void saveProduct(Product product) {
        Connection conn = null;
        try {
            conn = getConnection();
            String sql = "MERGE INTO products KEY(id) VALUES(?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, product.getId());
                stmt.setString(2, product.getName());
                stmt.setDouble(3, product.getPrice());
                stmt.executeUpdate();
            }
            
        } catch (SQLException e) {
            System.err.println("Failed to save product: " + e.getMessage());
        }
    }
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}