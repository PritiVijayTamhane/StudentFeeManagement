package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AccountantLogin {
    
    JFrame frame = new JFrame("Accountant Login");
    JLabel label1 = new JLabel("Accountant Login");
    JLabel name = new JLabel("Name");
    JLabel password = new JLabel("Password");
    JButton logButton = new JButton("Login");
    JButton backButton = new JButton("Back");
    JTextField nameField = new JTextField();
    JTextField passField = new JTextField();

    String userName, userPass;

    AccountantLogin(){

        frame.setLayout(null);
        frame.setSize(700, 700);
        frame.setVisible(true);

        label1.setFont(new Font("Poor Richard", Font.BOLD, 40));
        label1.setBounds(250, 50, 400, 100);

        name.setFont(new Font("Poor Richard", Font.BOLD, 20));
        name.setBounds(150, 200, 90, 40);
        nameField.setBounds(300, 200, 300, 30);

        password.setFont(new Font("Poor Richard", Font.BOLD, 20));
        password.setBounds(150, 250, 90, 40);
        passField.setBounds(300, 260, 300, 30);

        backButton.setFont(new Font("Poor Richard", Font.BOLD, 20));
        backButton.setBounds(200, 400, 150, 30);

        logButton.setFont(new Font("Poor Richard", Font.BOLD, 20));
        logButton.setBounds(400, 400, 150, 30);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                FeeReport feeReport = new FeeReport();
                feeReport.frame.setVisible(true);

                frame.setVisible(false);
            }
        });

        logButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                userName = nameField.getText();
                Accountant acc = new Accountant();
                String uPass = acc.getPassword(userName);
                userPass = passField.getText();

                if(!(userName.isEmpty()) && !(userPass.isEmpty())){

                    if(userPass.equals(uPass)){
                        String alertMsg = "LOGIN SUCCESSFULL";

                        JOptionPane.showMessageDialog(frame, alertMsg);

                        AccountantSection accSec = new AccountantSection();
                    }
                    else{
                        String alertMsg = "INVALID CREDENTIALS";
                        JOptionPane.showMessageDialog(frame, alertMsg);
                    }
                }
                else{
                    String alertMsg = "ALL FIELDS ARE COMPULSORY";
                    JOptionPane.showMessageDialog(frame, alertMsg);
                }

                frame.setVisible(false);
            }
        });

        frame.add(label1);
        frame.add(logButton);
        frame.add(backButton);
        frame.add(name);
        frame.add(nameField);
        frame.add(password);
        frame.add(passField);

    }

    public static void main(String args[])
    {
        new AccountantLogin();
    }
}