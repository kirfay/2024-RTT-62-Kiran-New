package org.example;
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/classic_models";
        String user = "root";
        String password = "Ammomin24";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);
            String SelectSQL = "Select * FROM employees";
            Statement stmt = connection.createStatement();
            ResultSet result =  stmt.executeQuery(SelectSQL);
            while(result.next())
            {
                String employeeID  = result.getString("id");
                String fname = result.getString("firstname");
                String lname  = result.getString("lastname");
                String email = result.getString("email");
                String job_title = result.getString("job_title");
                String format = "%-10s | %-15s | %-15s | %-30s | %-20s%n";

// Use printf to format the output

                System.out.printf(format,id,fname,lname,email,job_title);
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}



