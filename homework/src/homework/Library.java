package homework;

import java.util.ArrayList;
import java.util.List;

public class Library {
	//필드
	private List<Book> list;
	
	//생성자
	public Library() {
		list = new ArrayList<Book>();
	}
	
	
	//메서드
	
	//책 정보 입력
	public void addBook(String name, String writer) {
		list.add(new Book(name, writer));


	}
	
	//책 정보 계속 입력 받을 건지 묻기
	public void continueAddBook(String run1,boolean run2, boolean run3) {
		while(run3) {
			
			if(run1.equals("1")||run1.equals("yes")||run1.equals("Yes")||run1.equals("YES")) {
				break;
				
			}
			else if(run1.equals("2")||run1.equals("no")||run1.equals("NO")||run1.equals("No")) {
				run2 = false;
				break;
				
			}
			else {
				System.out.println("책정보 입력을 더 원할 시 \"1\" 혹은 \"yes\" 아니면 \"2\" 혹은 \"no\"를 입력하세요");
				break;
			}
			
		}
	}
	
	
	//책 정보 전체 출력
	public void printBookList() {
		for (int i = 0; i < list.size(); i++) {
			int bookNumber = list.get(i).getBookNumber();
			String name = list.get(i).getBookName();
			String authorName = "저자 : " + list.get(i).getAuthor();
			String isLent = list.get(i).getIsLent();
			System.out.printf("%4d번 책이름 : %-20s\t %-20s \t %s\n", bookNumber, name, authorName, isLent);
		}
		System.out.println();
	}
	
	//책 정보 단건 출력
	public void selectBookInfo(String name) {
		boolean have = false;
		for(int i = 0; i<list.size();i++) {
			int bookNumber = list.get(i).getBookNumber();
			list.get(i).getBookName();
			String authorName = "저자 : " + list.get(i).getAuthor();
			String isLent = list.get(i).getIsLent();
			if(list.get(i).getBookName().equals(name)) {
				have = true;
				System.out.printf("%4d번 책이름 : %-20s\t %-20s \t %s\n", bookNumber, list.get(i).getBookName(), authorName, isLent);						
			}
			else {
				continue;
			}
		}
		System.out.println();
		if(have == false) {
			System.out.println("도서관에 없는 책이거나 이름을 잘 못 입력하셨습니다.");
		}
	}
	
	
	//책 대여
	public void borrowBook(String borrowBook) {
		boolean have;
		have = false;
		int lent = 0;
		for(int i = 0; i<list.size();i++) {
			if(borrowBook.equals(list.get(i).getBookName())) {
				have = true;
				System.out.println(list.get(i).getIsLent());
				if(list.get(i).getIsLent().equals("대여가능")) {
					System.out.println("대여하시겠습니까? 1.대여 함 2.대여 안함 ");
					isRental(lent,i);
				}
				else {
					System.out.println("대여가 불가능합니다.");
				}
			}
			else{
				continue;
			}	
		}
		if(have == false) {
			System.out.println("도서관에 없는 책이거나 이름을 잘 못 입력하셨습니다.");
		}
	}
	
	//대여 가능 여부 확인
	public void isRental(int lent, int i) {

		if(lent == 1) {
			list.get(i).borrowBook();
			System.out.println("대여 완료됐습니다.");
		}
		else if(lent==2) {
			System.out.println("대여를 하지 않았습니다.");
		}
		
	}
	
	
	//책 반납
	public void returnBook(String name) {
		boolean have = false;
		for(int i = 0; i<list.size();i++) {
			if(name.equals(list.get(i).getBookName())) {
				have = true;
				if(list.get(i).isLent()) {
					System.out.println("반납 완료했습니다.");
					list.get(i).returnBook();
				}
				else {
					System.out.println("대여 중인 책이 아닙니다.");
				}

			}
			else{
				continue;
			}	
		}
		if(have == false) {
			System.out.println("도서관에 없는 책이거나 이름을 잘 못 입력하셨습니다.");
		}
		
	}


	
	

}
