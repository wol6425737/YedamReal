package com.yedam.java.example;

import java.util.Scanner;

public class Example2 {
	public static void main(String[] args) {
		//161p 문제 7
		//1. 출금을 할 때 잔액보다 많을 경우 안내 문구 잔액부족
		//2. 입금, 출금, 잔액조회 -> 비밀번호로 정보확인
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		int number;
		int password = 1234;
		int inputPassword;
		int count = 0;
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("  1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------------");
			System.out.println("선택> ");
			number = Integer.parseInt(scanner.nextLine());
			
			if(number == 4) {
				run = false;
				continue;
			}
		
			
			switch(number) {
			case 1:
				while(true) {
					System.out.printf("비밀번호 4자리를 입력하세요 : ");
					System.out.printf("비밀번호 5회 오입력 시 프로그램 종료(오입력 횟수 : %d)",count);
					inputPassword = Integer.parseInt(scanner.nextLine());
					
					if(inputPassword == password) {
						System.out.println("예금액>");
						balance += Integer.parseInt(scanner.nextLine());
						break;
					}
					else {
						count++;
						if(count == 5) {
							System.out.println();
							System.out.println("\n비밀번호를 5회 오입력 하셨습니다. 프로그램 종료 됩니다.");
							run = false;
							break;

						}
					}
				}
				break;

				

			
			case 2:
				while(true) {
					System.out.printf("비밀번호 4자리를 입력하세요 : ");
					System.out.printf("비밀번호 5회 오입력 시 프로그램 종료(오입력 횟수 : %d)",count);
					inputPassword = Integer.parseInt(scanner.nextLine());
					
					if(inputPassword == password) {
						System.out.printf("현재 잔액 : %d",balance);
						System.out.println("\n출금액>");
						int withdrawl = Integer.parseInt(scanner.nextLine());
						balance -= withdrawl;
						if(balance < 0) {
							System.out.println("출금액이 잔액보다 많습니다. 출금 불가");
							balance += withdrawl;
						}
						break;
					}
					else {
						count++;
						if(count == 5) {
							System.out.println();
							System.out.println("비밀번호를 5회 오입력 하셨습니다. 프로그램 종료 됩니다.");
							run = false;
							break;

						}
					}
				}
				break;
			
			case 3:
				while(count <5) {
					System.out.printf("비밀번호 4자리를 입력하세요 : ");
					System.out.printf("비밀번호 5회 오입력 시 프로그램 종료(오입력 횟수 : %d)",count);
					inputPassword = Integer.parseInt(scanner.nextLine());
					
					if(inputPassword == password) {
						System.out.println("잔액액>");
						System.out.println("잔액 : " + balance);
						break;
					}
					else {
						count++;
						if(count == 5) {
							System.out.println();
							System.out.println("비밀번호를 5회 오입력 하셨습니다. 프로그램 종료 됩니다.");
							run = false;
							break;
						}
					}
				}
				
			break;
			

			default :
				System.out.println("잘못 입력 했습니다.");
				}
			
		}
		System.out.println();
		System.out.println();
		System.out.println("프로그램 종료");
	}

}
