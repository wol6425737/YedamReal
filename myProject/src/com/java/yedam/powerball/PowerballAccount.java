package com.java.yedam.powerball;

public class PowerballAccount {
	private String PBAccountOwner;
	private String PBAccountOwnerPhone;
	private String PBAccountId;
	private String PBAccountPassword;
	private long PBAPoint;
	
	
	
	public String getPBAccountOwner() {
		return PBAccountOwner;
	}
	public void setPBAccountOwner(String pBAccountOwner) {
		PBAccountOwner = pBAccountOwner;
	}
	public String getPBAccountOwnerPhone() {
		return PBAccountOwnerPhone;
	}
	public void setPBAccountOwnerPhone(String pBAccountOwnerPhone) {
		PBAccountOwnerPhone = pBAccountOwnerPhone;
	}
	public String getPBAccountId() {
		return PBAccountId;
	}
	public void setPBAccountId(String pBAccountId) {
		PBAccountId = pBAccountId;
	}
	public String getPBAccountPassword() {
		return PBAccountPassword;
	}
	public void setPBAccountPassword(String pBAccountPassword) {
		PBAccountPassword = pBAccountPassword;
	}
	public long getPBAPoint() {
		return PBAPoint;
	}
	public void setPBAPoint(long pBAPoint) {
		PBAPoint = pBAPoint;
	}
	
	@Override
	public String toString() {
		return "ID : " + PBAccountId + ", 포인트 : " + PBAPoint;
	}
	
	
	
	
	

	
}
