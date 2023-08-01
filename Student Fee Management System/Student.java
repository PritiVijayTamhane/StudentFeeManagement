package main;

import java.sql.*;

public class Student{

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String rUserName = "system";
    private String rUserPass = "sai";

    String[][] data = new String[30][9];
    String[] stdData = new String[11];

    Student(){}

    Student(String name, String email, String course, int fee, int paid, int due, String address, String city, String state, String contact){
        
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO Student VALUES(Student_id.NEXTVAL, '" + name + "', '" + email + "', '" + course + "', '" + fee + "', '" + paid + "', '" + due + "', '" + address + "', '" + city + "', '" + state + "', '" + contact + "')";
            // System.out.println(insertQuery);

            stmt.executeUpdate(insertQuery);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    String[][] viewStudent(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String selectQuery = "SELECT * FROM Student";
            ResultSet resSet = stmt.executeQuery(selectQuery);

            int i = 0;
            while(resSet.next())
            {
                // System.out.println(resSet.getInt(1) + " " + resSet.getString(2) + " " + resSet.getString(3) + " " + resSet.getString(4) + " " + resSet.getString(5));
                int id = resSet.getInt(1);
                String name = resSet.getString(2);
                String email = resSet.getString(3);
                String course = resSet.getString(4);
                int fee = resSet.getInt(5);
                int paid = resSet.getInt(6);
                // String paidFees = Integer.toString(paid);
                int due = resSet.getInt(7);
                // String dueFees = Integer.toString(due);
                String address = resSet.getString(8);
                String city = resSet.getString(9);
                String state = resSet.getString(10);
                String contact = resSet.getString(11);

                String studId = Integer.toString(id);
                String fees = Integer.toString(fee);
                String paidFees = Integer.toString(paid);
                String dueFees = Integer.toString(due);
                String Address = address + " " + city + " " + state;
                // System.out.println(Address);

                data[i][0] = studId;
                data[i][1] = name;
                data[i][2] = email;
                data[i][3] = course;
                data[i][4] = fees;
                data[i][5] = paidFees;
                data[i][6] = dueFees;
                data[i][7] = Address;
                data[i][8] = contact;

                i++;
                
            }

            // for(int j = 0; j < i; j++){
                // for(int k = 0; k < 9; k++){
                //     System.out.print(data[j][k] + "\t");
                // }
            //     System.out.println("\n");
            // }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }

    String[] loadStudent(String roll){
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String selectQuery = "SELECT * FROM Student WHERE RollNo = " + roll;
            ResultSet resSet = stmt.executeQuery(selectQuery);

            
            while(resSet.next())
            {
                // System.out.println(resSet.getInt(1) + " " + resSet.getString(2) + " " + resSet.getString(3) + " " + resSet.getString(4) + " " + resSet.getString(5));
                int id = resSet.getInt(1);
                String name = resSet.getString(2);
                String email = resSet.getString(3);
                String course = resSet.getString(4);
                int fee = resSet.getInt(5);
                int paid = resSet.getInt(6);
                int due = resSet.getInt(7);
                String address = resSet.getString(8);
                String city = resSet.getString(9);
                String state = resSet.getString(10);
                String contact = resSet.getString(11);

                String studId = Integer.toString(id);
                String fees = Integer.toString(fee);
                String paidFees = Integer.toString(paid);
                String dueFees = Integer.toString(due);

             

                stdData[0] = studId;
                stdData[1] = name;
                stdData[2] = email;
                stdData[3] = course;
                stdData[4] = fees;
                stdData[5] = paidFees;
                stdData[6] = dueFees;
                stdData[7] = address;
                stdData[8] = city;
                stdData[9] = state;
                stdData[10] = contact;
                
                
            }

            // for(int k = 0; k < 11; k++){
            //     System.out.print(stdData[k] + "\t");
            // }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return stdData;
    }

    void updateStudent(String roll, String name, String email, String course, int fee, int paid, int due, String address, String city, String state, String contact){
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String updateQuery = "UPDATE Student SET Name = '" + name + "', Email = '" + email + "', Course = '" + course + "', Fee = " + fee + ", Paid = " + paid + ", Due = " + due + ", Address = '" + address + "', City = '" + city + "', State = '" + state + "', Contact = '" + contact + "' WHERE RollNo = " + roll;
            stmt.executeUpdate(updateQuery);

            // System.out.println("ROW UPDATED....");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // return stdData;
    }

    String[][] dueStudent(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String selectQuery = "SELECT * from Student WHERE Due != 0";
            ResultSet resSet = stmt.executeQuery(selectQuery);

            int i = 0;
            while(resSet.next())
            {
                // System.out.println(resSet.getInt(1) + " " + resSet.getString(2) + " " + resSet.getString(3) + " " + resSet.getString(4) + " " + resSet.getString(5));
                int id = resSet.getInt(1);
                String name = resSet.getString(2);
                String email = resSet.getString(3);
                String course = resSet.getString(4);
                int fee = resSet.getInt(5);
                int paid = resSet.getInt(6);
                // String paidFees = Integer.toString(paid);
                int due = resSet.getInt(7);
                // String dueFees = Integer.toString(due);
                String address = resSet.getString(8);
                String city = resSet.getString(9);
                String state = resSet.getString(10);
                String contact = resSet.getString(11);

                String studId = Integer.toString(id);
                String fees = Integer.toString(fee);
                String paidFees = Integer.toString(paid);
                String dueFees = Integer.toString(due);
                String Address = address + " " + city + " " + state;
                // System.out.println(Address);

                data[i][0] = studId;
                data[i][1] = name;
                data[i][2] = email;
                data[i][3] = course;
                data[i][4] = fees;
                data[i][5] = paidFees;
                data[i][6] = dueFees;
                data[i][7] = Address;
                data[i][8] = contact;

                i++;
                
            }

            // for(int j = 0; j < i; j++){
                // for(int k = 0; k < 9; k++){
                //     System.out.print(data[j][k] + "\t");
                // }
            //     System.out.println("\n");
            // }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return data;
    }

    public static void main(String args[])
    {
        
        // Student std = new Student("sai", "sai@gmail.com", "CS", 1000, 500, 500, "hadapsar", "pune", "maha", "1234567890");
        Student stud = new Student();
        // String accData[][] = acc.viewStudent();
        // String student[] = stud.loadStudent("1");
        stud.updateStudent("2", "gauri", "gauri", "gauri", 0, 0, 0, "gauri", "gauri", "gauri", "gauri");
    }
}