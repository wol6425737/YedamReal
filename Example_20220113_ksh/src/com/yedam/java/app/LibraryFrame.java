package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.library.Book;
import com.yedam.java.library.BookDAO;
import com.yedam.java.library.BookDAOImpl;

public class LibraryFrame {
	private Scanner scanner = new Scanner(System.in);
	private BookDAO dao = BookDAOImpl.getInstance();

	public void run() {
		while (true) {
			// 메뉴 출력
			menuPrint();

			// 메뉴 선택
			int menuNo = menuSelect();

			// 각 기능별 실행
			if (menuNo == 1) {
				// 전체조회
				selectAll();

			} else if (menuNo == 2) {
				// 단건조회
				selectOne();
			} else if (menuNo == 3) {
				// 내용검색
				findBookContent(bookContents());

			} else if (menuNo == 4) {
				// 대여가능
				isRentalBook();
			} else if (menuNo == 5) {
				// 책 대여
				rental();

			} else if (menuNo == 6) {
				// 책 반납
				returnBook();
				
			} else if (menuNo == 7) {
				// 책 등록
				insert();
			} else if (menuNo == 9) {
				// 종료
				end();
				break;
			}

		}

	}

	// menuPrint
	public void menuPrint() {
		System.out.println();
		System.out.println("================================================================================");
		System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책 대여 | 6.책 반납 | 7.책 등록 | 9.종료");
		System.out.println("================================================================================");
		System.out.print("메뉴선택>");

	}

	// menuSelect
	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;

	}

	// insert() 책등록
	public void insert() {
		Book book = inputBookInfo();

		dao.insertBook(book);
	}

	// inputBookInfo() 책정보입력
	public Book inputBookInfo() {
		Book book = new Book();
		System.out.print("책제목>");
		book.setBookName(scanner.nextLine());
		System.out.print("저자명>");
		book.setBookWriter(scanner.nextLine());
		System.out.print("내용>");
		book.setBookContent(scanner.nextLine());
		book.setRental(0);

		return book;

	}

	// selectAll() 전체조회
	public void selectAll() {
		// 전체 책 출력
		List<Book> list = dao.selectAllBook();
		for (Book book : list) {
			System.out.println(book);
		}
	}

	// selectOne() 단권조회
	public void selectOne() {
		// 책 이름 입력
		System.out.print("책이름 입력>");
		String bookName = scanner.nextLine();
		// 책 정보 조회
		Book book = dao.selectOneBook(bookName);

		// 책 정보 출력
		if (book == null) {
			System.out.println("해당 책이 없습니다.");

		} else {
			System.out.println(book);
		}

	}

	// 책 내용 검색

	public void findBookContent(String content) {
		List<Book> list = dao.selectAllBook();
		for (Book book : list) {
			if (book.getBookContent().indexOf(content) != -1) {
				System.out.println(book);
			}
		}
	}

	public String bookContents() {
		System.out.print("책 내용>");
		String content = scanner.nextLine();
		return content;
	}

	public void isRentalBook() {
		List<Book> list = dao.selectAllBook();

		for (Book book : list) {
			if (book.getRental() == 0) {
				System.out.println(book);
			}

		}
	}

	public void end() {
		System.out.println("프로그램 종료");
	}

	public void rental() {
		// 책 이름 입력
		System.out.print("대여할 책이름 입력>");
		String bookName = scanner.nextLine();
		// 책 정보 조회
		Book book = dao.selectOneBook(bookName);

		// 책 정보 출력
		if (book == null) {
			System.out.println("해당 책이 없습니다.");
			

		} else {
			if (book.getRental() == 1) {
				System.out.println("대여가 불가능합니다.");
				
			} else {
				dao.updateBookRental(book);
				
			}
		}

	}

	public void returnBook() {
		// 책 이름 입력
		System.out.print("대여할 책이름 입력>");
		String bookName = scanner.nextLine();
		// 책 정보 조회
		Book book = dao.selectOneBook(bookName);

		// 책 정보 출력
		if (book == null) {
			System.out.println("해당 책이 없습니다.");
			

		} else {
			if (book.getRental() == 0) {
				System.out.println("대여중인 책이 아닙니다.");
				
			} else {
				dao.updateBookReturn(book);
			
			}
		}

	}

}
