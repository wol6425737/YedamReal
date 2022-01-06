package com.yedam.java.ch04;



public class Adder extends Calculator {
	//필드
	int result;

	
	//메소드

	
	@Override
	protected int calc() {
		result = a+b;
		return result;
	}

}
