package com.yedam.java.APP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. JDBC Driver 로딩
		Class.forName("org.sqlite.JDBC");
		
		//2. DB 서버 접속 Connection 생성
		String url = "jdbc:sqlite:/c:/dev/workspace/YedamDataBase.db";
		Connection conn = DriverManager.getConnection(url);
		
		//3.Statement or PreparedStatement 객체 생성
		Statement stmt = conn.createStatement();
		
		//4. SQL 실행
		String select = "SELECT * FROM employees";
		stmt.executeQuery(select); //SELECT문일 경우 executeQuery method
		ResultSet rs = stmt.executeQuery(select); //결과물 보여주는 class
		
		
		//5. 결과값 출력 or 연산
		//next() method는 커서의 기능 마지막에 더 움직일 데가 없을 때 false 반환
		//getString("찾고자 하는 해당 칼럼") method
		while(rs.next()) {
			String name = "이름 : " + rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
			
		}
		
		//6. 자원해제하기
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
		
		
	}

}
