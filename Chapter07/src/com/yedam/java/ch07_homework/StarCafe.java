package com.yedam.java.ch07_homework;



public class StarCafe {
	private String name;
	private int money;
	private String menu = "아메리카노";
	private int customerCount;

	

	public StarCafe(String name){
		this.name = name;
	}
	
	public void ShowInfo() {
		System.out.println(name + "의 누적 고객 수는 " + customerCount + "명입니다.");
		System.out.println("수익은 " + money + "입니다.");
	}
	
	public void take(int money) {
		this.money += money;
		this.customerCount ++;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getMenu() {
		return menu;
	}
	

	

	

}
