package com.yedam.java.ch07_04;

public class MainExample {
	public static void main(String[] args) {
		//=== 자동 타입 변환
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
	}

}
