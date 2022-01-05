package com.yedam.java.ch07_homework;

public class Card {
	private static int SerialNumber = 1000;
	private int CardNo;
	
	public Card() {
		SerialNumber++;
		CardNo = SerialNumber;
	}

	public static int getSerialNumber() {
		return SerialNumber;
	}

	public static void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}

	public int getCardNo() {
		return CardNo;
	}

	public void setCardNo(int cardNo) {
		CardNo = cardNo;
	}
	
}
