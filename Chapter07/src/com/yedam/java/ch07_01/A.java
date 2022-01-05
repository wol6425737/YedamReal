package com.yedam.java.ch07_01;

public class A {
	protected String field;
	
	protected A() {}
	
	protected void method() {
		A a = new A();
		a.field = "value";
		a.method();
		
	}
	

}
