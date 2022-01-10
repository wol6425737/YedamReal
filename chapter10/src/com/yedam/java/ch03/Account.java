package com.yedam.java.ch03;

public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance +=money;
		
	}
	
	public void withDraw(int money) throws BalanceInsufficientException //throw 쓸려면 throws로 예외 클래스 받아야 함
	{
		if(balance < money) {
			throw new BalanceInsufficientException("잔고부족 : " + (money - balance) + " 모자랍니다.");//throws 말고 throw : 예외를 강제로 발생시킴
		
			
		}
		balance -=money;
	}

}
