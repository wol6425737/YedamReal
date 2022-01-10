package com.yedam.java.ch03;

public class BalanceInsufficientException extends Exception//모든 exception class는  Exception class를 상속받는다
{
	public BalanceInsufficientException() {}
	
	public BalanceInsufficientException(String message) {
		super(message);
	}



	

}
