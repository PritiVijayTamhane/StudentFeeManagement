package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.Accountant;
import main.AdminSection;

public class AddAccountant {
    
    JFrame frame = new JFrame("Add Accountant");
    JLabel label1 = new JLabel("Add Accountant");
    JLabel name = new JLabel("Name");
    JLabel password = new JLabel("Password");
    JLabel email = new JLabel("E-mail");
    JLabel contact = new JLabel("Contact No");
    JTextField nameField = new JTextField();
    JTextField passField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField contactField = new JTextField();
    JButton addButton = new JButton("Add Accountant");
    JButton backButton = new JButton("Back");
    String uName, uPass, uEmail, uContact;

    AddAccountant(){

        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setVisible(true);

        label1.setFont(new Font("Poor Richard", Font.BOLD, 40));
        label1.setBounds(250, 50, 400, 100);

        name.setFont(new Font("Poor Richard", Font.BOLD, 15));
        name.setBounds(150, 150, 90, 40);
        nameField.setBounds(300, 160, 300, 30);

        password.setFont(new Font("Poor Richard", Font.BOLD, 15));
        password.setBounds(150, 200, 90, 40);
        passField.setBounds(300, 210, 300, 30);

        email.setFont(new Font("Poor Richard", Font.BOLD, 15));
        email.setBounds(150, 250, 90, 40);
        emailField.setBounds(300, 260, 300, 30);

        contact.setFont(new Font("Poor Richard", Font.BOLD, 15));
        contact.setBounds(150, 300, 90, 40);
        contactField.setBounds(300, 310, 300, 30);

        backButton.setFont(new Font("Poor Richard", Font.BOLD, 15));
        backButton.setBounds(200, 400, 150, 30);

        addButton.setFont(new Font("Poor Richard", Font.BOLD, 15));
        addButton.setBounds(400, 400, 150, 30);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                AdminSection admSec = new AdminSection();
                admSec.frame.setVisible(true);

                frame.setVisible(false);
            }
        });

        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                uName = nameField.getText();
                uPass = passField.getText();
                uEmail = emailField.getText();
                uContact = contactField.getText();

                Accountant acc = new Accountant(uName, uPass, uEmail, uContact);

                String alertMsg = "Accountant Added Successfully";

                JOptionPane.showMessageDialog(frame, alertMsg);

                frame.setVisible(false);

                AdminSection admSec = new AdminSection();
                admSec.frame.setVisible(true);
            }
        });

        frame.add(label1);
        frame.add(addButton);
        frame.add(backButton);
        frame.add(name);
        frame.add(nameField);
        frame.add(password);
        frame.add(passField);
        frame.add(email);
        frame.add(emailField);
        frame.add(contact);
        frame.add(contactField);

    }

    public static void main(String args[])
    {
        new AddAccountant();
    }
}