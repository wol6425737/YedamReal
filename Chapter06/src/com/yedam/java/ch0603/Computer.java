package com.yedam.java.ch0603;

public class Computer {
	//더하기 1
	int sum1(int[] values) {
		int sum1 = 0;
//		for(int i=0; i<values.length; i++) {
//			sum1+=values[i];
//		}
		for(int value : values) {
			sum1+=value;
		}
		return sum1;
	}
	//더하기 2
	int sum2(int ... values) {
		int sum2 = 0;
		for(int i=0; i<values.length; i++) {
			sum2+=values[i];
		}
		return sum2;
	}

}
