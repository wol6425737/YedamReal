package com.yedam.java.ch05.wrapper;

public class WrapperExample {
	public static void main(String[] args) {
		
		//Boxing
		Integer obj1 = new Integer(1234); //권장 x
		Integer obj2 = new Integer("200");//권장 x
		
		Integer obj3 = Integer.valueOf(100);
		Integer obj4 = Integer.valueOf("1234");
		Integer obj5 = Integer.parseInt("1234");
		

		
		//Unboxing
		int value4 = obj4.intValue();
		
		System.out.println(value4);
		
		//자동
		Integer obj = 100;
		
		int value = obj;
		
		int result1 = obj.intValue() + 100;
		int result = obj + 100;// 참조타입 + 기본타입 int? 자동으로 해줌
		
		
		System.out.println(value);
		
		
	}

}
