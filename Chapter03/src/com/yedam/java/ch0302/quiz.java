package com.yedam.java.ch0302;

public class quiz {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int result;
		
		//1-1)
		result = -x;
		System.out.println(result);
		//1-2)
		result = x+y++;
		System.out.println(result);
		//1-3)
		result = x+ --y;
		System.out.println(result);
		//1-4)
		result = x/y;
		System.out.println(result);
		result = x%y;
		System.out.println(result);
	}
}
