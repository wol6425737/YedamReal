package com.yedam.java.ch04.string;

import java.io.UnsupportedEncodingException;

public class StringExample {
	public static void main(String[] args) {
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		//charAt()
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7);
		System.out.println(gender);
		
		switch(gender) {
		case '1':
		case '3':
			System.out.println("남자입니다");
			break;
		
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
			
		
		}
		
		//getBytes()
		String str = "안녕하세요";
		byte[] bytesX = str.getBytes(); //안녕하세요를 Byte로 
		System.out.println("bytesX.length : " + bytesX.length);
		
		try {
			byte[] bytesY = str.getBytes("EUC-KR");//Byte bytesY에 안녕하세요를 EUC-KR로 Byte변환
			System.out.println("bytesY.length : " + bytesY.length);
			String strY = new String(bytesY, "EUC-KR");//bytesY를 EUC-KR로 String으로 변환
			System.out.println("bytesY -> strY : " + strY);
			byte[] bytesZ = str.getBytes("UTF-16");
			System.out.println("byteZ.length : " + bytesZ.length);
			String strZ = new String(bytesZ, "UTF-16");
			System.out.println("bytesZ -> strZ : " + strZ);
			
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		//indexOf()
		String subject = "자바 프로그래밍";
		int location = subject.indexOf("프로그래밍"); //자0 바1 " " 2 프3~
		System.out.println(location); 
		
		if(subject.indexOf("JAVA") != -1) { //문자열에 해당 문자열이 없으면 indexOf는 -1을 반환
			System.out.println("JAVA가 포함되어 있습니다.");	
		}
		else {
			System.out.println("JAVA가 포함되어 있지 않습니다.");
		}
		
		System.out.println();
		
		//length()
		
		ssn = "7306241230123";
		int length = ssn.length();
		if(length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}
		else {
			System.out.println("주민번호 자리수가 틀립니다.");
			
		}
		
		System.out.println();
		//replace()
		
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바",  "JAVA");
		System.out.println("oldStr : " + oldStr + "\nnewStr : " + newStr);
		System.out.println(oldStr);
		System.out.println(newStr);
		
		System.out.println();
		//substring()
		ssn = "880815-1234567";
		String firstNum = ssn.substring(0,6);//0부터 5까지(6번째 앞)
		System.out.println(firstNum);
		String secondNum = ssn.substring(7);//7번째부터 끝까지
		System.out.println(secondNum);
		
		System.out.println();
		//toLowerCase(), toUpperCase()
		String strA = "Java Programming";
		String strB = "JAVA Programming";
		
		System.out.println(strA.equals(strB));
		String lowerStr1 = strA.toLowerCase();
		String lowerStr2 = strB.toLowerCase();
		
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(strA.equalsIgnoreCase(strB));
		
		System.out.println();
		//trim() , 문자열 사이의 공백은 못 없앰
		
		String tel1 = "                 02";
		String tel2 = "123           ";
		String tel3 = "      1234         ";
		
		String telA = tel1 + tel2 + tel3;
		System.out.println(telA);
		
		String telB = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(telB);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
