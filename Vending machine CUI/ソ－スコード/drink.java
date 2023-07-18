package vending;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class drink {
    private static String DB_URL = "jdbc:mysql://localhost:3306/db1";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
 
  
    public static void main(String args[]) {
        try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from drink");
            // show data
            
            System.out.printf("%2s %-11s %3s %4s \n","ID","Name","Price","Quantity");
            while (rs.next()) {
                System.out.printf("%-2s %-11s %3s %4s \n",rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
 

    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}