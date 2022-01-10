package com.yedam.java.test03;

public class CardPayment implements Payment {
	//필드
	private double cardRatio;
	
	//생성자
	CardPayment(double cardRatio){
		this.cardRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		// TODO Auto-generated method stub
		return (int)(price * (1- (cardRatio + ONLINE_PAYMENT_RATIO)));
	}

	@Override
	public int offline(int price) {
		// TODO Auto-generated method stub
		return (int)(price * (1- (cardRatio + OFFLINE_PAYMENT_RATIO)));
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결제시 총 할인율 : " + (cardRatio + ONLINE_PAYMENT_RATIO));
		System.out.println("오프라인 결제시 총 할인율 : " + (cardRatio + OFFLINE_PAYMENT_RATIO));

		

	}

}
