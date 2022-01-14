package com.java.yedam.gameresult;

import java.util.List;

public interface GameResultDAO {
	
	//게임결과 전체조회
	public List<GameResult> selectAllGameResult();
	
	//단건조회 (아이디검색)
	public GameResult selectOneResult(String accountId); 
	
	//게임결과 등록
	public void insertGameResult(GameResult gr);
	
	

}
