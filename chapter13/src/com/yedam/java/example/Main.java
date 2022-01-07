package com.yedam.java.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 문제2) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서 
		//       최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		//  1.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 가격을 입력받을 수 있도록 구현하세요.
		// 3) 각 가격에 해당하는 제품명은 인덱스+1로 합니다. 
		//    예를 들어 배열[0] = 10000 이면 10,000원인 제품은 1번째 제품입니다.
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		
		List<Menu> menu = new ArrayList<Menu>();
		
		Scanner scanner = new Scanner(System.in);
		int num;
		int analysis;
		int maxNum = 0;
		int sum = 0;
		int max = 0;
		boolean run = true;
		while(run) {
			System.out.println("1.상품 및 가격입력 | 2.제품별 가격 | 3.분석 | 4.종료");
			System.out.println("실행하고자 하는 번호를 입력하세요 : ");
			num = scanner.nextInt();
			switch(num) {
			case 1:
				System.out.println("상품 이름 입력 스페이스 가격 입력 엔터");
				menu.add(new Menu(scanner.next(),scanner.nextInt()));
				break;
			case 2:
				System.out.println("총 상품 수 : " + menu.size());
				System.out.println("제품별 가격");
				for(int i = 0; i<menu.size();i++) {
					String name = menu.get(i).getName();
					int price = menu.get(i).getPrice();
					System.out.println((i+1) + "번 상품 " + name + "의 가격 : " + price);
				}
				System.out.println();
				break;
			case 3:
				System.out.println("총 상품 수 : " + menu.size());
				System.out.println("제품별 가격");
				for(int i = 0; i<menu.size();i++) {
					String name = menu.get(i).getName();
					int price = menu.get(i).getPrice();
					System.out.println((i+1) + "번 상품 " + name + "의 가격 : " + price);
				}
				
				System.out.println("분석 하고 싶은 제품의 번호를 입력하시오 : ");

				analysis = scanner.nextInt();
				for(int i = 0; i<menu.size();i++) {
					if(max < menu.get(i).getPrice()) {
						max = menu.get(i).getPrice();
						maxNum = i;
					} 
				}
				for(int i = 0; i<menu.size();i++) {
					if(menu.get(i).getPrice() != max && i != analysis-1) {
						sum += menu.get(i).getPrice();	
					}
				}
				System.out.println("최고 가격의 제품은 : " + (maxNum+1) + "번 제품");
				System.out.println("최고 가격 제품과 선택한 제품을 제외한 제품들의 총 합은 :"+sum);
				System.out.println();
				System.out.println();
				break;
			
			case 4:
				System.out.println("프로그램 종료");
				run = false;
				break;
			
			default:
				System.out.println("잘 못 누르셨습니다.");
				break;
			}

		}
		
		
		
	}

}
