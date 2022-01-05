package com.yedam.java.ch07_05;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=0; i<10; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			case 1:
				System.out.println("앞 왼쪽 HankookTire로 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽",15);
				break;
			case 2:
				System.out.println("앞오른쪽 KeumhoTire로 교체");
				car.frontRightTire = new KeumhoTire("앞오른쪽" ,15);
				break;
			case 3:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new HankookTire("뒤왼쪽" , 14);
				break;
			case 4:
				System.out.println("뒤오른쪽 KeumhoTire로 교체");
				car.backRightTire = new KeumhoTire("뒤오른쪽", 17);
				break;
				
			}
			System.out.println();
		}
		
	}

}
