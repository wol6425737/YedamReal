package com.yedam.java.ch07_homework;

public class Person {
	//필드
	private String name;
	private int money;
	private int info;
	private String cafeName;
	private String cafeMenu;
	
	//생성자
	Person(String name, int money){
		this.name = name;
		this.money = money;
		
	}
	
	//메소드
	public void buyCoffee(StarCafe starCafe) {
		this.money -= 4000;
		starCafe.take(4000);
		info = 1;
		cafeName = starCafe.getName();
		cafeMenu = starCafe.getMenu();
	}
	public void buyCoffee(BeanCafe beanCafe) {
		this.money -= 4500;
		beanCafe.take(4500);
		info = 2;
		cafeName = beanCafe.getName();
		cafeMenu = beanCafe.getMenu();
	} 
	public void showInfo() {
		if(info == 1) {
			System.out.println(name + "씨는 " + cafeName + "에서 4,000원을 내고 " + cafeMenu +"를 사 마셨습니다. 남은 현금은 " + money +"입니다." );
		}
		else if(info == 2) {
			System.out.println(name + "씨는 " + cafeName + "에서 4,500원을 내고 " + cafeMenu +"를 사 마셨습니다. 남은 현금은 " + money +"입니다." );
			
		}
	}

}
