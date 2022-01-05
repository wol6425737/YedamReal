package com.yedam.java.ch07_02;

import com.java.yedam.ch07_01.A;

public class C {
	protected String field;
	
	protected A() {}
	
	protected void method() {
		A a = new A();
		a.field = "value";
		a.method();
		
	}

}
