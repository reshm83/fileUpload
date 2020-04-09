/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ahmad Umar
 */
public class ConnectorDatabase {
    
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmadschema", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error Occured While Getting the Connection: - " + e);
        }
        return connection;
    }
    public static void main(String[] args) {
    }
    public  static String getExtension(File f) {
        String name = f.getName();
        String extension = "";

        int i = name.lastIndexOf('.');
        if (i > 0) {
            extension = name.substring(i + 1);
        }
        return extension;
    }
}
