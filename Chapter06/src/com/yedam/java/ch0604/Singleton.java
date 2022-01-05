package com.yedam.java.ch0604;

public class Singleton {
	//필드
	private static Singleton singleton = new Singleton();
	private int n = 3;
	
	//생성자
	private Singleton() {}
	//메서드
	static Singleton getInstance() {
		return singleton;
	}
	 void println() {
		System.out.println("싱글톤 메소드 println");
	}
	
}
