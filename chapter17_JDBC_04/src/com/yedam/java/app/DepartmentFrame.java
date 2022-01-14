package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.deparment.Department;
import com.yedam.java.deparment.DepartmentDAO;
import com.yedam.java.deparment.DepartmentDAOImpl;

public class DepartmentFrame {
	private DepartmentDAO deptDAO = DepartmentDAOImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);
	
	public DepartmentFrame() {
		while(true) {
			//메뉴 출력
			menuPrint();
				
			//메뉴 선택
			int menuNo = menuSelect();
				
			//각 메뉴별 기능실행
			if(menuNo == 1) {
				//등록
				insertDepartment();
			}
			else if(menuNo == 2) {
				//수정
				updateDepartment();
			}
			else if(menuNo == 3) {
				//삭제
				deleteDepartment();
			}
			else if(menuNo == 4) {
				//단건조회
				selectOne();
			}
			else if(menuNo == 5) {
				//전체조회
				selectAll();
			}
			else if(menuNo == 9) {
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
		
		public void insertDepartment() {
			//부서정보 입력
			Department dept = inputDeptInfo();
			//부서정보 등록
			deptDAO.insert(dept);
		}
		
		public void updateDepartment() {
			//부서명 입력
			Department dept = inputDeptName();
			//부서정보 등록
			deptDAO.update(dept);
		}
		
		public void deleteDepartment() {
			//부서번호 입력
			int departmentId = inputDeptId();
			
			//부서정보 삭제
			deptDAO.delete(departmentId);
		}
		
		public void selectOne() {
			//부서번호 입력
			int departmentId = inputDeptId();
			
			//부서정보 조회
			Department dept = deptDAO.selectOne(departmentId);

			//부서정보 출력
			if(dept == null) {
				System.out.println("해당 부서 정보가 존재하지 않습니다.");
				
			}
			else {
				System.out.println(dept);
			}
		}
		
		public void selectAll() {
			List<Department> list = deptDAO.selectAll();
			//전체 부서정보 출력
			for(Department dept : list) {
				System.out.println(dept);
			}
			
		}
		
		public void end() {
			System.out.println("프로그램 종료");
		}
		
		public Department inputDeptInfo() {
			Department dept = new Department();
			
			System.out.print("부서 ID>");
			dept.setDepartmentId(Integer.parseInt(scanner.nextLine()));
			System.out.print("부서명>");
			dept.setDepartmentName(scanner.nextLine());
			System.out.print("매니저 번호>");
			dept.setManagerId(scanner.nextLine());
			System.out.print("지역 번호");
			dept.setLocationId(Integer.parseInt(scanner.nextLine()));
			
			return dept; 
		}
		
		public Department inputDeptName() {
			Department dept = new Department();
			System.out.print("부서번호>");
			dept.setDepartmentId(Integer.parseInt(scanner.nextLine()));
			System.out.print("부서명>");
			dept.setDepartmentName(scanner.nextLine());
			
			return dept; 
		}
		
		public int inputDeptId() {
			int departmentId = 0;
			System.out.print("부서번호>");
			departmentId = Integer.parseInt(scanner.nextLine());
			return departmentId;
		}
			
			

			
}


