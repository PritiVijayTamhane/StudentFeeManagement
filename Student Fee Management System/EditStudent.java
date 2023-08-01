package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.AccountantSection;
import main.Student;

public class EditStudent {
    
    JFrame frame = new JFrame("Edit Student");
    JLabel label1 = new JLabel("Edit Student");
    JLabel roll = new JLabel("Roll No");
    JLabel name = new JLabel("Name");
    JLabel email = new JLabel("E-mail");
    JLabel course = new JLabel("Course");
    JLabel fee = new JLabel("Fee");
    JLabel paid = new JLabel("Paid");
    JLabel address = new JLabel("Address");
    JLabel city = new JLabel("City");
    JLabel state = new JLabel("State");
    JLabel contact = new JLabel("Contact No");
    JTextField rollField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField courseField = new JTextField();
    JTextField feeField = new JTextField();
    JTextField paidField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField cityField = new JTextField();
    JTextField stateField = new JTextField();
    JTextField contactField = new JTextField();
    JButton updateButton = new JButton("Update Student");
    JButton backButton = new JButton("Back");
    JButton loadButton = new JButton("Load Record");
    String rNo, uName, uEmail, uCourse, uFee, uPaid, uDue, uAddress, uCity, uState, uContact; 

    EditStudent(){

        frame.setLayout(null);
        frame.setSize(900, 900);
        frame.setVisible(true);

        label1.setFont(new Font("Poor Richard", Font.BOLD, 40));
        label1.setBounds(250, 30, 400, 100);

        roll.setFont(new Font("Poor Richard", Font.BOLD, 15));
        roll.setBounds(150, 130, 90, 40);
        rollField.setBounds(300, 140, 300, 30);

        name.setFont(new Font("Poor Richard", Font.BOLD, 15));
        name.setBounds(150, 220, 90, 40);
        nameField.setBounds(300, 230, 300, 30);

        email.setFont(new Font("Poor Richard", Font.BOLD, 15));
        email.setBounds(150, 270, 90, 40);
        emailField.setBounds(300, 280, 300, 30);

        course.setFont(new Font("Poor Richard", Font.BOLD, 15));
        course.setBounds(150, 320, 90, 40);
        courseField.setBounds(300, 330, 300, 30);

        fee.setFont(new Font("Poor Richard", Font.BOLD, 15));
        fee.setBounds(150, 370, 90, 40);
        feeField.setBounds(300, 380, 300, 30);

        paid.setFont(new Font("Poor Richard", Font.BOLD, 15));
        paid.setBounds(150, 420, 90, 40);
        paidField.setBounds(300, 430, 300, 30);

        address.setFont(new Font("Poor Richard", Font.BOLD, 15));
        address.setBounds(150, 470, 90, 40);
        addressField.setBounds(300, 480, 300, 30);

        city.setFont(new Font("Poor Richard", Font.BOLD, 15));
        city.setBounds(150, 520, 90, 40);
        cityField.setBounds(300, 530, 300, 30);

        state.setFont(new Font("Poor Richard", Font.BOLD, 15));
        state.setBounds(150, 570, 90, 40);
        stateField.setBounds(300, 580, 300, 30);

        contact.setFont(new Font("Poor Richard", Font.BOLD, 15));
        contact.setBounds(150, 620, 90, 40);
        contactField.setBounds(300, 630, 300, 30);

        backButton.setFont(new Font("Poor Richard", Font.BOLD, 15));
        backButton.setBounds(200, 720, 150, 30);

        updateButton.setFont(new Font("Poor Richard", Font.BOLD, 15));
        updateButton.setBounds(400, 720, 150, 30);

        loadButton.setFont(new Font("Poor Richard", Font.BOLD, 15));
        loadButton.setBounds(300, 180, 150, 30);


        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent A){

                rNo = rollField.getText();

                Student stud = new Student();
                String studData[] = stud.loadStudent(rNo); 

                nameField.setText(studData[1]);
                emailField.setText(studData[2]);
                courseField.setText(studData[3]);
                feeField.setText(studData[4]);
                paidField.setText(studData[5]);
                addressField.setText(studData[7]);
                cityField.setText(studData[8]);
                stateField.setText(studData[9]);
                contactField.setText(studData[10]);

            }
        });

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                AccountantSection accSec = new AccountantSection();
                accSec.frame.setVisible(true);

                frame.setVisible(false);
            }
        });

        updateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent A)
            {
                rNo = rollField.getText();
                uName = nameField.getText();
                uEmail = emailField.getText();
                uCourse = courseField.getText();
                uFee = feeField.getText();
                uPaid = paidField.getText();
                uAddress = addressField.getText();
                uCity = cityField.getText();
                uState = stateField.getText();
                uContact = contactField.getText();

                int fee, paidFee, dueFee;
                
                fee = Integer.parseInt(uFee);
                paidFee = Integer.parseInt(uPaid);

                if(paidFee > fee)
                {
                    String alertMsg = "INVALID VALUE";
                    JOptionPane.showMessageDialog(frame, alertMsg);
                }

                dueFee = fee - paidFee;

                Student student = new Student();
                student.updateStudent(rNo, uName, uEmail, uCourse, fee, paidFee, dueFee, uAddress, uCity, uState, uContact);
                
                String alertMsg = "STUDENT UPDATED SUCCESSFULLY";
                
                JOptionPane.showMessageDialog(frame, alertMsg);

                frame.setVisible(false);

                AccountantSection accSec = new AccountantSection();
                accSec.frame.setVisible(true);
            }
        });

        frame.add(label1);
        frame.add(roll);
        frame.add(rollField);
        frame.add(loadButton);
        frame.add(updateButton);
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
        new EditStudent();
    }
}