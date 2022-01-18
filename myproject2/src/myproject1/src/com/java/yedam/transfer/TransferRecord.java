package myproject1.src.com.java.yedam.transfer;

public class TransferRecord {
	private long transferNo;
	private String accountId;
	private long deposit;
	private long withdraw;
	
	
	public long getTransferNo() {
		return transferNo;
	}
	public void setTransferNo(long transferNo) {
		this.transferNo = transferNo;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}
	public long getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(long withdraw) {
		this.withdraw = withdraw;
	}
	@Override
	public String toString() {
		return "거래번호 : " + transferNo + ", 회원ID : " + accountId + ", 입금 : " + deposit + ", 출금 : " + withdraw;
	}
	
	
	
	

}
