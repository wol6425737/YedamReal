package com.yedam.java.ch02_04;

import java.util.Scanner;

public class MainExample {
	public static void main(String[] args) {
		// 문제1) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		//	출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		
		Scanner scanner = new Scanner(System.in);
		Product[] list = null;
		int productNum = 0;
		int num;
		int analysis;
		int maxNum = 0;
		int sum = 0;
		int max = 0;
		boolean run = true;
		while(run) {
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("메뉴를 선택 하세요 : ");
			num = scanner.nextInt();
			switch(num) {
			case 1:
				System.out.print("상품 수 입력 : ");
				productNum = scanner.nextInt();
				list = new Product[productNum];
				break;
			case 2:
				for(int i=0; i<list.length;i++) {
					System.out.print("상품명>");
					String name = scanner.next();
					System.out.print("가격>");
					int price = scanner.nextInt();
					Product product = new Product(name,price);
					list[i] = product;
				}
				break;
			case 3:
				for(int i=0; i<list.length;i++) {
					System.out.println((i+1) + "번 이름 : " + list[i].getName() + "가격 : " + list[i].getPrice());	
				}

				break;
			case 4:
				String maxName = null;
				System.out.println("분석 하고 싶은 제품의 번호를 입력하시오 : ");
				analysis = scanner.nextInt();
				for(int i = 0; i<list.length;i++) {
					if(max < list[i].getPrice()) {
						max = list[i].getPrice();
						maxNum = i;
						maxName = list[i].getName();
					} 
				}
				for(int i = 0; i<list.length;i++) {
					if(list[i].getPrice() != max && i != analysis-1) {
						sum += list[i].getPrice();	
					}
				}
				System.out.println("최고 가격의 제품은 : " + maxName);
				System.out.println("최고 가격 제품과 선택한 제품을 제외한 제품들의 총 합은 :"+sum);
				System.out.println();
				System.out.println();
				break;
			
			case 5:
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
