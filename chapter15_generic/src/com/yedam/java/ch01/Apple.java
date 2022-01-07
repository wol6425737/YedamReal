package com.yedam.java.ch01;

public class Apple {
	public static void main(String[] args) {
		Box box = new Box();
		box.set("홍길동");
		String name = (String)box.get();
		System.out.println(name);
		box.set(new Apple());
		Apple apple = (Apple)box.get();
		//Object object = new Object();
		
	}

}
