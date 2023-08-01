package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.AccountantSection;
import main.Student;

public class AddStudent {
    
    JFrame frame = new JFrame("Add Student");
    JLabel label1 = new JLabel("Add Student");
    JLabel name = new JLabel("Name");
    JLabel email = new JLabel("E-mail");
    JLabel course = new JLabel("Course");
    JLabel fee = new JLabel("Fee");
    JLabel paid = new JLabel("Paid");
    JLabel address = new JLabel("Address");
    JLabel city = new JLabel("City");
    JLabel state = new JLabel("State");
    JLabel contact = new JLabel("Contact No");
    JTextField nameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField courseField = new JTextField();
    JTextField feeField = new JTextField();
    JTextField paidField = new JTextField();
    JTextField dueField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField cityField = new JTextField();
    JTextField stateField = new JTextField();
    JTextField contactField = new JTextField();
    JButton addButton = new JButton("Add Student");
    JButton backButton = new JButton("Back");
    String uName, uEmail, uCourse, uFee, uPaid, uDue, uAddress, uCity, uState, uContact; 

    AddStudent(){

        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setVisible(true);

        label1.setFont(new Font("Poor Richard", Font.BOLD, 40));
        label1.setBounds(250, 50, 400, 100);

        name.setFont(new Font("Poor Richard", Font.BOLD, 15));
        name.setBounds(150, 150, 90, 40);
        nameField.setBounds(300, 160, 300, 30);

        email.setFont(new Font("Poor Richard", Font.BOLD, 15));
        email.setBounds(150, 200, 90, 40);
        emailField.setBounds(300, 210, 300, 30);

        course.setFont(new Font("Poor Richard", Font.BOLD, 15));
        course.setBounds(150, 250, 90, 40);
        courseField.setBounds(300, 260, 300, 30);

        fee.setFont(new Font("Poor Richard", Font.BOLD, 15));
        fee.setBounds(150, 300, 90, 40);
        feeField.setBounds(300, 310, 300, 30);

        paid.setFont(new Font("Poor Richard", Font.BOLD, 15));
        paid.setBounds(150, 350, 90, 40);
        paidField.setBounds(300, 360, 300, 30);

        address.setFont(new Font("Poor Richard", Font.BOLD, 15));
        address.setBounds(150, 400, 90, 40);
        addressField.setBounds(300, 410, 300, 30);

        city.setFont(new Font("Poor Richard", Font.BOLD, 15));
        city.setBounds(150, 450, 90, 40);
        cityField.setBounds(300, 460, 300, 30);

        state.setFont(new Font("Poor Richard", Font.BOLD, 15));
        state.setBounds(150, 500, 90, 40);
        stateField.setBounds(300, 510, 300, 30);

        contact.setFont(new Font("Poor Richard", Font.BOLD, 15));
        contact.setBounds(150, 550, 90, 40);
        contactField.setBounds(300, 560, 300, 30);

        backButton.setFont(new Font("Poor Richard", Font.BOLD, 15));
        backButton.setBounds(200, 720, 150, 30);

        addButton.setFont(new Font("Poor Richard", Font.BOLD, 15));
        addButton.setBounds(400, 720, 150, 30);

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                AccountantSection accSec = new AccountantSection();
                accSec.frame.setVisible(true);

                frame.setVisible(false);
            }
        });

        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                uName = nameField.getText();
                uEmail = emailField.getText();
                uCourse = courseField.getText();
                uFee = feeField.getText();
                uPaid = paidField.getText();
                // uDue = dueField.getText();
                uAddress = addressField.getText();
                uCity = cityField.getText();
                uState = stateField.getText();
                uContact = contactField.getText();

                int fee, paidFee, dueFee;
                
                fee = Integer.parseInt(uFee);
                paidFee = Integer.parseInt(uPaid);
                // dueFee = Integer.parseInt(uDue);

                if(paidFee > fee)
                {
                    String alertMsg = "INVALID VALUE";
                    JOptionPane.showMessageDialog(frame, alertMsg);
                }

                dueFee = fee - paidFee;

                Student student = new Student(uName, uEmail, uCourse, fee, paidFee, dueFee, uAddress, uCity, uState, uContact);
                
                String alertMsg = "STUDENT ADDED SUCCESSFULLY";
                
                JOptionPane.showMessageDialog(frame, alertMsg);

                frame.setVisible(false);

                AccountantSection accSec = new AccountantSection();
                accSec.frame.setVisible(true);
            }
        });

        frame.add(label1);
        frame.add(addButton);
        frame.add(backButton);
        frame.add(name);
        frame.add(nameField);
        frame.add(email);
        frame.add(emailField);
        frame.add(course);
        frame.add(courseField);
        frame.add(fee);
        frame.add(feeField);
        frame.add(paid);
        frame.add(paidField);
        frame.add(address);
        frame.add(addressField);
        frame.add(city);
        frame.add(cityField);
        frame.add(state);
        frame.add(stateField);
        frame.add(contact);
        frame.add(contactField);

    }

    public static void main(String args[])
    {
        new AddStudent();
    }
}