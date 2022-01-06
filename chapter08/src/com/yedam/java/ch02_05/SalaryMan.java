package com.yedam.java.ch02_05;

public class SalaryMan {
	//필드 
	private int salary = 1000000;
	private int annualGross;
	
	public SalaryMan() {
		
	}
	public SalaryMan(int salary) {
		this.salary = salary;
	}
	
	
	public int getAnnualGross() {
		annualGross = salary  * 12 +(salary)*5; 
		return annualGross;
		
	}

}
