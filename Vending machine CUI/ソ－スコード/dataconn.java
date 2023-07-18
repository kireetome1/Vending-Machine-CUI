package vending;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dataconn {
	
	private static String DB_URL ="jdbc:mysql://localhost:3306/db1";
	private static String USER_NAME ="root";
	private static String PASSWORD ="";
	public static void main (String args[]) {
		try {
			//connect to databse name
			Connection conn = getConnection (DB_URL,USER_NAME,PASSWORD);
			//create statement
			Statement stmt =conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id,name,price, (15-quantity)*price , 15-quantity from drink");
			//show data
			System.out.printf("%2s %-11s %3s %4s %15s \n","ID","Name","Price","Sale_Amount","Sold_Quantity");
			while (rs.next()) {
				
				System.out.printf("%-2d %-11s %3d %7s %15s \n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
			}
			//close connection
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection (String dbURL,String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(dbURL,userName,password);
			System.out.println("Connect Successfully");
		}catch(Exception ex) {
			System.out.print("Connect failure");
			ex.printStackTrace();
		}
		return conn;
	}
}
