package com.yedam.java.ch0202;

public class VariableExample {
	public static void main(String[] args) {
		//정수 리터럴
		int var1 = 0b1011; //2진수
		int var2 = 0206; //8진수
		int var3 = 0xB3; // 16진수
		int var4 = 365; //10진수
		
		System.out.println("var1: " + var1);
		System.out.println("var2: " + var2);
		System.out.println("var3: " + var3);
		System.out.println("var4: " + var4);
		
		//byte 타입
		byte v1 = -128;
		byte v2 = -30;
		byte v3 = 0;
		byte v4 = 30;
		byte v5 = 127;
		//byte v6 = 128;
		
		//long 타입
		
		long var10 = 20;
		long var11 = 100000000000000000L;
		
		//char 타입
		
		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041';
		char c4 = '가';
		char c5 = 44032;
		char c6 = '\uac00';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		
		//String 타입
		String name = "홍길동";
		String job = "프로그래머";
		
		System.out.println("번호\t이름\t직업");
		System.out.println("우리는 \"개발자\"입니다.");
		System.out.println("봄\\여름\\가을\\겨울");
		
		//실수 타입
		float f1 = 3.14F;
		double d1 = 3.14;
		float varF = 0.1234567890123456789F;
		double varD =  0.1234567890123456789;
		
		System.out.println("f1 : " + f1);
		System.out.println("d1 : " + d1);
		System.out.println("varF : " + varF);
		System.out.println("varD : " + varD);
		
		//논리타입
		boolean stop = true;
		if(stop) {
			System.out.println("중지합니다.");
		}else {
			System.out.println("시작합니다.");
		}
		
		int a = 10, b = 50, c = 90;
		int temp = a;

		a = b;
		b = c;
		c = temp;
		
		
		System.out.println("a = " + a +", b = "+ b+ ", c = "+c);
		
		
		
	}

}
