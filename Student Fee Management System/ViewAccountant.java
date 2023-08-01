package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.AdminLogin;
import main.AdminSection;

import java.sql.*;

public class ViewAccountant {
    
    JFrame frame = new JFrame("Accountants");
    JLabel label1 = new JLabel("Accountants");
    JButton backButton = new JButton("Back");
    JTable accountants;
    JScrollPane scrollPane;

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String rUserName = "system";
    private String rUserPass = "sai";

    String[] headings = {"ID", "NAME", "PASSWORD", "EMAIL", "CONTACT NO"};

    ViewAccountant(){

        backButton.setFont(new Font("Poor Richard", Font.BOLD, 20));
        backButton.setBounds(250, 500, 150, 30);
        

        Accountant acc = new Accountant();
        String data[][] = acc.viewAccountant();

        accountants = new JTable(data, headings);
        scrollPane = new JScrollPane(accountants);

        frame.add(label1);
        frame.add(backButton);
        frame.add(scrollPane);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent A){
                AdminSection admSec = new AdminSection();
                admSec.frame.setVisible(true);
                frame.setVisible(false);
            }
        });

        frame.setSize(700, 700);
        frame.setVisible(true);

    }

    public static void main(String args[])
    {
        new ViewAccountant();
    }
}
