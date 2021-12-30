package com.yedam.java.example;

import java.util.Scanner;

public class Example3 {
	public static void main(String[] args) {
		//1부터 10사이의 임의의 숫자를 발생시킵니다.
		//총 3번의 기회가 있고
		//기회 내에 미성공 시 프로그램 종료
		
		int number = (int)(Math.random()*10+1);
		
		System.out.println("숫자를 맞춰보세요 기회는 3번!");
		Scanner scanner = new Scanner(System.in);
		
//		for(int i=1;i<=3;i++) {
//			int myNum = scanner.nextInt();
//				if(myNum == number) {
//					System.out.println("정답입니다~!!");
//					System.out.printf("시도 횟수 : %d",i);
//					break;
//				}
//				else{
//					System.out.println("틀렸어요! 다시 시도해 주세요");
//					System.out.printf("시도 횟수 : %d\n",i);
//					if(myNum>number) {
//						System.out.println("정답보다 입력한 숫자가 큽니다.");
//					}
//					else {
//						System.out.println("정답보다 입력한 숫자가 작습니다.");
//					}
//				
//				}
//		}
		
		int count = 0;
		
		while(true) {
			int myNum = scanner.nextInt();
			count++;
			if(myNum == number) {
				System.out.println("정답입니다.");
				System.out.printf("시도 횟수 : %d\n",count);
				break;
			}
			else{
				System.out.println("틀렸어요! 다시 시도해 주세요");
				System.out.printf("시도 횟수 : %d\n",count);
				if(myNum>number) {
					System.out.println("정답보다 입력한 숫자가 큽니다.");
				}
				else {
					System.out.println("정답보다 입력한 숫자가 작습니다.");
				}
			}
			if(count == 3) {
				System.out.println();
				System.out.println(" 3번의 기회 모두 틀렸습니다. ");
				break;
			}
		}


			
	}

}
