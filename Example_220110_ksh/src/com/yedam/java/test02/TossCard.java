package com.yedam.java.test02;

public class TossCard extends Card{
	//필드
	String company = "Toss";
	String cardStaff;

	//생성자
	
	TossCard(String cardNo, int validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
		
	}
	//메소드
	@Override
	public void showCardInfo() {
		super.showCardInfo();
		System.out.println("담당직원 - "+ cardStaff + ", "+company);
	}

}
