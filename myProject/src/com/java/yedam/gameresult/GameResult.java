package com.java.yedam.gameresult;

public class GameResult {
	private String accountId;
	private int gameNo;
	private int totalgameNo;
	private long bettingAmount;
	private int isWin;
	private long winPrize;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getGameNo() {
		return gameNo;
	}
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	public int getTotalgameNo() {
		return totalgameNo;
	}
	public void setTotalgameNo(int totalgameNo) {
		this.totalgameNo = totalgameNo;
	}
	public long getBettingAmount() {
		return bettingAmount;
	}
	public void setBettingAmount(long bettingAmount) {
		this.bettingAmount = bettingAmount;
	}
	public int getIsWin() {
		return isWin;
	}
	public void setIsWin(int isWin) {
		this.isWin = isWin;
	}
	public long getWinPrize() {
		return winPrize;
	}
	public void setWinPrize(long winPrize) {
		this.winPrize = winPrize;
	}
	@Override
	public String toString() {
		return "ID : " + accountId + ", 게임번호 : " + gameNo + ", 사이트 총 누적 게임 횟수 : " + totalgameNo
				+ ", 베팅금액 : " + bettingAmount + ", 적중여부 : " + ((isWin==0)?"미적중":"적중") + ", 적중상금 : " + winPrize;
	}
	
	
	
	

}
