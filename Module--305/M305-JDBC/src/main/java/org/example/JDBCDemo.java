package org.example;
import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        String user = "root";
        String password = "Ammomin24";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first name of the employee you want to search for: ");
            String input = scanner.nextLine();
            String lastnameInput = "Doe";
            String SelectSQL = "Select * FROM employees where firstname = ? or lastname = ? ";

            //Statement stmt = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement(SelectSQL);
            stmt.setString(1,input);
            stmt.setString(2,lastnameInput);


            ResultSet result =  stmt.executeQuery();

            while(result.next())  //is there a next record//
            {
                String employeeID  = result.getString("id");
                String fname = result.getString("firstname");
                String lname  = result.getString("lastname");
                String email = result.getString("email");
                String job_title = result.getString("job_title");
                String format = "%-10s | %-15s | %-15s | %-30s | %-20s%n";
                System.out.println(employeeID + " | " + fname + " | " + lname + " | " + email + " | " + job_title);
// Use printf to format the output



            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}



