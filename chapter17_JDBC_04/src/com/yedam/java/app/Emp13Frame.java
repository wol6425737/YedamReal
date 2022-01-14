package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.emp13.Emp;
import com.yedam.java.emp13.EmpDAO;
import com.yedam.java.emp13.EmpDAOImpl;

public class Emp13Frame {
	private EmpDAO empDAO = EmpDAOImpl.getInstance();
	Scanner scanner = new Scanner(System.in);
	
	public Emp13Frame(){
		while(true) {
			//메뉴 출력
			menuPrint();
			
			//메뉴 선택
			int menuNo = menuSelect();
			
			//각 메뉴별 기능실행
			if(menuNo == 1) {
				insertEmp13();
			}
			else if(menuNo == 2) {
				updateEmp13();
				
			}else if(menuNo == 3) {
				deleteEmp13();
				
			}else if(menuNo == 4) {
				selectOne();
				
			}else if(menuNo == 5) {
				selectAll();
				
			}else if(menuNo == 9) {
				end();
				break;
			}
			
		}

	}
	public void menuPrint() {
		System.out.println();
		System.out.println("=== 1.등록 2.수정 3.삭제 4.단건조회 5.전체조회 9.종료 ===");
		System.out.println("선택>");
	}
	
	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.nextLine());
			
		}catch(Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}
	
	public void insertEmp13() {
		//사원 정보 입력
		Emp emp = inputEmpInfo();
		
		//사원 정보 등록
		empDAO.insert(emp);
	}
	
	public void updateEmp13() {
		//사원 급여 입력
		Emp emp = inputEmpSalary();
		
		//사원 급여 수정
		empDAO.update(emp);
		
	}
	
	public void deleteEmp13() {
		//사원 번호 입력
		int employeeId = inputEmpId();
		
		//사원 정보 삭제
		empDAO.delete(employeeId);
		
	}
	
	public void selectOne() {
		//사원 번호 입력
		int employeeId = inputEmpId();
		
		//사원정보 조회
		Emp emp = empDAO.selectOne(employeeId);
		
		//사원 정보 출력
		if(emp == null) {
			System.out.println("해당 사원 ID가 없습니다.");
			
		}
		else {
			System.out.println(emp);
		}
	}
	
	public void selectAll() {
		//전체 사원 출력
		List<Emp> list = empDAO.selectAll();
		for(Emp emp : list) {
			System.out.println(emp);
		}
		
	}
	public void end() {
		System.out.println("프로그램 종료");
	}
	
	public Emp inputEmpInfo() {
		Emp emp = new Emp();
		System.out.print("사원번호>");
		emp.setEmployeeId(Integer.parseInt(scanner.nextLine()));
		System.out.print("성(이름)>");
		emp.setFirstName(scanner.nextLine());
		System.out.print("직종>");
		emp.setJobId(scanner.nextLine());
		System.out.print("급여>");
		emp.setSalary(Integer.parseInt(scanner.nextLine()));
		System.out.print("상여>");
		emp.setCommisionPct(scanner.nextLine());
		System.out.print("부서>");
		emp.setDepartmentName(scanner.nextLine());
		System.out.print("지역번호>");
		emp.setLocationId(Integer.parseInt(scanner.nextLine()));
		
		return emp; 
	}
	
	public Emp inputEmpSalary() {
		Emp emp = new Emp();
		System.out.print("사원번호>");
		emp.setEmployeeId(Integer.parseInt(scanner.nextLine()));
		
		System.out.print("변경된 급여>");
		emp.setSalary(Integer.parseInt(scanner.nextLine()));
		
		return emp;
	}
	
	public int inputEmpId() {
		int employeeId = 0;
		System.out.print("사원번호>");
		employeeId = Integer.parseInt(scanner.nextLine());
		return employeeId;
	}
	
	
	
	

}
