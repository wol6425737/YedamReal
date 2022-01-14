package com.yedam.java.library;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class BookDAOImpl extends DAO implements BookDAO {
	//싱글톤
	private static BookDAO instance = new BookDAOImpl();
	private BookDAOImpl() {}
	public static BookDAO getInstance() {
		return instance;
	}
	
	//전체조회
	@Override
	public List<Book> selectAllBook() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			String select = "SELECT * FROM book ORDER BY book_name";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setRental(rs.getInt("book_rental"));
				list.add(book);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return list;
	}
	
	//단건조회
	@Override
	public Book selectOneBook(String bookName) {
		Book book = null;
		try {
			connect();
			String select = "SELECT * FROM book WHERE book_name = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, bookName);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setRental(rs.getInt("book_rental"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return book;
	}


	//책등록
	@Override
	public void insertBook(Book book) {
		try {
			connect();
			String insert = "INSERT INTO book VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookContent());
			pstmt.setInt(4, book.getRental());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("계좌가 정상적으로 개설되었습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		

	}
	
	//책 대여 반납 설정
	public void updateBookRental(Book book) {
		try {
			connect();
			String update = "UPDATE book SET book_rental =  1 WHERE book_name = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, book.getBookName());
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("정상적으로 대여되었습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
	public void updateBookReturn(Book book) {
		
		try {
			connect();
			String update = "UPDATE book SET book_rental = 0 WHERE book_name = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, book.getBookName());
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("정상적으로 반납되었습니다.");
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
	}

}
