package com.yedam.java.ch03;

public class NamedCircle extends Circle {
	//필드
	private String name;
	
	//생성자
	
	public NamedCircle(int radius, String name) {
		super(radius);
		this.name = name;
	}
	//메서드

	public String getName() {
		return name;
	}
	


	
	public void show() {
		System.out.println(getName()+", 반지름 : " + getRadius() );
	}

}
