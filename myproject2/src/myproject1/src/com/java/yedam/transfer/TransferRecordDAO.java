package myproject1.src.com.java.yedam.transfer;

import java.util.List;

public interface TransferRecordDAO {
	
	//거래기록 등록
	public void insertTransferRecord(TransferRecord tr);
	
	//거래기록 전체 불러오기
	public List<TransferRecord> selectAllTransferRecord();
	
	
	//회원별 거래기록 출력
	public List<TransferRecord> selectTransferRecordsById(String accountId);
	
	
	
	

}
