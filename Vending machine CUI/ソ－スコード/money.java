package vending;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class money {

	private static String DB_URL ="jdbc:mysql://localhost:3306/db1";
	private static String USER_NAME ="root";
	private static String PASSWORD ="";
	
	public static void main (String args[]) {
		try {
			//connect to databse name
			Connection conn = getConnection (DB_URL,USER_NAME,PASSWORD);
			//create statement
			Statement stmt =conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from money");
			//show data
			
			System.out.printf("%4s","Amount ","= ");
			while (rs.next()) {
				System.out.printf("%4s \n",rs.getInt(1)+"円");
				System.out.println("\n");
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
