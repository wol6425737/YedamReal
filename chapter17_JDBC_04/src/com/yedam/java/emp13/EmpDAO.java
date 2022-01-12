package com.yedam.java.emp13;

import java.util.List;

public interface EmpDAO {
	//전체조회
	public List<Emp> selectAll();
	
	//단건조회
	public Emp selectOne(int empId);
	
	//등록
	public void insert(Emp emp);
	
	//수정
	public void update(Emp emp);
	
	//삭제
	public void delete(int empId);

}
