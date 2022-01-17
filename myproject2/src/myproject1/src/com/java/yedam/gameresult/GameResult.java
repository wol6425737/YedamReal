package myproject1.src.com.java.yedam.gameresult;

public class GameResult {
	private static long SERIALNUM=0;
	private String accountId;
	private int gameNo;
	private long totalgameNo;
	private double bettingAmount;
	private int isWin;
	private double winPrize;
	
	public GameResult(){

	}
	
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
	public long getTotalgameNo() {
		return totalgameNo;
	}
	public void setTotalgameNo(long totalgameNo) {
		this.totalgameNo = totalgameNo;
	}
	public double getBettingAmount() {
		return bettingAmount;
	}
	public void setBettingAmount(double bettingAmount) {
		this.bettingAmount = bettingAmount;
	}
	public int getIsWin() {
		return isWin;
	}
	public void setIsWin(int isWin) {
		this.isWin = isWin;
	}
	public double getWinPrize() {
		return winPrize;
	}
	public void setWinPrize(double winPrize) {
		this.winPrize = winPrize;
	}
	@Override
	public String toString() {
		return "ID : " + accountId + ", 게임번호 : " + gameNo + ", 사이트 총 누적 게임 횟수 : " + totalgameNo
				+ ", 베팅금액 : " + bettingAmount + ", 적중여부 : " + ((isWin==0)?"미적중":"적중") + ", 적중상금 : " + winPrize;
	}
	public static long getSERIALNUM() {
		return SERIALNUM;
	}
	public static void setSERIALNUM(long sERIALNUM) {
		SERIALNUM = sERIALNUM;
	}
	
	
	
	

}
