package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.AdminLogin;
import main.AdminSection;

import java.sql.*;

public class DueFee {
    
    JFrame frame = new JFrame("Students");
    JLabel label1 = new JLabel("Students");
    JButton backButton = new JButton("Back");
    JTable due;
    JScrollPane scrollPane;

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String rUserName = "system";
    private String rUserPass = "sai";

    String[] headings = {"ROLL NO", "NAME", "EMAIL", "COURSE", "APPLICABLE FEES", "PAID FEES", "DUE FEES", "ADDRESS", "CONTACT"};

    DueFee(){

        backButton.setFont(new Font("Poor Richard", Font.BOLD, 20));
        backButton.setBounds(300, 600, 150, 30);

        Student stud = new Student();
        String data[][] = stud.dueStudent();

        due = new JTable(data, headings);
        scrollPane = new JScrollPane(due);

        frame.add(backButton);
        frame.add(scrollPane);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent A){
                AccountantSection accSec = new AccountantSection();
                accSec.frame.setVisible(true);
                frame.setVisible(false);
            }
        });

        frame.setSize(900, 800);
        frame.setVisible(true);

    }

    public static void main(String args[])
    {
        new DueFee();
    }
}
