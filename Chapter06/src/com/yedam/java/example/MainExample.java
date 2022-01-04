package com.yedam.java.example;

import java.util.Scanner;

public class MainExample {
	public static void main(String[] args) {
		//문제1) Calculator 클래스 -> 사칙연산에 대한 메서드 만들기
		Calculator myCalc = new Calculator();
		double x = 10;
		double y = 4;
		double addResult = myCalc.plus(x, y);
		double minusResult = myCalc.minus(x, y);
		double multiplyResult = myCalc.multiply(x, y);
		double divideResult = myCalc.divide(x, y);
		
		System.out.println("addResult = " + addResult);
		System.out.println("minusResult = " + minusResult);
		System.out.println("multiplyResult = " + multiplyResult);
		System.out.println("divideResult = " + divideResult);
		
		System.out.println();
		System.out.println();
		
		
		//문제2) TV 클래스 -> 다음과 같은 형태의 생성자와 메서드를 가진다.
		TV myTV = new TV("LG", 2017, 32);
		myTV.showInfo();//LG에서 만든 2017년형 32인치 TV
		
		System.out.println();
		System.out.println();
		
		//문제3) Grade 클래스 -> 3과목의 점수를 입력받아 성적 평균을 출력한다.
		Scanner scanner = new Scanner(System.in);
		System.out.println("수학, 과학, 영어 순으로 3개의 정수 입력>>");
		int math = scanner.nextInt();
		int science = scanner.nextInt();
		int english = scanner.nextInt();
		Grade myGrade = new Grade(math, science, english);
		//average() 메서드는 평균을 계산하여 리턴
		System.out.println("평균 : " + myGrade.average());
		
		System.out.println();
		System.out.println();
		
		
	}

}
