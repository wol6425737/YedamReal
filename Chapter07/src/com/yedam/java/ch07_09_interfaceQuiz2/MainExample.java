package com.yedam.java.ch07_09_interfaceQuiz2;

public class MainExample {
	public static void main(String[] args) {
		/*
		 문제2) 인터페이스 AdderInterface의 코드는 다음과 같다. 
		 	   AdderInterface를 상속받은 클래스 MyAdder를 작성하여, 다음 main() 을 실행할 때 아래 실행 결과와 같이 출력되도록 하라.
		 	   - interface AdderInterface {
					int add(int x, int y);
					int add(int n);
				}
				
				- 실행코드
				public static void main(String[] args) {
					MyAdder adder = new MyAdder();
					System.out.println(adder.add(5,10));
					System.out.println(adder.add(10));
				}
				
				- 실행결과 
					15
					55

	*/
		MyAdder adder = new MyAdder();
		System.out.println(adder.add(5,10));
		System.out.println(adder.add(10));
	}

}
