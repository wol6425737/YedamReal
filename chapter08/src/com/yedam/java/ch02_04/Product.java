package com.yedam.java.ch02_04;

public class Product {
	//필드
	private String name;
	private int price;
		
	//생성자
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	//메서드

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
