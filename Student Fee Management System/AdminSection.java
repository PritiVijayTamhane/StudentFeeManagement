package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.AddAccountant;
import main.FeeReport;

public class AdminSection {
    
    JFrame frame = new JFrame("Admin Section");
    JLabel label1 = new JLabel("Admin Section");
    JButton button1 = new JButton("Add Accountant");
    JButton button2 = new JButton("View Accountant");
    JButton button3 = new JButton("Logout");

    AdminSection(){

        frame.setLayout(null);
        frame.setSize(700, 700);
        frame.setVisible(true);

        // label1.setText("Select User");
        label1.setFont(new Font("Poor Richard", Font.BOLD, 40));
        label1.setBounds(250, 50, 400, 100);

        button1.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button1.setBounds(200, 200, 300, 50);

        button2.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button2.setBounds(200, 300, 300, 50);

        button3.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button3.setBounds(200, 400, 300, 50);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                AddAccountant addAccountant = new AddAccountant();
            }
        });

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                ViewAccountant viewAccountant = new ViewAccountant();
            }
        });

        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                FeeReport feeReport = new FeeReport();
            }
        });

        frame.add(label1);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

    }

    public static void main(String args[])
    {
        new AdminSection();
    }
}
