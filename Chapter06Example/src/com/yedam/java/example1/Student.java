package com.yedam.java.example1;

public class Student {
	//필드
	private String name;
	private int money;
	//생성자
	Student(String name, int money){
		this.name = name;
		this.money = money;
	}
	//메서드
	void takeBus(Bus bus) {
		this.money -= 1000;
		bus.take(1000);
		
	}
	
	void takeSubway(Subway subway) {
		this.money -= 800;
		subway.takeSubway(800);
	}
	
	void showInfo() {
		System.out.println(name + "님의 남은 돈은 " + money + "입니다.");
	}

}
