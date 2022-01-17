package myproject1.src.com.java.yedam.gameresult;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import myproject1.src.com.java.yedam.common.DAO;

public class GameResultDAOImpl extends DAO implements GameResultDAO {
	//싱글톤
	private static GameResultDAO instance = new GameResultDAOImpl();
	private GameResultDAOImpl() {}
	public static GameResultDAO getInstance() {
		return instance;
	}
	

	//게임결과 전체조회
	@Override
	public List<GameResult> selectAllGameResult() {
		List<GameResult> list = new ArrayList<GameResult>();
		try {
			connect();
			String select = "SELECT * FROM gameresult ORDER BY totalgame_no DESC";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GameResult gr = new GameResult();
				gr.setAccountId(rs.getString("account_id"));
				gr.setGameNo(rs.getInt("game_no"));
				gr.setTotalgameNo(rs.getInt("totalgame_no"));
				gr.setBettingAmount(rs.getLong("betting_amount"));
				gr.setIsWin(rs.getInt("is_win"));
				gr.setWinPrize(rs.getLong("win_prize"));
				list.add(gr);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return list;
	}
	
	//게임별 게임결과 출력
	@Override
	public List<GameResult> selectGameResultsbyGames(int gameNo){
		List<GameResult> list = new ArrayList<GameResult>();
		try {
			connect();
			String select = "SELECT * FROM gameresult WHERE game_no = ? ORDER BY totalgame_no DESC";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, gameNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GameResult gr = new GameResult();
				gr.setAccountId(rs.getString("account_id"));
				gr.setGameNo(rs.getInt("game_no"));
				gr.setTotalgameNo(rs.getInt("totalgame_no"));
				gr.setBettingAmount(rs.getLong("betting_amount"));
				gr.setIsWin(rs.getInt("is_win"));
				gr.setWinPrize(rs.getLong("win_prize"));
				list.add(gr);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return list;
	}
	
	@Override
	//회원별 게임 결과 출력
	public List<GameResult> selectGameResultsbyId(String accountId){
		List<GameResult> list = new ArrayList<GameResult>();
		try {
			connect();
			String select = "SELECT * FROM gameresult WHERE account_id = ? ORDER BY totalgame_no DESC";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, accountId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GameResult gr = new GameResult();
				gr.setAccountId(rs.getString("account_id"));
				gr.setGameNo(rs.getInt("game_no"));
				gr.setTotalgameNo(rs.getInt("totalgame_no"));
				gr.setBettingAmount(rs.getLong("betting_amount"));
				gr.setIsWin(rs.getInt("is_win"));
				gr.setWinPrize(rs.getLong("win_prize"));
				list.add(gr);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return list;
	}

	//단건조회 (아이디검색)
	@Override
	public GameResult selectOneResult(String accountId) {
		GameResult gr = null;
		try {
			connect();
			String select = "SELECT * FROM gameresult WHERE account_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, accountId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				gr = new GameResult();
				gr.setAccountId(rs.getString("account_id"));
				gr.setGameNo(rs.getInt("game_no"));
				gr.setTotalgameNo(rs.getInt("totalgame_no"));
				gr.setBettingAmount(rs.getLong("betting_amount"));
				gr.setIsWin(rs.getInt("is_win"));
				gr.setWinPrize(rs.getLong("win_prize"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return gr;
	}

	//게임결과 등록
	@Override
	public void insertGameResult(GameResult gr) {
		try {
			connect();
			String insert = "INSERT INTO gameresult (account_id, game_no, betting_amount, is_win, win_prize) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, gr.getAccountId());
			pstmt.setInt(2, gr.getGameNo());
			pstmt.setDouble(3, gr.getBettingAmount());
			pstmt.setInt(4, gr.getIsWin());
			pstmt.setDouble(5, gr.getWinPrize());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("게임결과 업데이트 완료");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		

	}

}
