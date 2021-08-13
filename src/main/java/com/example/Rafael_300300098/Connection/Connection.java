package com.example.Rafael_300300098.Connection;

import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class Connection {
    public java.sql.Connection connection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");
        return connection;
    }
}
