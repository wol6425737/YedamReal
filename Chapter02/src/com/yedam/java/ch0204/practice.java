package com.yedam.java.ch0204;

import java.util.Scanner;

public class practice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[필수 정보 입력]");
		System.out.println("1. 이름 : ");
		String name = scanner.nextLine();
		System.out.println("2. 주민번호 앞 6자리: ");
		
		String number = scanner.nextLine();
		
		System.out.println("3. 전화번호: ");
		String phonenum = scanner.nextLine();
		
		
		System.out.println("[입력한 내용]");
		System.out.printf("%s\n%s\n%s",name,number,phonenum);
	
		
		/*long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		
		int result = (int)(var1 + (int)var2 + var3 + Double.parseDouble(var4));
		System.out.println(result);*/
	}

}
