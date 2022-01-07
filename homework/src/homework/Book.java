package homework;

public class Book {
	private static int SERIALNUMBER = 1000;
	private String bookName;
	private String author;
	private int bookNumber;
	
	Book(String bookName, String author){
		this.bookName = bookName;
		this.author = author;
		SERIALNUMBER++;
		bookNumber += SERIALNUMBER;
		
		
	}
	

	public static int getSERIALNUMBER() {
		return SERIALNUMBER;
	}


	public static void setSERIALNUMBER(int sERIALNUMBER) {
		SERIALNUMBER = sERIALNUMBER;
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
		
		return true;
	}
	
	
	

}
