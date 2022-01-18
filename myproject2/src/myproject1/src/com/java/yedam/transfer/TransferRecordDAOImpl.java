package myproject1.src.com.java.yedam.transfer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myproject1.src.com.java.yedam.common.DAO;

public class TransferRecordDAOImpl extends DAO implements TransferRecordDAO {

	// 싱글톤
	private static TransferRecordDAO instance = new TransferRecordDAOImpl();

	private TransferRecordDAOImpl() {
	}

	public static TransferRecordDAO getInstance() {
		return instance;
	}

	//거래기록 등록
	@Override
	public void insertTransferRecord(TransferRecord tr) {
		try {
			connect();
			String insert = "INSERT INTO transferrecord (account_id, deposit, withdraw) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, tr.getAccountId());
			pstmt.setLong(2, tr.getDeposit());
			pstmt.setLong(3, tr.getWithdraw());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("거래기록 업데이트 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	//거래기록 전체 불러오기(List)
	@Override
	public List<TransferRecord> selectAllTransferRecord() {
		List<TransferRecord> list = new ArrayList<TransferRecord>();
		try {
			connect();
			String select = "SELECT * FROM transferrecord ORDER BY transfer_no DESC";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TransferRecord tr = new TransferRecord();
				tr.setTransferNo(rs.getLong("transfer_no"));
				tr.setAccountId(rs.getString("account_id"));
				tr.setDeposit(rs.getLong("deposit"));
				tr.setWithdraw(rs.getLong("withdraw"));
				list.add(tr);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	//거래기록 ID별로 불러오기(List)
	@Override
	public List<TransferRecord> selectTransferRecordsById(String accountId) {
		List<TransferRecord> list = new ArrayList<TransferRecord>();
		try {
			connect();
			String select = "SELECT * FROM transferrecord WHERE account_id = ? ORDER BY transfer_no DESC";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, accountId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TransferRecord tr = new TransferRecord();
				tr.setTransferNo(rs.getLong("transfer_no"));
				tr.setAccountId(rs.getString("account_id"));
				tr.setDeposit(rs.getLong("deposit"));
				tr.setWithdraw(rs.getLong("withdraw"));
				list.add(tr);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

}
