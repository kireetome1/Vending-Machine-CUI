package vending;

import java.util.Scanner;

public class kanri {
	
	public static void main (String args[]) {
		
		Scanner input = new Scanner(System.in);
			
		System.out.println("");
		
		System.out.println("---------------------------------------------------");
		
		System.out.println("1. 在庫確認");
		System.out.println("2. 販売確認");
		System.out.println("3. 残高確認");
		
		System.out.println("---------------------------------------------------");
		
		System.out.println("入力お願いします : 1   /   2   /  3");
		System.out.println("---------------------------------------------------");
		System.out.println(">>");
		
		byte button = input.nextByte();
		if(button==1) {
			drink.main(args);
			
			System.out.println("---------------------------------------------------");
			System.out.println("1. ホーム画面 ");
			System.out.println("2. 戻る ");
			System.out.println("---------------------------------------------------");
			System.out.println("入力お願いします : 1   /   2   ");
			System.out.println(">>");
			
			byte remote = input.nextByte();
			if(remote == 1 ) {
				try {
					main1.main(args);
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			else if(remote == 2) {
				kanri.main(args);
				
			}
		}
		else if (button==2) {
			dataconn.main(args);
			
			System.out.println("---------------------------------------------------");
			
			System.out.println("1. ホーム画面 ");
			System.out.println("2. 戻る ");
			
			
			System.out.println("---------------------------------------------------");
			System.out.println("入力お願いします : 1   /   2   ");
			System.out.println(">>");
			byte remote1 = input.nextByte();
			if(remote1 == 1 ) {
				try {
					main1.main(args);
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			else if(remote1 == 2) {
				kanri.main(args);
				
			}
		}
		else if (button ==3) {
			money.main(args);
			
			System.out.println("---------------------------------------------------");
			
			System.out.println("1. ホーム画面 ");
			System.out.println("2. 戻る ");
			
			System.out.println("---------------------------------------------------");
			System.out.println("入力お願いします : 1   /   2   ");
			System.out.println(">>");
			byte remote = input.nextByte();
			if(remote == 1 ) {
				try {
					main1.main(args);
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			else if(remote == 2) {
				kanri.main(args);
				
			}
			input.close();
		}
		
}

}

