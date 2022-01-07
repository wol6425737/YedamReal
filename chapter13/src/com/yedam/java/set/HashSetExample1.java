package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}
		set.remove("JDBC");
		set.remove("iBATIS");
		System.out.println();
		
		System.out.println("총 객체 수 : " + set.size());
		for(String element : set) {
			System.out.println(element);
		}
		
		System.out.println();
		System.out.println();
		
		set.clear();
		if(set.isEmpty()) {
			System.out.println("set이 비어 있습니다.");
		}
		
		
	}

}
