package com.java.yedam.package2;

import com.yedam.java.package1.A;
import com.yedam.java.package1.B;

public class C {
	A a; // 
	B b; // public 클래스라서 다른 패키지에서 B클래스 import 가능
	
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	public C(){
		A a = new A();
		a.field1 = 1;
		a.field2 = 1;
		a.field3 = 1;
		
		a.method1();
		a.method2();
		a.method3();
		
	}

}
