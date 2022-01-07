package com.yedam.java.ch07_09_interfaceQuiz2;

public class MyAdder implements AdderInterface {

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int add(int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum += i;
		}
		
		return sum;
	}

}
