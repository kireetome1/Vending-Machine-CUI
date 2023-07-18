package vending;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class logindata {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/db1";
	
	static final String USER ="root";
	static final String PASS ="";
	
	static int MAX_ATTEMPTS=3;
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			
			//prompt user name and password
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("ユーザー名入力 : ");
			String username = sc.nextLine();
			System.out.println("パスワード入力 : ");
			String password = sc.nextLine();
			
	/*		
			// Check if user is blocked 
			String sql = "SELECT * FROM managers WHERE Name='bishnu'"; 
			ResultSet rs = stmt.executeQuery(sql); 
			int attempts = 0; 
			java.sql.Timestamp lastAttempt = null; 
			while (rs.next()) { 
				attempts = rs.getInt("attempts"); 
				lastAttempt = rs.getTimestamp("last_attempt");
				}
			rs.close(); 
			// Block user if maximum attempts exceeded 
			if (attempts >= MAX_ATTEMPTS) {
				System.out.println("User is blocked. Last attempt was on " + lastAttempt); 
				return; }
			// Check username and password 
			//String username = "john"; 
			//String password = "mypassword";
			sql = "SELECT * FROM users WHERE Name='" + username + "' AND Password='" + password + "'"; 
			rs = stmt.executeQuery(sql); if (rs.next()) { 
				System.out.println("Login successful."); 
				} else { 
					System.out.println("Login failed."); 
					attempts++; 
					if (attempts >= MAX_ATTEMPTS) { 
						System.out.println("User is now blocked."); 
						} else { 
							// Update login_attempts table 
							sql = "INSERT INTO login_attempts (username, attempts, last_attempt) VALUES ('john', " + attempts + ", CURRENT_TIMESTAMP) ON DUPLICATE KEY UPDATE attempts=" + attempts + ", last_attempt=CURRENT_TIMESTAMP"; 
							stmt.executeUpdate(sql); 
							}
					}
				
		*/	
		//Execute SQL querry to check if username and password match
			//int attempt =0;
			String sql ="Select * from managers WHERE Name='"+username+"' AND Password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
		
			if (rs.next() && (username.equals(username) || password.equals(password))) {
				System.out.println("--------------------------------------------------------");
				System.out.println("ログイン出来ました");
				System.out.println("--------------------------------------------------------");
				kanri.main(args);
			}else{
					System.out.println("失敗しました。");
					System.out.println("--------------------------------------------------------");
					System.out.println("やり直してください");
					//System.out.println(attempt++);
					System.out.println("--------------------------------------------------------");
					//logindata.main(args);
					//attempts++;
					logindata.main(args);
				}
			rs.close();
			stmt.close();
			conn.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt !=null) stmt.close();
			}catch(SQLException se2) {
				}
			try {
				if(conn !=null)conn.close();
			}catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
