package com.yedam.java.library;

public class Book {
	private String bookName;	//책이름
	private String bookWriter;	//저자명
	private String bookContent; //책내용
	private int rental;		//대여여부
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public int getRental() {
		return rental;
	}
	public void setRental(int rental) {
		this.rental = rental;
	}
	@Override
	public String toString() {
		return "책제목 : " + bookName + ", 저자명 : " + bookWriter + ", 내용 : " + bookContent + ", 대여여부 : " 
					+ ((rental == 0)? "대여가능" : "대여중") ;
	}
	
	
	
	
	
	

}
