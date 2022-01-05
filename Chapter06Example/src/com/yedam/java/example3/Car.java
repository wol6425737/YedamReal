package com.yedam.java.example3;

public class Car {
	//필드
	private static int SerialNumber = 1000;
	private int CarNumber;
	
	//생성자
	public Car(){
		SerialNumber++;
		CarNumber = SerialNumber;
	}
	//메서드

	public int getCarNumber() {
		return CarNumber;
	}

	public void setCarNumber(int CarNumber) {
		this.CarNumber = CarNumber;
	}

	public static int getSerialNumber() {
		return SerialNumber;
	}

	public static void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}

	

}
