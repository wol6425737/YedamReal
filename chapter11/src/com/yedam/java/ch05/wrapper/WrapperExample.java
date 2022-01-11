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
		
		//포장객체비교
		
		System.out.println("[-128 ~ 127를 초과한 경우]");
		Integer obj6 = 300;
		Integer obj7 = 300;
		System.out.println("==결과 : " + (obj6 == obj7));//false
		System.out.println("언박싱 후 결과 : " + (obj6.intValue() == obj7.intValue()));
		System.out.println("equals() 결과 : " + obj6.equals(obj7));
		
		System.out.println("[-128 ~ 127 범위 값인 경우]");
		Integer obj8 = 100;
		Integer obj9 = 100;
		System.out.println("==결과 : " + (obj8 == obj9)); //true
		System.out.println("언박싱 후 결과 : " + (obj8.intValue() == obj9.intValue()));
		System.out.println("equals() 결과 : " + obj8.equals(obj9));
		
		
		
		
		
		
	}

}
