package com.yedam.java.ch02_05;

public class Account {
	//필드
	private String name;
	private long balance;
	
	Account(String name){
		this.name = name;
		
	}
	
	//메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}


	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
	

}
