package com.yedam.java.ch02;

public class MainExample {
	
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.set("Hello");
		String str = box1.get();
		System.out.println(str);
		
		Box<Integer> box2 = new Box<Integer>();
		box2.set(6);
		int value = box2.get();
		
		Product<TV, String> product1 = new Product<TV, String>();
		product1.setKind(new TV());
		product1.setModel("스마트TV");
		
		TV tv = product1.getKind();
		String tvModel = product1.getModel();
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("디젤");
		
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
		
		
	}

}
