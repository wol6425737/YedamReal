package com.yedam.java.app.department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
	//Sqlite(DB) 연결정보
	
	String jdbc_driver ="org.sqlite.JDBC";
	String jdbc_url = "jdbc:sqlite:/c:/dev/workspace/YedamDataBase.db";
	
	//각 메서드에서 공통적으로 사용하는 필드
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	private static DepartmentDAO instance = new DepartmentDAO();
	
	private DepartmentDAO() {}
	
	public static DepartmentDAO getInstance() {
		return instance;
	}
	
	//JDBC Driver 로딩
	//DB 서버 접속
	// -> Connect() 메서드
	
	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");

		} catch (SQLException e) {
			System.out.println("DB 접속 실패");

		}
		
		
	}
	//PreparedStatement 객체 생성
	//SQL 실행
	//결과값 출력 or 연산
	// -> 각 CRUD 메서드로 반복적으로 사용
	
	//전체조회
	public List<Department> SelectAll(){
		List<Department> list = new ArrayList<Department>();
		try {
			connect();
			String select = "SELECT * FROM departments ORDER BY department_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Department dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getString("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				list.add(dept);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	//단건조회
	public Department selectOne(int departmentId) {
		Department dept = null;
		try {
			connect();
			String select = "SELECT * FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, departmentId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getString("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
			
		}
		return dept;
		
	}
	
	
	//등록
	public void insert(Department dept) {
		try {
			connect();
			String insert = "INSERT INTO departments VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setString(3, dept.getManagerId());
			pstmt.setInt(4, dept.getLocationId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 등록되었습니다.");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	//수정(departname을 수정하는 method)
	public void update(Department dept) {
		try {
			connect();
			String update = "UPDATE departments SET department_name = ? WHERE department_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setInt(2, dept.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다.");
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
	//삭제
	
	public void delete(int departmentId) {
		try {
			connect();
			String delete = "DELETE FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, departmentId);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	

	
	
	
	
	//자원해제 -> disconnect() 메서드
	public void disconnect() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch(SQLException e) {
			System.out.println("정상적으로 자원이 해제되지 않았습니다.");
		}
	}
	
	
	

}
