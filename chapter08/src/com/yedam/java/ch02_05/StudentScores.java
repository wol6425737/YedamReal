package com.yedam.java.ch02_05;

public class StudentScores {
	private String name;
	private int classNum;
	private int korean;
	private int english;
	private int math;
	
	private double avg;
	private int total;

	
	StudentScores(String name, int classNum){
		this.name = name;
		this.classNum = classNum;
		
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
	public int getTotal() {

		return korean + english + math;
	}
	public double getAverage() {
		avg = getTotal()/3.0;
		return avg;
	}
	
	

}
