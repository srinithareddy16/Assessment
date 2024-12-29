package com.example.Assignment;
import java.sql.*;



public class MySQLCRUD {

	public static void createRecord(String query) throws SQLException {
        try (Connection conn = MySQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        }
    }

    // Read operation
    public static String readRecord(String query) throws SQLException {
        String result = null;
        try (Connection conn = MySQLConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                result = rs.getString("column_name");
            }
        }
        return result;
    }

    // Update operation
    public static void updateRecord(String query) throws SQLException {
        try (Connection conn = MySQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        }
    }

    // Delete operation
    public static void deleteRecord(String query) throws SQLException {
        try (Connection conn = MySQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        }
    }
    
}
