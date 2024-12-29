package com.example.Assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://your-database-host:3306/yourdb?useSSL=true&requireSSL=true&verifyServerCertificate=true";
        String user = "yourusername";
        String password = "yourpassword";

        return DriverManager.getConnection(url, user, password);
    }
}
