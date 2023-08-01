package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.AddStudent;
import main.DueFee;
import main.FeeReport;
import main.ViewStudent;

public class AccountantSection {
    
    JFrame frame = new JFrame("Accountant Section");
    JLabel label1 = new JLabel("Accountant Section");
    JButton button1 = new JButton("Add Student");
    JButton button2 = new JButton("View Student");
    JButton button3 = new JButton("Edit Student");
    JButton button4 = new JButton("Due Fee");
    JButton button5 = new JButton("Logout");


    AccountantSection(){

        frame.setLayout(null);
        frame.setSize(700, 700);
        frame.setVisible(true);

        // label1.setText("Select User");
        label1.setFont(new Font("Poor Richard", Font.BOLD, 40));
        label1.setBounds(200, 50, 400, 100);

        button1.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button1.setBounds(200, 200, 300, 50);

        button2.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button2.setBounds(200, 280, 300, 50);

        button3.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button3.setBounds(200, 360, 300, 50);

        button4.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button4.setBounds(200, 440, 300, 50);

        button5.setFont(new Font("Poor Richard", Font.BOLD, 20));
        button5.setBounds(200, 520, 300, 50);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                AddStudent addStud = new AddStudent();
            }
        });

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                ViewStudent viewStud = new ViewStudent();
            }
        });

        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                EditStudent edtStud = new EditStudent();
            }
        });

        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                DueFee dueFee = new DueFee();
            }
        });

        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                FeeReport feeReport = new FeeReport();
                feeReport.frame.setVisible(true);
            }
        });

        frame.add(label1);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);

    }

    public static void main(String args[])
    {
        new AccountantSection();
    }
}
