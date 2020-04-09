/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.db;

/**
 *
 * @author Ahmad Umar
 */
import java.io.*;
import java.sql.*;

public class GetBlob {

    FileOutputStream image;
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet res = null;
    StringBuffer query = null;

    public GetBlob(int s_no, String folder) {
        try {
            con = ConnectorDatabase.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from filemanagement where s_no=" + s_no);
            if (rs.next()) {
                Blob test = rs.getBlob("content");
                InputStream x = test.getBinaryStream();
                int size = x.available();
                OutputStream out = new FileOutputStream(folder +"."+rs.getString(3));
                byte b[] = new byte[size];
                x.read(b);
                out.write(b);
            }
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
