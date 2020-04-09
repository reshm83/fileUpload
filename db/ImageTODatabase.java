/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Ahmad Umar
 */
public class ImageTODatabase {

    public static void main(String[] args) {
        ImageReader();
    }

    public static void ImageReader() {
        Connection connection = null;
        PreparedStatement statement = null;
        FileInputStream input = null;
        try {
            File image = new File("C:\\Users\\dell\\Desktop\\All Folders\\Notes\\Timeline Hitler.pdf");
            input = new FileInputStream(image);
            connection = ConnectorDatabase.getConnection();
            statement = connection.prepareStatement("INSERT INTO filemanagement( name, type, content, user)" + " VALUES ( ?, ?, ?, ?)");
            statement.setString(1, image.getName());

            statement.setString(2, typeFinder(image));
            statement.setBinaryStream(3, (InputStream) input, image.length());
            statement.setString(4, "Aamina");
            
            statement.executeUpdate();
            System.out.println("Successfully Added");

        } catch (Exception e) {
            System.out.println("RunError" + e);
        }

    }

    ;

    public static String typeFinder(File f) {
        String name = f.getName();
        String extension = "";

        int i = name.lastIndexOf('.');
        if (i > 0) {
            extension = name.substring(i + 1);
        }
        return extension;
    }

}
