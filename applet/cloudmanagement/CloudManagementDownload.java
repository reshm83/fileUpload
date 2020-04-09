/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmad.applet.cloudmanagement;

import com.ahmad.db.GetBlob;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel; 

/**
 *
 * @author Ahmad Umar Usmani
 */
public class CloudManagementDownload {

    JFrame f;

    public CloudManagementDownload() {
        f = new JFrame();
        JLabel fileName = new JLabel("File Name");
        JLabel fileType = new JLabel("File Type");
        JLabel userName = new JLabel("User Name");
        JLabel download = new JLabel("Download");
        List<FileManagement> files = CourseDTO.selectFiles();
        f.setLayout(new GridLayout(files.size() + 1, 3));

        f.add(fileName);
        f.add(fileType);
        f.add(userName);
        f.add(download);
        printFileList();
        f.setVisible(true);
        f.setSize(new Dimension(600, 400));

        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new CloudManagementDownload();
    }

    private void printFileList() {
        List<FileManagement> files = CourseDTO.selectFiles();
        for (FileManagement file : files) {

            JLabel fileName1 = new JLabel(file.getName());
            JLabel fileType1 = new JLabel(file.getType());
            JLabel userName1 = new JLabel(file.getUser());
            JButton download1 = new JButton("Download");
            download1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showDialog(null, "Download");
                    String fileLocation = fileChooser.getSelectedFile().toString();
                    System.err.println(fileLocation);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String test = fileLocation +"ahmad.js";
                        System.out.println(test);
                        new GetBlob(file.getS_No(), fileLocation);
                    }
                    System.out.println("actionPerformed()");
                }
            });
            f.add(fileName1);
            f.add(fileType1);
            f.add(userName1);
            f.add(download1);

        }
    }
}
