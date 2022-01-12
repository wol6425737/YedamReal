package com.yedam.java.app.emp13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Emp13DAO {
	//DB 연결 정보
	String jdbc_driver ="org.sqlite.JDBC";
	String jdbc_url = "jdbc:sqlite:/c:/dev/workspace/YedamDataBase.db";
	
	//각 메서드에서 공통적으로 사용하는 필드
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	private static Emp13DAO instance = new Emp13DAO();
	
	private Emp13DAO() {}
	
	public static Emp13DAO getInstance() {
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
	public List<Emp13> SelectAll(){
		List<Emp13> list = new ArrayList<Emp13>();
		try {
			connect();
			String select = "SELECT * FROM emp13 ORDER BY employee_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Emp13 emp = new Emp13();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setDepartmentName(rs.getString("department_name"));
				emp.setLocationId(rs.getString("location_id"));
				list.add(emp);
				
			}
		} catch(SQLException e) 
		{
			e.printStackTrace();}
		finally 
		{
			disconnect();
		}
		return list;
	}
	
	//단건조회
	public Emp13 selectOne(int employeeId) {
		Emp13 emp = null;
		
		try {
			connect();
			String select = "SELECT * FROM emp13 WHERE employee_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				emp = new Emp13();
				emp.setEmployeeId(emp.getEmployeeId());
				emp.setFirstName(emp.getFirstName());
				emp.setJobId(emp.getJobId());
				emp.setSalary(emp.getSalary());
				emp.setCommissionPct(emp.getCommissionPct());
				emp.setDepartmentName(emp.getDepartmentName());
				emp.setLocationId(emp.getLocationId());
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return emp;
	}
	
	//등록
	public void insert(Emp13 emp) {
		try {
			connect();
			String insert = "INSERT INTO emp13 VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getJobId());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setDouble(5, emp.getCommissionPct());
			pstmt.setString(6,emp.getDepartmentName());
			pstmt.setString(7,emp.getLocationId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 등록되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}
	
	//수정(departname을 수정하는 method)
	public void update(Emp13 emp) {
		try {
			connect();
			String update = "UPDATE emp13 SET department_name = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, emp.getDepartmentName());
			pstmt.setInt(2, emp.getEmployeeId());
			
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
	public void delete(int employeeId) {
		try {
			connect();
			String delete = "DELETE FROM emp13 WHERE employee_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, employeeId);
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
