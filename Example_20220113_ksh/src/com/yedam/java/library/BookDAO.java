package com.yedam.java.library;

import java.util.List;

public interface BookDAO {
	//전체조회
	public List<Book> selectAllBook();
	
	//단건조회
	public Book selectOneBook(String bookName);
	
	//책등록
	public void insertBook(Book book);
	
	public void updateBookRental(Book book);
	
	public void updateBookReturn(Book book);
	

}
