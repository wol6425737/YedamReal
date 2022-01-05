package com.yedam.java.example;

public class Grade {
	double math;
	double science;
	double english;
	
	Grade(double a, double b, double c){
		math =a;
		science = b;
		english = c;
	}
	
	double average() {
		double avg;
		avg = (math + science + english)/3;
		return avg;
	}

}
