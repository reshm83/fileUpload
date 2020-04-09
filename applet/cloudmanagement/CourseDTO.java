/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.applet.cloudmanagement;

import com.ahmad.db.ConnectorDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Ahmad Umar
 */
public class CourseDTO {

    public static List<FileManagement> selectFiles() {
        List<FileManagement> files = new ArrayList<FileManagement>();
        Connection connection = null;
        String selectFiles = "select * from filemanagement";
        try {
            connection = ConnectorDatabase.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectFiles);
            while (result.next()) {                
                FileManagement file = new FileManagement();
                file.setS_No(result.getInt(1));
                file.setName(result.getString(2));
                file.setType(result.getString(3));
                file.setUser(result.getString(5));
                files.add(file);
            }
        } catch (Exception e) {
            System.err.println("Exception:  -- " + e);
        }
        
        return files;
    }
}


