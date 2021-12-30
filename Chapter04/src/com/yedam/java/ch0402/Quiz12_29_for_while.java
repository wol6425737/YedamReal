package com.yedam.java.ch0402;

import java.util.Scanner;

public class Quiz12_29_for_while {
	public static void main(String[] args) {
		// 문제1) 책 161페이지 5번, for문을 이용해서 다음과 같이 *를 출력하는 코드를 작성해보세요.
		// *
		// **
		// ***
		// ****
		// *****
		
//		for(int i = 1; i<=5;i++) {
//			for(int j = 1; j<=i;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//1번 교수님 풀이
		
//		String tree = "";
//		for(int i=1; i<=5; i++) {
//			tree = tree + "*";
//			System.out.println(tree);
//		}

		// 문제2) 책 160페이지 2번, for문을 이용해서 1부터 100까지의 정수 중에서 2의 배수가 아닌 숫자의 개수를 구하세요.
		//		 단, continue 문을 사용한다.
//		int count = 0;
//		for(int i=1;i<=100;i++) {
//			if(i%2!=0) {
//				count++;
//			}
//		}
//		System.out.println(count);

		
		
		
		
		// 문제3) 책 161페이지 4번, 중첩 for문을 이용하여 방정식 4x+5y = 60의 모든 해 중 첫번째로 구해지는 값을 (x, y) 형태로 출력해보세요.
		//       단, x와 y는 10이하의 자연수입니다.
		
//		Outter : for(int x=1;x<=10;x++) {
//			for(int y=1;y<=10;y++) {
//				if(4*x+5*y == 60) {
//					System.out.printf("(%d, %d)\n",x,y);
//					break Outter;
//				}
//			}
//		}
					
		
		
		
		
		// 문제4) do ~ while문과 Math.random()함수를 이용하여 1 ~ 10의 정수 중 7이라는 수가 나올때까지 숫자를 출력하는 코드를 작성해보세요.
//		int num = 0;
//		do {
//			num = (int)(Math.random()*10)+1;
//			System.out.println(num);
//		}while(num!=7);
		
		
		
		
		// 문제5) 책 161페이지 3번, while문과 Math.random() 함수를 이용해서 2개의 주사위를 던졌을때 나오는 숫자를 (숫자1, 숫자2) 형태로 출력하고,
		//		 숫자의 합이 5가 아니면 계속 주사위를 던지고, 숫자의 합이 5이면 실행을 멈추는 코드를 작성해보세요.
		//		 또한 주사위를 몇번 던졌는지 횟수를 출력하세요.
		//		 숫자의 합이 5가 되는 조합은 (1,4), (4,1), (2,3),(3,2)
//		int x = 0;
//		int y = 0;
//		int count1 = 0;
//		while(true) {
//			x = (int)(Math.random()*6+1);
//			y = (int)(Math.random()*6+1);
//			count1++;
//			if(x+y==5) {
//				System.out.println("("+x+","+y+")");
//				break;
//				
//			}
//
//			
//		}
//		System.out.println("주사위 던진 횟수 " + count1);
		
		
		
		
		
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
