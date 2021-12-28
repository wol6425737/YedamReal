package com.yedam.java.ch0401;

public class ConditionalStatementExample {
	public static void main(String[] args) {
		// 기본 IF문;;;
		//dkfjdkfjdkfjsllfksdjaflsadjfkl,
		int score = 93;

		if (score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}

		if (score < 90) {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");

		}
		
		//IF ~ ELSE문
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		else {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		
		//if ~ else if ~ else문
		score = 75;
		if(score >= 90) {
			System.out.println("점수가 100~90점입니다.");
			System.out.println("등급은 A입니다.");
		}
		else if(score >= 80) {
			System.out.println("점수가 89~80점입니다.");
			System.out.println("등급은 B입니다.");
		}
		else if(score >= 70) {
			System.out.println("점수가 79~70점입니다.");
			System.out.println("등급은 C입니다.");
		}
		else {
			System.out.println("점수가 70점 미만입니다.");
			System.out.println("등급은 D입니다.");
		}
		
		// 0.0 <= Math.random() < 1.0
		// 0.0 * 10 <= Math.random() * 10 < 1.0 * 10
		// 0.0 + 1 <= (Math.random() * 10) + 1 < 10.0 + 1
		// 1.0 <= (Math.random() * 10) + 1 < 11.0
		// 1 <= (int)(Math.random() * 10) + 1 < 11
		// 최소 n부터 m까지의 정수 중에서 랜덤하게 값을 구하고 싶을 때 
		// (int)(Math.random()*(m+1-n)) + n 
		
		int num = (int)(Math.random()*6)+1;
		if(num == 1) {
			System.out.println("1번이 나왔습니다.");
		}
		else if(num == 2) {
			System.out.println("2번이 나왔습니다.");
		}
		else if(num == 3) {
			System.out.println("3번이 나왔습니다.");
		}
		else if(num == 4) {
			System.out.println("4번이 나왔습니다.");
		}
		else if(num == 5) {
			System.out.println("5번이 나왔습니다.");
		}
		else if(num == 6) {
			System.out.println("6번이 나왔습니다.");
		}
		
		
		//switch문
		
		num = (int)(Math.random()*6) + 1;
		
		switch(num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		case 6:
			System.out.println("6번이 나왔습니다.");
			break;
			
		}
		
		int time = (int)(Math.random() * 12) + 8;
		System.out.println("[현재시각 : " + time + "시]");
		
		switch(time) {
		case 8:
			System.out.println("출근합니다.");
			break;
		case 9:
			System.out.println("회의를 합니다.");
			break;
		case 10:
			System.out.println("업무를 봅니다.");
			break;
		default :
			System.out.println("외근을 나갑니다.");
			break;
		}
		
		
		
		//char 타입
		char grade = 'B';
		
		switch(grade) {
		case 'A':
		case 'a':
			System.out.println("우수 회원입니다.");
			break;
		
		case 'B':
		case 'b':
			System.out.println("일반 회원입니다.");
			break;
		
		default:
			System.out.println("손님입니다.");
			break;
			
		}
		
		//String 타입
		String position = "과장";
		
		switch(position) {
		case "부장":
			System.out.println("700만원");
			break;
			
		case "과장":
			System.out.println("500만원");
			break;
		
		default:
			System.out.println("300만원");
			break;
			
	
		}
		System.out.println("임포트 해보기");
		
		
		
	}
}
