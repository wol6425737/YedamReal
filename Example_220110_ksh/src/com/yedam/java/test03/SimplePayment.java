package com.yedam.java.test03;

public class SimplePayment implements Payment {
	//필드
	private double simplePaymentRatio;
	
	SimplePayment(double simplePaymentRatio){
		this.simplePaymentRatio = simplePaymentRatio;
	}

	@Override
	public int online(int price) {
		// TODO Auto-generated method stub
		return (int)(price * (1- (simplePaymentRatio + ONLINE_PAYMENT_RATIO)));
	}

	@Override
	public int offline(int price) {
		// TODO Auto-generated method stub
		return (int)(price * (1- (simplePaymentRatio + OFFLINE_PAYMENT_RATIO)));
	}

	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보");
		System.out.println("온라인 결제시 총 할인율 : " + (simplePaymentRatio + ONLINE_PAYMENT_RATIO));
		System.out.println("오프라인 결제시 총 할인율 : " + (simplePaymentRatio + OFFLINE_PAYMENT_RATIO));

	}

}
