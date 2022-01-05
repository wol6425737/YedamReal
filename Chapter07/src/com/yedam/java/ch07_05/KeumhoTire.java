package com.yedam.java.ch07_05;

public class KeumhoTire extends Tire {

	public KeumhoTire(String location, int maxRotation) {
		super(location, maxRotation);

	}
	@Override
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " KeumhoTire 수명 : " + (maxRotation - accumulatedRotation) + " 회");
			return true;
		}
		else {
			System.out.println("*** " + location + " KeumhoTire 펑크 ***");
			return false;
		}
	}

}
