package com.yedam.java.ch07_06_abstract;

public abstract class Animal {
	//필드
	public String kind;
	
	//메서드
	public void breath() {
		System.out.println("숨을 쉽니다.");
		
	}
	public abstract void sound();

}
