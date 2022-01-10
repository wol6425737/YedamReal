package homework;

import java.util.List;

public class Book {
	private static int SERIALNUMBER = 1000;
	private String bookName;
	private String author;
	private int bookNumber;
	private boolean isLent;
	
	Book(String bookName, String author){
		this.bookName = bookName;
		this.author = author;
		SERIALNUMBER++;
		bookNumber += SERIALNUMBER;
		this.isLent = false;
		
		
	}
	

	public int getBookNumber() {
		return bookNumber;
	}


	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}


	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean isLent() {
		
		return isLent;
	}
	
	public String getIsLent() {
		if(isLent == false) {
			return "대여가능";
		}
		else {
			return "대여중";
		}
	}
	
	public void borrowBook() {
		isLent = true;
	}
	
	public void returnBook() {
		isLent = false;
	}
	

}
