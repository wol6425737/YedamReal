package com.yedam.java.emp13;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class EmpDAOImpl extends DAO implements EmpDAO {
	//싱글톤
	private static EmpDAO instance = new EmpDAOImpl();
	private EmpDAOImpl() {}
	public static EmpDAO getInstance() {
		return instance;
	}
	

	@Override
	public List<Emp> selectAll() {
		List<Emp> list = new ArrayList<Emp>();
		try {
			connect();
			String select = "SELECT * FROM emp13 ORDER BY employee_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommisionPct(rs.getString("commission_pct"));
				emp.setDepartmentName(rs.getString("department_name"));
				emp.setLocationId(rs.getInt("location_id"));
				
				list.add(emp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			disconnect();
		}
		
		return list;
	}

	@Override
	public Emp selectOne(int empId) {
		Emp emp = null;
		try {
			connect();
			String select = "SELECT * FROM emp13 WHERE employee_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, empId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				emp = new Emp();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommisionPct(rs.getString("commission_pct"));
				emp.setDepartmentName(rs.getString("department_name"));
				emp.setLocationId(rs.getInt("location_id"));		
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return emp;
		
		
	}

	@Override
	public void insert(Emp emp) {
		try {
			connect();
			String insert = "INSERT INTO emp13 VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getJobId());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setString(5, emp.getCommisionPct());
			pstmt.setString(6, emp.getDepartmentName());
			pstmt.setInt(7, emp.getLocationId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 등록되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		

	}

	@Override
	public void update(Emp emp) {
		try {
			connect();
			String update = "UPDATE emp13 SET salary = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, emp.getSalary());
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

	@Override
	public void delete(int empId) {
		try {
			connect();
			String delete = "DELETE FROM emp13 WHERE employee_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, empId);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}

	}

}
