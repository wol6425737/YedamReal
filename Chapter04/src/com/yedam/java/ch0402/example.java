package com.yedam.java.ch0402;

import java.util.Scanner;

public class example {
	public static void main(String[] args) {
		//for문
		
		//예제1 - 0부터 90까지 10단위로 출력
		for(int i=0;i<=90;i+=10) {
			System.out.println(i);
		}
		
		//예제2 - 0부터 20까지 짝수만 출력
		for(int i=0;i<=20;i+=1) {
			if(i%2!=0) {
				continue;
			}
			System.out.println(i);
		}
		//예제3 - 숫자를 5번 입력하고, 입력 받을 때마다 더해지는 값을 출력
		/* 출력예시:
		 * 숫자 5개를 입력하세요.
		 * 숫자를 입력하세요
		 * 5
		 * 출력 : 5
		 * 숫자를 입력하세요
		 * 6
		 * 출력 : 11
		 */
//		System.out.println("숫자 5개를 입력하세요.");
//		int sum = 0;
//		for(int i=0;i<5;i++) {
//			System.out.println("숫자를 입력하세요");
//			Scanner scan = new Scanner(System.in);
//			int x = Integer.parseInt(scan.nextLine());
//			sum+=x;
//			System.out.println("출력 : " + sum);	
//		}
		
		//예제4 - 1부터 사용자가 입력한 숫자까지 합계
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1부터 n까지의 숫자 합계 구하기, n을 입력하시오");
		int max = Integer.parseInt(scan.nextLine());
		int sum1=0;
		for(int n=1;n<=max;n++) {
			sum1 += n;
			
		}
		System.out.printf("출력 : 1 ~ %d의 합 = %d",max,sum1);
		
		
	}

}
