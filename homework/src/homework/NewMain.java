package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewMain {
	public static void main(String[] args) {
		boolean run = true;
		String run1 = null;
		boolean run2;
		boolean run3;
		Scanner scanner = new Scanner(System.in);
		int num;
		Library library = new Library();
		while(run) {
			System.out.println("==============================================================");
			System.out.println("1.책정보 입력 | 2.전체조회 | 3.단건조회 | 4.책 대여 | 5.책 반납 | 6.종료");
			System.out.println("==============================================================");
			System.out.print(">> ");
			num = Integer.parseInt(scanner.nextLine());
			
			switch(num) {
			case 1:
				run2 = true;
				while(run2) {
					System.out.print("책 이름 >> ");
					String bookName = scanner.nextLine();
					System.out.print("책 저자 >> ");
					String author = scanner.nextLine();
					library.addBook(bookName, author);
					run3 = true;
					System.out.println("계속 책정보를 입력하시겠습니까?(1.yes 2.no) >> ");
					run1 = scanner.nextLine();
					library.continueAddBook(run1, run2, run3);
	
				}
				run2 = true;
				break;


			case 2:
				library.printBookList();
				break;
			case 3:
				
				System.out.println("조회할 책 이름을 입력하세요");
				String searchBook = scanner.nextLine();
				library.selectBookInfo(searchBook);
				break;
			
			case 4:
				System.out.print("대여 할 책 이름을 입력하세요 : ");
				String borrowBook = scanner.nextLine();
				library.borrowBook(borrowBook);
				break;
			
			case 5:
				System.out.print("반납 할 책 이름을 입력하세요 : ");
				String returnBook = scanner.nextLine();
				library.returnBook(returnBook);
				break;
			
			case 6:
				System.out.println("도서 관리 프로그램을 종료합니다.");
				run = false;
				break;
			
			default:
				System.out.println("번호를 잘 못 입력하셨습니다.");
			}
			
		}
		scanner.close();
	}

}
