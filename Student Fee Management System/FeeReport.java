package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FeeReport {
    
    JFrame frame = new JFrame("Login Page");
    JLabel label1 = new JLabel("Select User");
    JButton button1 = new JButton("Admin");
    JButton button2 = new JButton("Accountant");

    FeeReport(){

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

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                AdminLogin adminLog = new AdminLogin();
            }
        });

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                frame.setVisible(false);
                AccountantLogin accLog = new AccountantLogin();
            }
        });

        frame.add(label1);
        frame.add(button1);
        frame.add(button2);

    }

    public static void main(String args[])
    {
        new FeeReport();
    }
}
