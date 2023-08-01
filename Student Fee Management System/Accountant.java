package main;

import java.sql.*;

public class Accountant{

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String rUserName = "system";
    private String rUserPass = "sai";
    private String password;

    String[][] data = new String[10][5];

    Accountant(){}

    String getPassword(String username){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            
            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String Query = "SELECT Password FROM Accountant WHERE Name = '" + username + "'C";

            ResultSet resSet = stmt.executeQuery(Query);

            while(resSet.next()){

                password = resSet.getString(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return password;
    }

    Accountant(String username, String pass, String email, String contact){
        
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO Accountant VALUES(Accountant_id.NEXTVAL, '" + username + "', '" + pass + "', '" + email + "', '" + contact + "')";
            // System.out.println(insertQuery);

            stmt.executeUpdate(insertQuery);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    String[][] viewAccountant(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection(url, rUserName, rUserPass);

            Statement stmt = con.createStatement();

            String selectQuery = "SELECT * FROM Accountant";
            ResultSet resSet = stmt.executeQuery(selectQuery);

            int i = 0;
            while(resSet.next())
            {
                // System.out.println(resSet.getInt(1) + " " + resSet.getString(2) + " " + resSet.getString(3) + " " + resSet.getString(4) + " " + resSet.getString(5));
                int id = resSet.getInt(1);
                String accId = Integer.toString(id);
                String name = resSet.getString(2);
                String pass = resSet.getString(3);
                String email = resSet.getString(4);
                String contact = resSet.getString(5);

                data[i][0] = accId;
                data[i][1] = name;
                data[i][2] = pass;
                data[i][3] = email;
                data[i][4] = contact;
                
                i++;
            }

            // for(int j = 0; j < i; j++){
            //     for(int k = 0; k < 5; k++){
            //         System.out.print(data[j][k] + "\t");
            //     }
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
        Accountant acc = new Accountant();
        String accData[][] = acc.viewAccountant();
    }
}