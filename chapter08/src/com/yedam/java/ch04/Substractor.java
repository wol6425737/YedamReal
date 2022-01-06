package com.yedam.java.ch04;



public class Substractor extends Calculator {
	int result;



	
	@Override
	protected int calc() {
		result = a - b;
		return result;
	}

}
