package com.java.yedam.app;

import java.util.List;
import java.util.Scanner;

import com.java.yedam.powerball.PowerballAccount;
import com.java.yedam.powerball.PowerballDAO;
import com.java.yedam.powerball.PowerballDAOImpl;

public class PowerballFrame {
	private Scanner scanner = new Scanner(System.in);
	private PowerballDAO pbd = PowerballDAOImpl.getInstance();
	
	public void run() {
		//첫 메뉴 1.로그인 2.회원가입
		while(true) {
			firstMenuPrint();
			int menuNo = menuSelect();
			if(menuNo == 1) {
				break;
			}
			else if(menuNo == 2) {
				createAccount();

			}
		}
		for(int i=0;i<5;) {
			int k = logIn();
			if(k == 1) {
				//로그인 성공 이제 사이트 내부 진입
				System.out.println("로그인 성공");
				while(true) {
					//두번째 메뉴
					secondMenuPrint();
					int menuNo = menuSelect();
					if(menuNo == 1) {
						powerballGame1();
						
					}
					else if(menuNo == 2) {
						powerballGame2();
						
					}
					else if(menuNo == 3) {
						powerballGame3();
						
					}
					else if(menuNo == 4) {
						normalballGame1();
						
					}
					else if(menuNo == 5) {
						normalballGame2();
					}
					else if(menuNo == 6) {
						normalballGame3();
					}
					else if(menuNo == 7) {
						chargePoint();
					}
					else if(menuNo == 9) {
						break;
					}
					
				}
			}
			else if(k == 0) {
				i++;
				System.out.println("로그인 5회 실패 시 프로그램을 강제 종료합니다." + i +"회 실패");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void firstMenuPrint() {
		System.out.println();
		System.out.println("========================================");
		System.out.println("파워볼 사이트를 이용하시려면 로그인을 해야합니다.");
		System.out.println("1.로그인 | 2.회원가입");
		System.out.println("========================================");
		System.out.println("메뉴선택>");
		
	}
	
	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;

	}
	
	public void createAccount() {
		PowerballAccount pba = inputAccountInfo();
		pbd.createAccount(pba);
	}
	
	public PowerballAccount inputAccountInfo() {
		PowerballAccount pba = new PowerballAccount();
		System.out.print("회원가입 하실 분의 이름>");
		pba.setPBAccountOwner(scanner.nextLine());
		System.out.print("회원가입 하실 분의 휴대전화 번호(숫자만 입력)>");
		pba.setPBAccountOwnerPhone(scanner.nextLine());
		System.out.print("생성할 ID를 입력하세요>");
		pba.setPBAccountId(scanner.nextLine());
		System.out.print("비밀번호를 입력하세요>");
		pba.setPBAccountPassword(scanner.nextLine());
		pba.setPBAPoint(0);
		
		return pba;
	}
	
	public int logIn() {
		//ID가 있는지 확인하는 메서드
		PowerballAccount pba = checkAccountInfo(inputIdPassword());
		if(pba != null) {
			System.out.println("로그인 성공하셨습니다.");
			return 1;
		}
		else {
			return 0;
		}
	}
	
	//ID 비밀번호가 정확한지 확인하고 반환하는 메서드
	public PowerballAccount checkAccountInfo(PowerballAccount pba) {
		PowerballAccount selectedAccount = pbd.selectAccountInfo(pba.getPBAccountId());
		if(selectedAccount == null) {
			System.out.println("해당 ID가 존재하지 않습니다.");
			return null;
		}
		else if(selectedAccount.getPBAccountPassword().equals(pba.getPBAccountPassword())) {
			return selectedAccount;
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return null;
		}
		
	}
	
	//ID 비밀번호 입력
	public PowerballAccount inputIdPassword() {
		PowerballAccount pba = new PowerballAccount();
		System.out.print("ID>");
		pba.setPBAccountId(scanner.nextLine());
		System.out.print("PASSWORD>");
		pba.setPBAccountPassword(scanner.nextLine());
		
		return pba;
		
	}
	
	//사이트 내부 메뉴 출력
	public void secondMenuPrint() {
		System.out.println();
		System.out.println("======================================================================================================================================");
		System.out.println("1.파워볼 맞추기| 2.파워볼 홀짝 맞추기 | 3.파워볼 언오버 맞추기 | 4.일반볼 합 홀짝 맞추기 | 5.일반볼 합 언오버 맞추기 | 6.포인트 충전하기 | 7.출금하기 | 9.프로그램종료");
		System.out.println("======================================================================================================================================");
		System.out.println("메뉴선택>");
	}
	
	//1. 파워볼 맞추기
	public void powerballGame1{
		
	}
	
	//파워볼 배열 생성 0~9
	public int[] powerballArray() {
		int[] intArray = new int[10];
		for(int i = 0; i<intArray.length;i++) {
			intArray[i] = (int)(Math.random()*10);
			for(int j=0; j>i; j++) {
				if(intArray[j] == intArray[i]) {
					i--;
				}
				
			}
		}
		return intArray;
	
		
	}
	
	
	
	

}
