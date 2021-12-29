package com.yedam.java.ch0401;

import java.util.Scanner;

public class example {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 
		 //if 문
		 
		 //예제1 - 점수를 입력받아서 70점 이상이면 합격, 미만이면 불합격
		 
//		 int score = Integer.parseInt(scanner.nextLine());
//		 
//		 if(score>=70) {
//			 System.out.println("합격");
//		 }
//		 else {
//			 System.out.println("불합격");
//		 }
		 
		 //예제2 - 정수 한 개를 입력받아 해당 정수가 2의 배수인지 확인
//		 String number = scanner.nextLine();
//		 int num = Integer.parseInt(number);
//		 if(num%2 == 0) {
//			 System.out.println("2의 배수입니다.");
//		 }
//		 else {
//			 System.out.println("2의 배수가 아닙니다.");
			 
		 
		 //예제3 - 점수는 0~100점 사이 값이어야 하며 벗어날 경우 "점수 입력 오류!" 출력
		 //		  60점 이상이면 합격, 미만이면 불합격
//		 System.out.println("점수를 입력하시오 : ");
//		 int score = Integer.parseInt(scanner.nextLine());
//		 if(score>100 || score<0) {
//			 System.out.println("점수 입력 오류!");
//		 }
//		 else {
//			 if(score>=60) {
//				 System.out.println("합격");
//			 }
//			 else {
//				 System.out.println("불합격");
//			 }
//		 }
		 
		 //예제4 - 놀이기구, 키 110cm 이상일 경우 라바 트위스터를 탑승-
		 //		  미만 보호자가 있는지 체크 -> 있으면 탑승
		 //       						 없으면 "보호자와 같이 오세요." 출력
//		 System.out.println("키를 입력하세요");
//		 double height = Double.parseDouble(scanner.nextLine());
//		 
//		 
//		 
//		 if(height>=110) {
//			 System.out.println("라바 트위스터를 탑승할 수 있습니다.");
//		 }
//		 else {
//			 System.out.println("보호자가 있나요? yes or no입력");
//			 String withParents = scanner.nextLine();
//			 if(!(withParents.equals("yes")||withParents.equals("no")))
//				 System.out.println("정확히 yes 혹은 no를 입력하시오.");
//			 else {
//				 if(withParents.equals("yes")) {
//					 System.out.println("라바 트위스터를 탑승할 수 있습니다.");
//				 }
//				 else if(withParents.equals("no")) {
//					 System.out.println("보호자와 같이 오세요");
//				 }
//				 
//			 } 
//		 }
		 
		 //switch 문
		 //예제1 - 정수를 입력받아 0일 경우 false, 1일 경우 true, 둘 다 아닐 경우 "체크 오류"
		 
//		 System.out.println("정수를 입력하시오.");
//		 int num = Integer.parseInt(scanner.nextLine());
//		 switch(num) {
//		 
//		 case 0:
//			 System.out.println("false");
//			 break;
//		 case 1:
//			 System.out.println("true");
//			 break;
//		 default:
//			 System.out.println("체크 오류");
//			 break;
//			 
//		 }
//		 
		 //예제2 - 정수를 입력받아 홀수인지 짝수인지를 판별
		 //		  default에 해당될 경우 무엇을 출력해야 할 지 생각해보세요.
		 
//		 System.out.println("정수를 입력하시오.");
//		 int num = Integer.parseInt(scanner.nextLine());
//		 int oddEven = num % 2;
//		 switch(oddEven) {
//		 case 0:
//			 System.out.println("짝수");
//			 break;
//		 case 1:
//		 case -1:
//			 System.out.println("홀수");
//			 break;
//		 
//			
//		 }
		
	}

}
