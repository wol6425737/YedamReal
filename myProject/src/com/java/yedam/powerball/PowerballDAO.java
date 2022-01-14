package com.java.yedam.powerball;

import java.util.List;

public interface PowerballDAO {
	
	//파워볼 계정 등록
	public void createAccount(PowerballAccount account);
	
	//파워볼 계정 전체 불러오기
	public List<PowerballAccount> selectAll();
	
	//파워볼 계정 하나 불러오기
	public PowerballAccount selectAccountInfo(String PBAccountId);
	
	//파워볼 본인계정 포인트확인
	public long selectAccountInfo();
	
	
	
	
	
	

}
