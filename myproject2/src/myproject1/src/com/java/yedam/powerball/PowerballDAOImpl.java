package myproject1.src.com.java.yedam.powerball;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myproject1.src.com.java.yedam.common.DAO;

public class PowerballDAOImpl extends DAO implements PowerballDAO {
	//싱글톤
	private static PowerballDAO instance = new PowerballDAOImpl();
	private PowerballDAOImpl() {}
	public static PowerballDAO getInstance() {
		return instance;
	}
	

	//파워볼 계정 등록
	@Override
	public void createAccount(PowerballAccount account) {
		try {
			connect();
			String insert = "INSERT INTO account VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, account.getPBAccountOwner());
			pstmt.setString(2, account.getPBAccountOwnerPhone());
			pstmt.setString(3, account.getPBAccountId());
			pstmt.setString(4, account.getPBAccountPassword());
			pstmt.setDouble(5, account.getPBAPoint());
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("회원가입 되었습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}

	}

	//파워볼 계정 전체 불러오기
	@Override
	public List<PowerballAccount> selectAll() {
		List<PowerballAccount> list = new ArrayList<PowerballAccount>();
		try {
			connect();
			String select = "SELECT * FROM account ORDER BY account_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PowerballAccount pba = new PowerballAccount();
				pba.setPBAccountOwner(rs.getString("account_owner"));
				pba.setPBAccountOwnerPhone(rs.getString("account_owner_phone"));
				pba.setPBAccountId(rs.getString("account_id"));
				pba.setPBAccountPassword(rs.getString("account_password"));
				pba.setPBAPoint(rs.getLong("account_point"));
				
				list.add(pba);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return list;
	}
	
	//파워볼 계정 하나 불러오는 메서드
	@Override
	public PowerballAccount selectAccountInfo(String PBAccountId) {
		PowerballAccount pba = null;
		try {
			connect();
			String select = "SELECT * FROM account WHERE account_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, PBAccountId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pba = new PowerballAccount();
				pba.setPBAccountOwner(rs.getString("account_owner"));
				pba.setPBAccountOwnerPhone(rs.getString("account_owner_phone"));
				pba.setPBAccountId(rs.getString("account_id"));
				pba.setPBAccountPassword(rs.getString("account_password"));
				pba.setPBAPoint(rs.getLong("account_point"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return pba;
	}
	
	//파워볼 본인계정 포인트확인
	@Override
	public double selectAccountPoint(String PBAccountId) {
		PowerballAccount pba = null;
		try {
			connect();
			String select = "SELECT * FROM account WHERE account_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, PBAccountId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pba = new PowerballAccount();
				pba.setPBAccountOwner(rs.getString("account_owner"));
				pba.setPBAccountOwnerPhone(rs.getString("account_owner_phone"));
				pba.setPBAccountId(rs.getString("account_id"));
				pba.setPBAccountPassword(rs.getString("account_password"));
				pba.setPBAPoint(rs.getDouble("account_point"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return pba.getPBAPoint();
	}
	
	//파워볼 본인계정 포인트 충전 
	@Override
	public void updateAccountPoint(PowerballAccount account) {
		try {
			connect();
			String update = "UPDATE account SET account_point = account_point+? WHERE account_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setDouble(1, account.getPBAPoint());
			pstmt.setString(2, account.getPBAccountId() );
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println();
				System.out.println("포인트 잔액 업데이트가 정상적으로 처리되었습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			
			disconnect();
		}
		
	}
	

}
