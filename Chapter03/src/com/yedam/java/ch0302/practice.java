package com.yedam.java.ch0302;

import java.util.Scanner;

public class practice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 번째 수: ");
		String A =scanner.next();
		System.out.println("두 번째 수: ");
		String B = scanner.next();
		double D = Double.parseDouble(B);
		double C = Double.parseDouble(A)/D;
		if(D==0 ||D == 0.0) { 
			System.out.println("결과 : 무한대");
		}
		else {
			System.out.printf("결과 : %.2f",C);
		}
	}

}
