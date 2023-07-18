package vending;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

public class itemupdate { 
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/db1"; 
		String username = "root"; String password = ""; 
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
		/*	// Get the name and quantity of the drink purchased from the user
			System.out.print("Enter the name of the drink: "); 
			String drinkName = scanner.nextLine(); 
			System.out.print("Enter the quantity purchased: "); 
			int quantityPurchased = scanner.nextInt(); 
			*/
			
			
			 System.out.println("ようこそ自動販売機へ。"); 
			 System.out.println("-----------------------------");
			 System.out.println("ID 商品　　　  販売    単価");
			 System.out.println("-----------------------------");
			 System.out.println("1.Lassi"+" 　　　  ○　   220\n");
			 System.out.println("2.Mango_Lassi"+"   ○　   250\n");
			 System.out.println("3.Yogurt"+"　　    ○　   180\n");
			 System.out.println("4.Water"+"　　　　 ○　   110\n");
			 System.out.println("5.Coca-Cola"+"　　 ○　   150\n");
			 System.out.println("6.Green-Tea"+"　　 ○　   120\n");
			 System.out.println("7.Milk-Tea"+"　    ○　   130\n");
			 System.out.println("-----------------------------");
			 
			 

		// 購入可能商品表示機能
		Map<String, Integer> items = new HashMap<String, Integer>();
		items.put("Lassi",         220);
		items.put("Mango_Lassi", 250);
		items.put("Yogurt",     180);
		items.put("Water",           110);
		items.put("Coca-Cola",     150);
		items.put("Green-Tea",           120);
		items.put("Milk-Tea",   130);
	     // 購入金額確認機能
		//int money= 0;
		int deposit = 0;
		int max = 1990;
		int minSaleAmount = -1;
		 Scanner scanner = new Scanner(System.in);
		do {
		// 入金処理
		System.out.println("お金を入れて下さい。");
		System.out.println("-----------------------------");
		System.out.println(">>");
		deposit = deposit + scanner.nextInt();
		 System.out.println();
		 System.out.println("投入お金は: "+deposit);
		 if (deposit <110){
		
		System.out.println("お金が足りません");
	    System.out.println("お金を入れて下さい。");
	    System.out.println(">>");
		deposit = deposit + scanner.nextInt();
		System.out.println("-----------------------------");
		 System.out.println("投入合計お金は: "+deposit);
		 
		}
		 else if(deposit>=max) {
				System.out.println("お金が不可です返却します。");
				System.out.println("返却お金は　：　"+ deposit);
				System.out.println("-----------------------------");
				System.out.println("-----------------------------");
				System.out.println(">>");
				itemupdate.main(args);
			}
		 
		// 投入金額表示機能
			int loopCount = 0;
			 for (String itemKey: items.keySet()) {
			 if(loopCount == 0 || minSaleAmount > items.get(itemKey)) {
			 minSaleAmount = items.get(itemKey);
		     }
			loopCount++;
		      }
			} while(deposit < minSaleAmount);


			 // 商品選択
			System.out.println("-----------------------------");
			System.out.println("商品を選択してください。");
			 Map<String, Integer> availablePurchases = new HashMap<String, Integer>();
		    for (String itemKey: items.keySet()) {
			if(deposit >= items.get(itemKey)) {
			 System.out.println(itemKey + ":" + items.get(itemKey) + "円");
			 availablePurchases.put(itemKey, items.get(itemKey));
			
			}
			
			
			}
		    System.out.println("-----------------------------");
		    System.out.println(">>");
		    
		 // 販売と売り切り表示機能
			String itemName;
			 while(true) {
			 itemName = scanner.next();
			 if (availablePurchases.containsKey(itemName)){
			break;
			}
			System.out.println("商品名の指定が誤っています。商品名を指定し直してください。");
			}
//			scanner.close();
			 System.out.println("-----------------------------");
			 
			 System.out.println("********");
			 System.out.println(itemName + "です！");
			 System.out.println("********");
			 System.out.println("-----------------------------");
			 
			 
			 
			 
			 System.out.println("-----------------------------------------------------------");
			 

			

			// お金返却機能
			 deposit = deposit - availablePurchases.get(itemName).intValue();
			 System.out.println("お釣りの為にレバーを押したい場合は'0'を押してください。");
			// System.out.println("お釣りいらない場合は'1'を押してください。");
			 System.out.println("-----------------------------------------------------------");
			 System.out.println(">>");
			 //if lever pressed the money will come out
			 byte returnamt = scanner.nextByte();
			 
			 if (returnamt ==0) {
				 System.out.println("-----------------------------");
				 System.out.println("おつりは、" + deposit + "円です。");
				 System.out.println("-----------------------------");
				 System.out.println("-----------------------------");
				 System.out.println("        ---------------------");
				 System.out.println("           ------------------");
				 System.out.println("              --------------");
				 System.out.println("                 ------------");
				 System.out.println("                    ---------");
				 System.out.println("                        -----");
				 System.out.println("                           --");
				 System.out.println("                        -----");
				 System.out.println("                    ---------");
				 System.out.println("                -------------");
				 System.out.println("            -----------------");
				 System.out.println("         --------------------");
				 System.out.println("    -------------------------");
				 System.out.println(" ----------------------------");
				 System.out.println("             ----------------");
				 System.out.println("                      -------");
				 System.out.println("-----------------------------");
				 
				
			// Retrieve the current quantity of the drink from the database
			PreparedStatement stmt = conn.prepareStatement("SELECT Quantity FROM drink WHERE Name = ?"); 
			stmt.setString(1, itemName); 
			ResultSet rs = stmt.executeQuery(); 
		
			int currentQuantity = 0; 
			if (rs.next()) { 
				currentQuantity = rs.getInt("quantity"); 
				
			} 
			
			// Calculate the new quantity of the drink 
			int newQuantity = currentQuantity - 1;
			
			// Update the database with the new quantity 
			
			PreparedStatement updateStmt = conn.prepareStatement("UPDATE drink SET Quantity = ? WHERE Name = ?");
			updateStmt.setInt(1, newQuantity);
			updateStmt.setString(2, itemName);
			updateStmt.executeUpdate(); 
			System.out.println("Database updated successfully!");
			
			
			// Retrieve the current quantity of the drink from the database
			PreparedStatement stmt1 = conn.prepareStatement("SELECT * FROM money WHERE Amount = ?"); 
			stmt.setInt(1, availablePurchases.get(itemName).intValue()); 
		    ResultSet rs1 = stmt.executeQuery(); 
			int currentmoney = 0; 
		    if (rs1.next()) { 
			currentmoney = rs.getInt("amount"); 
							
			} 
						
			// Calculate the new quantity of the drink 
			int newmoney =currentmoney + availablePurchases.get(itemName).intValue();
						
			// Update the database with the new quantity 
						
			PreparedStatement updateStmt1 = conn.prepareStatement("UPDATE money SET Amount = ? ");
			
	//		
			updateStmt1.setInt(1, newmoney);
			
	
		   
			updateStmt1.executeUpdate(); 
			System.out.println("Database updated successfully!");
			main1.main(args);
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace(); 
			}
	}
}
		