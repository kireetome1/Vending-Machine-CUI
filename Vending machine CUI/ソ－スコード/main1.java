package vending;

import java.util.Scanner;

public class main1 {
	
	public static void main(String[] args) {
		
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("自動販売機へようこそ");
		System.out.println("------------------------------------------------------------------");
		System.out.println("1. 管理者モ－ド");
		System.out.println("2. 販売モ－ド");
		System.out.println("3. 終了");
		System.out.println("------------------------------------------------------------------");
		System.out.println(">>");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Byte main = sc.nextByte();
		System.out.println(main);
		if(main ==1) {
			logindata.main(args);
				
			
		}
		else if (main == 2) {
			itemupdate.main(args);
			
		}
		else if (main == 3) {
			System.exit(0);
		}
		
	}

}
