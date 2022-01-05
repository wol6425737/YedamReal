package com.yedam.java.ch0604;

public class MainExample {
	//필드
	String message;
	
	//메서드
	void println() {
		System.out.println(this.message);
	}
	
	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		myCar.run();
		yourCar.run();
		
		System.out.println();
		
		double result1 = 10 * 10 * Calculator.PI;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		System.out.println("result3 = " + result3);
		
		MainExample main = new MainExample();
		main.message = "정적 메서드 선언 시 주의할 점입니다.";
		main.println();
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 singleton 객체입니다.");
		}
		else {
			System.out.println("다른 singleton 객체입니다.");
		}
		
		Person p1 = new Person("1234567-1234567", "홍길동");
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		//p1.nation = "USA"; //final은 한번 값을 가지면 변경 불가
		//p1.ssn = "654321-7654321"; //final은 한번 값을 가지면 변경 불가
		p1.name = "홍상원";
		
		System.out.println("지구의 반지름 : " + Earth.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적 : " + Earth.EARTH_AREA + "km^2");
		
		
		
	}

	
	

}
