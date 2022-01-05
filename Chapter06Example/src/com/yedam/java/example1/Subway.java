package com.yedam.java.example1;

public class Subway {
	//필드
	private String hosun;
	private int money;
	private int passengerCount;
	
	//생성자
	Subway(String hosun){
		this.hosun = hosun;
	}


	void takeSubway(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	void showInfo() {
		System.out.println("지하철 " + hosun + "의 승객은 " + passengerCount + "명이고, 수입은 " + money + "입니다.");
	}

}
