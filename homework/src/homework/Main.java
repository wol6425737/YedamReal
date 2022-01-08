package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//문제) 다음은 도서관리프로그램 중 일부입니다.
		//	1) 메뉴는 다음과 같이 구성하세요.
		//	1.책정보 입력 | 2.전체조회 | 3.단건조회 | 4.책 대여 | 5.책 반납 | 6.종료
		//	2) 입력되는 책정보는 책이름과 저자명입니다.
		//	3) 전체 조회 및 단건 조회 시 책번호, 책이름, 저자명, 해당 책의 대여여부(대여중, 대여가능)도 함께 출력되도록 하세요.
		//	4) 책 대여 시 해당 책의 대여여부를 확인해서
		//	   이미 대여 중인 책일 경우 "대여 중입니다."라는 안내문구를 출력하고
		//	   대여가 가능한 책일 경우 대여처리 후 "대여되었습니다"라고 출력하도록 하세요.
		//	5) 책 반납 시 반납처리 후 "반납되었습니다."라고 출력하도록 하세요.
		//  6) 종료시 "프로그램 종료"를 출력하도록 하세요.
		
		/*
		 중앙로 도서관에서 근무 중인 김씨의 오늘 업무일지는 다음과 같습니다.
		 - 당일 들어온 책에 대해 입고처리
		 (참고, 책마다 고유번호가 자동으로 부여됩니다. )
		 	1) 혼자공부하는자바, 신용권      
		 	2) 이것이자바다, 신용권	      
		 	3) 자바스크립트파워북, 에이포스트  
		 	4) 나는프로그래머다, 이상순     
		 	5) 오늘부터개발자, 김용닥       
		 	6) SQL의 비밀노트, 김예담      
		 - 현재 보유 중인 책 목록 확인
		 - 이용자가 요청한 책 정보 확인
		 	1) 이것이자바다
		 	2) 오늘부터개발자
		 - 책 대여
		 	1) 나는프로그래머다 -> 정상대여
		 	2) 혼자공부하는자바 -> 정상대여
		 	3) 나는프로그래머다 -> 대여 중
		 - 책 반납
		 	1) 혼자공부하는자바
		 */
		boolean run = true;
		String run1;
		boolean run2 = true;
		boolean run3 = true;
		boolean have;
		Scanner scanner = new Scanner(System.in);
		int num;
		int lent;
		List<Book> list = new ArrayList<Book>();
		while(run) {
			System.out.println("==============================================================");
			System.out.println("1.책정보 입력 | 2.전체조회 | 3.단건조회 | 4.책 대여 | 5.책 반납 | 6.종료");
			System.out.println("==============================================================");
			System.out.print(">> ");
			num = Integer.parseInt(scanner.nextLine());
			
			switch(num) {
			case 1:
				while(run2) {
					System.out.print("책 이름 >> ");
					String bookName = scanner.nextLine();
					System.out.print("책 저자 >> ");
					String author = scanner.nextLine();
					Book book = new Book(bookName,author);
					list.add(book);
					run3 = true;
					while(run3) {
						System.out.println("계속 책정보를 입력하시겠습니까?(1.yes 2.no) >> ");
						run1 = scanner.nextLine();
						if(run1.equals("1")||run1.equals("yes")||run1.equals("Yes")||run1.equals("YES")) {
							run3 = false;
							
						}
						else if(run1.equals("2")||run1.equals("no")||run1.equals("NO")||run1.equals("No")) {
							run3 = false;
							run2 = false;
						}
						else {
							System.out.println("책정보 입력을 더 원할 시 \"1\" 혹은 \"yes\" 아니면 \"2\" 혹은 \"no\"를 입력하세요");
							
						}
						
					}
					
					
				}
				run2 = true;
				break;


			case 2:
				for(int i = 0; i<list.size();i++) {
					String name = list.get(i).getBookName();
					String authorName = list.get(i).getAuthor();
					System.out.printf("%4d번 책이름 :%-15s저자 : %-8s%10s\n",list.get(i).getBookNumber(),name ,authorName,list.get(i).getIsLent());
				}
				System.out.println();
				break;
			case 3:
				System.out.println("조회할 책 이름을 입력하세요");
				String searchBook = scanner.nextLine();
				have = false;
				for(int i = 0; i<list.size();i++) {
					String name = list.get(i).getBookName();
					String authorName = "저자 : " + list.get(i).getAuthor();
					if(searchBook.equals(name)) {
						have = true;
						System.out.printf("%4d번 책이름 :%-15s%-8s%10s\n",list.get(i).getBookNumber(),name,authorName,list.get(i).getIsLent());
						
					}
					else {
						continue;
					}
				}
				System.out.println();
				if(have == false) {
					System.out.println("도서관에 없는 책이거나 이름을 잘 못 입력하셨습니다.");
				}
				break;
			case 4:
				System.out.print("대여 할 책 이름을 입력하세요 : ");
				String borrowBook = scanner.nextLine();
				have = false;
				for(int i = 0; i<list.size();i++) {
					if(borrowBook.equals(list.get(i).getBookName())) {
						have = true;
						System.out.println(list.get(i).getIsLent());
						if(list.get(i).getIsLent().equals("대여가능")) {
							System.out.println("대여하시겠습니까? 1.대여 함 2.대여 안함 ");
							lent = Integer.parseInt(scanner.nextLine());
							if(lent == 1) {
								list.get(i).borrowBook();
								System.out.println("대여 완료됐습니다.");
							}
							else {
								System.out.println("대여를 하지 않았습니다.");
							}
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
				break;
			case 5:
				System.out.print("반납 할 책 이름을 입력하세요 : ");
				have = false;
				String returnBook = scanner.nextLine();
				for(int i = 0; i<list.size();i++) {
					if(returnBook.equals(list.get(i).getBookName())) {
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
				
				break;
			case 6:
				System.out.println("도서 관리 프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("번호를 잘 못 입력하셨습니다.");
			}
			
		}
		
	}

}
