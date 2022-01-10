package com.yedam.java.ch01.object;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Example {
	public static void main(String[] args) {
		//메서드 재정의 전
		
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		Member m3 = new Member("red");
		
		if(m1.equals(m2)) {
			System.out.println("동일한 인스턴스입니다.");
			
		}else {
			System.out.println("다른 인스턴스입니다.");
			
		}
		
		if(m1.equals(m3)) {
			System.out.println("동일한 인스턴스입니다");
			
		}
		else {
			System.out.println("다른 인스턴스입니다.");
			
		}
		
		System.out.println();
		
		Map<Member, Integer> map = new HashMap<Member, Integer>();
		map.put(new Member("홍길동"), 100);
		
		Integer score = map.get(new Member("홍길동"));
		System.out.println(score);
		
		System.out.println();
		
		Object obj = new Object();
		System.out.println(obj.toString());
		
		Date date = new Date();
		System.out.println(date);
		
		Member member = new Member("신용권");
		System.out.println(member);
		
	}

}
