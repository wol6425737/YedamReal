package com.yedam.java.example;

import java.util.Scanner;

public class homework {
	public static void main(String[] args) {
		//주어진 배열을 이용하여 다음 내용을 구현하세요.
//		int[] arr1 = { 10, 20, 30, 50, 3, 60, -3 };
//		
//		//문제1. 주어진 배열 중에서 값이 60인 곳의 인덱스를 출력해보자.
//		System.out.println("문제 1");
//		for(int i=0;i<arr1.length;i++) {
//			if(arr1[i] == 60) {
//				System.out.println(i);
//			}
//		}
//		System.out.println();
//		System.out.println();
//		
//		//문제2. 주어진 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력해보자.
//		System.out.println("문제2");
//
//		for(int i=0;i<arr1.length;i++) {
//			if(i != 3) {
//				System.out.printf("arr1[%d] =  " + arr1[i] + "\n", i);
//			}
//
//
//		}
//		System.out.println();
//		System.out.println();
//		
//		//문제3. 주어진 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 그 값을 1000으로 변경해보자.
//  		//   입력) 인덱스: 3 ->   {10, 20, 30, 1000, 3, 60, -3}
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("문제 3");
//		int j;
//		System.out.println("1000으로 바꾸고 싶은 배열 인덱스 번호 입력 : ");
//		j = Integer.parseInt(scanner.nextLine());
//		System.out.print("{");
//		for(int i=0; i<arr1.length;i++) {
//			if(j == i) {
//				arr1[j] = 1000;
//			}
//			System.out.print(arr1[i] + ", ");
//
//		}System.out.print("\b\b}");
//		
//		System.out.println();
//		System.out.println();
//		
//		//문제4. 주어진 배열의 요소에서 최대값과 최소값을 구해보자.
//		System.out.println("문제 4");
//		int temp;
//		for(int x = 0; x<arr1.length;x++) {
//			for(int i = 0; i<arr1.length-1-x;i++) {
//				if(arr1[i] > arr1[i+1]) {
//					temp = arr1[i];
//					arr1[i] = arr1[i+1];
//					arr1[i+1] = temp;
//					
//				}
//			}
//		}
//
//		System.out.printf("최대값 : %d,  최소값 : %d",arr1[6], arr1[0]);
//		System.out.println();
//		System.out.println();
//		
//		//문제5. 별도의 배열을 선언하여 양의 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력해보자.
//		System.out.println("문제 5");
//		int[] arr2 = new int[10];
//		for(int i = 0; i<arr2.length;i++) {
//			System.out.println("arr2[" + i + "] 를 입력하세요");
//			arr2[i] = scanner.nextInt();
//		}
//		for(int i = 0; i<arr2.length;i++) {
//			if(arr2[i]%3 == 0) {
//				System.out.println("3의 배수는  " + arr2[i] );
//			}
//		}
//		System.out.println();
//		System.out.println();
		
		
		//추가문제)
		// 문제1) 다음은 키보드로부터 학생수와 각 학생들의 점수를 입력받아서, 최고 점수 및 평균 점수를 구하는 프로그램입니다.
		//		 실행결과를 보고, 알맞게 작성해보세요.
		//		 문제출처, 이것이 자바다 183페이지 9번
		System.out.println("추가 문제1");
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int number;
		int[] scores = null;
		int studentNum;
		

		
		
		
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
			System.out.println("-------------------------------------------------");
			System.out.println("선택> ");
			number = Integer.parseInt(scanner.nextLine());
			if(number == 5) {
				run = false;
			}
			
			
			

			
			switch(number) {
			case 1:
				System.out.println("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
				break;
				
			case 2:
				
				for(int i = 0; i< scores.length;i++) {
					System.out.println("scores[" + i + "]>");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
				break;
			case 3:
				for(int i = 0; i<scores.length;i++) {
					System.out.println("scores["+i+"]: "+scores[i]);
				}
				break;
			case 4:
				int max = scores[0];
				int sum = 0;
				for(int i = 0; i<scores.length;i++) {
					if(max<scores[i]) {
						max = scores[i];
					}
					sum += scores[i];
				}

				double avg = (double)sum/scores.length;
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg);
				
				break;
			}
		}
		System.out.println("프로그램 종료");

		
		
		
	}

}
