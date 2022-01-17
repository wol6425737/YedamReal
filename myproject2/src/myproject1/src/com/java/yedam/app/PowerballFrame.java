package myproject1.src.com.java.yedam.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import myproject1.src.com.java.yedam.account.Account;
import myproject1.src.com.java.yedam.account.AccountDAO;
import myproject1.src.com.java.yedam.account.AccountDAOImpl;
import myproject1.src.com.java.yedam.gameresult.GameResult;
import myproject1.src.com.java.yedam.gameresult.GameResultDAO;
import myproject1.src.com.java.yedam.gameresult.GameResultDAOImpl;
import myproject1.src.com.java.yedam.powerball.PowerballAccount;
import myproject1.src.com.java.yedam.powerball.PowerballDAO;
import myproject1.src.com.java.yedam.powerball.PowerballDAOImpl;

public class PowerballFrame {
	private Scanner scanner = new Scanner(System.in);
	private PowerballDAO pbd = PowerballDAOImpl.getInstance();
	private AccountDAO ad = AccountDAOImpl.getInstance();
	private GameResultDAO gd = GameResultDAOImpl.getInstance();
	public AccountFrame af = new AccountFrame();
	public static String ID = null;
	public static String NAME = null;

	public void run() {
		// 첫 메뉴 1.로그인 2.회원가입
		while (true) {
			firstMenuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				break;
			} else if (menuNo == 2) {
				createAccount();

			}
		}
		outer: for (int i = 0; i < 5;) {
			int k = logIn();
			if (k == 1) {
				// 로그인 성공 이제 사이트 내부 진입
				// 관리자 ID인지 일반 회원인지 체크
				while (true) {
					// 두번째 메뉴
					secondMenuPrint();
					int menuNo = menuSelect();
					if (menuNo == 1) {
						powerballGame1();

					} else if (menuNo == 2) {
						powerballGame2();

					} else if (menuNo == 3) {
						powerballGame3();

					} else if (menuNo == 4) {
						normalballGame1();

					} else if (menuNo == 5) {
						normalballGame2();
					} else if (menuNo == 6) {
						chargePoint();
					} else if (menuNo == 7) {
						withdraw();
					} else if (menuNo == 8) {
						checkPoint();
					} else if (menuNo == 9) {
						break outer;
					}

				}
			} else if (k == 0) {
				i++;
				System.out.println("로그인 5회 실패 시 프로그램을 강제 종료합니다." + i + "회 실패");
			} else if (k == 3) {// 관리자 로그인
				System.out.println("관리자 아이디로 로그인 하였습니다.");
				while (true) {
					// 관리자 페이지
					adminMenuPrint();
					int menuNo = menuSelect();
					if (menuNo == 1) {
						adminMenu1();

					} else if (menuNo == 2) {
						adminMenu2();

					} else if (menuNo == 3) {
						adminMenu3();

					} else if (menuNo == 4) {
						adminMenu4();
					} else if (menuNo == 5) {
						break outer;
					}

				}
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

	public int menuSelect1() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
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
		while (true) {
			System.out.print("생성할 ID를 입력하세요>");
			String Id = scanner.nextLine();
			PowerballAccount checkid = new PowerballAccount();
			checkid = pbd.selectAccountInfo(Id);
			if (checkid == null) {
				pba.setPBAccountId(Id);
				break;
			}
			System.out.println("중복 아이디가 존재합니다.");
		}

		System.out.print("비밀번호를 입력하세요>");
		pba.setPBAccountPassword(scanner.nextLine());
		pba.setPBAPoint(0);

		return pba;
	}

	public int logIn() {
		// ID가 있는지 확인하는 메서드
		PowerballAccount pba = checkAccountInfo(inputIdPassword());
		if (pba != null) {
			System.out.println("로그인 성공하셨습니다.");
			ID = pba.getPBAccountId();
			NAME = pba.getPBAccountOwner();
			if (pba.getPBAccountId().equals("admin")) {
				ID = pba.getPBAccountId();
				return 3;
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}

	// ID 비밀번호가 정확한지 확인하고 반환하는 메서드
	public PowerballAccount checkAccountInfo(PowerballAccount pba) {
		PowerballAccount selectedAccount = pbd.selectAccountInfo(pba.getPBAccountId());
		if (selectedAccount == null) {
			System.out.println("해당 ID가 존재하지 않습니다.");
			return null;
		} else if (selectedAccount.getPBAccountPassword().equals(pba.getPBAccountPassword())) {
			return selectedAccount;
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return null;
		}

	}

	// ID 비밀번호 입력
	public PowerballAccount inputIdPassword() {
		PowerballAccount pba = new PowerballAccount();
		System.out.print("ID>");
		pba.setPBAccountId(scanner.nextLine());
		System.out.print("PASSWORD>");
		pba.setPBAccountPassword(scanner.nextLine());

		return pba;

	}

	// 일반회원 사이트 내부 메뉴 출력
	public void secondMenuPrint() {
		System.out.println();
		System.out.println(
				"=======================================================================================================================================================");
		System.out.println(
				"1.파워볼 맞추기| 2.파워볼 홀짝 맞추기 | 3.파워볼 언오버 맞추기 | 4.일반볼 합 홀짝 맞추기 | 5.일반볼 합 언오버 맞추기 | 6.포인트 충전하기 | 7.출금하기 | 8. 본인 포인트확인 | 9.프로그램종료");
		System.out.println(
				"=======================================================================================================================================================");
		System.out.println("메뉴선택>");
	}

	// 관리자 메뉴
	public void adminMenuPrint() {
		System.out.println();
		System.out.println(
				"===========================================================================================================================================");
		System.out.println("1.모든 게임 결과 확인| 2.게임 별 결과 출력 | 3.회원 별 게임 결과 출력 | 4.회원 리스트 보기 |5.프로그램종료");
		System.out.println(
				"===========================================================================================================================================");
		System.out.println("메뉴선택>");

	}

	// 파워볼 0부터 9까지 숫자 중 1개 추첨
	public int powerball() {

		int pb = (int) ((Math.random() * 10));

		return pb;
	}

	// 일반볼 1~28까지 숫자 중 5개 추첨
	public int[] normalballArray() {
		int[] intArray = new int[5];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) ((Math.random() * 28) + 1);
			for (int j = 0; j < i; j++) {
				if (intArray[j] == intArray[i]) {
					i--;
				}
			}
		}
		return intArray;

	}

	public void powerballGame1() {
		GameResult gr = new GameResult();
		double maxBettingAmount = pbd.selectAccountPoint(ID);
		double bettingAmount;
		int chooseNo;
		int pb = powerball();
		System.out.println("============파워볼 맞추기==============");
		System.out.println("0부터 9까지 숫자 중 하나의 숫자를 맞추는 게임입니다.");
		System.out.printf("베팅 한도 >%13.3f\n", maxBettingAmount);
		while (true) {
			System.out.print("베팅할 금액>");
			bettingAmount = Double.parseDouble(scanner.nextLine());
			if (bettingAmount > maxBettingAmount) {
				System.out.println("보유하신 포인트보다 베팅 시도 금액이 더 큽니다. 다시 입력하세요.");
			} else {
				System.out.println("베팅 완료 되었습니다.");
				System.out.printf("잔여 포인트> %13.3f\n", (maxBettingAmount - bettingAmount));
				break;
			}

		}

		PowerballAccount pba = pbd.selectAccountInfo(ID);
		pba.setPBAPoint(-bettingAmount);
		pbd.updateAccountPoint(pba);
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("0~9까지의 숫자 중 하나를 선택하세요(베팅을 취소하시려면 10을 입력하세요)>");
			chooseNo = menuSelect();
			if (chooseNo < 10) {
				break;
			} else if (chooseNo == 10) {
				System.out.println("베팅을 취소합니다. 포인트 환불 완료");
				pba.setPBAPoint(+bettingAmount);
				pbd.updateAccountPoint(pba);
				return;
			} else {
				System.out.println("0부터 9까지의 숫자 중 하나를 선택하시거나 베팅을 취소하시려면 10을 입력하세요.");
			}
		}

		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("파워볼은 (" + pb + "), " + ID + "님이 고른 숫자는 " + "(" + chooseNo + ")입니다.");

		if (pb == chooseNo) {
			System.out.println("축하합니다. 적중하셨습니다.");
			pba.setPBAPoint(1.97 * bettingAmount);
			pbd.updateAccountPoint(pba);
			gr.setWinPrize(1.97 * bettingAmount);
			gr.setIsWin(1);

		} else {
			System.out.println("아쉽습니다. 미적중하셨습니다.");
			gr.setIsWin(0);
		}
		gr.setAccountId(ID);
		gr.setGameNo(1);
		gr.setBettingAmount(bettingAmount);
		gd.insertGameResult(gr);

	}

	public void powerballGame2() {

		GameResult gr = new GameResult();
		double maxBettingAmount = pbd.selectAccountPoint(ID);
		double bettingAmount;
		int chooseNo;
		int pb = powerball();
		String oddEven;
		if (pb % 2 == 0) {
			oddEven = "짝";

		} else {
			oddEven = "홀";
		}
		String myOddEven;

		System.out.println("============파워볼 홀짝 맞추기==============");
		System.out.println("파워볼(0~9)이 홀수일지 짝수일지 맞추는 게임입니다.");
		System.out.printf("베팅 한도 >%13.3f\n", maxBettingAmount);
		while (true) {
			System.out.print("베팅할 금액>");
			bettingAmount = Double.parseDouble(scanner.nextLine());
			if (bettingAmount > maxBettingAmount) {
				System.out.println("보유하신 포인트보다 베팅 시도 금액이 더 큽니다. 다시 입력하세요.");
			} else {
				System.out.println("베팅 완료 되었습니다.");
				System.out.printf("잔여 포인트> %13.3f\n", (maxBettingAmount - bettingAmount));
				break;
			}
		}

		PowerballAccount pba = pbd.selectAccountInfo(ID);
		pba.setPBAPoint(-bettingAmount);
		pbd.updateAccountPoint(pba);
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("1.홀 2.짝 3.베팅취소>>>(숫자를 입력하세요)");
			chooseNo = menuSelect1();
			if (chooseNo == 1) {
				System.out.println("홀에 베팅하셨습니다.");
				myOddEven = "홀";
				break;
			} else if (chooseNo == 2) {
				System.out.println("짝에 베팅하셨습니다.");
				myOddEven = "짝";
				break;
			} else if (chooseNo == 3) {
				pba.setPBAPoint(+bettingAmount);
				pbd.updateAccountPoint(pba);
				System.out.println("포인트를 환불합니다.");
				return;
			} else {
				System.out.println("1 혹은 2 혹은 3을 입력하세요");
			}

		}
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("파워볼은 (" + pb + "), " + oddEven + "이고, " + ID + "님은  " + myOddEven + "을 선택하셨습니다.");

		if (oddEven.equals(myOddEven)) {
			System.out.println("축하합니다. 적중하셨습니다.");
			pba.setPBAPoint(1.97 * bettingAmount);
			pbd.updateAccountPoint(pba);
			gr.setWinPrize(1.97 * bettingAmount);
			gr.setIsWin(1);
		} else {
			System.out.println("아쉽습니다. 미적중하셨습니다.");
			gr.setIsWin(0);

		}
		gr.setAccountId(ID);
		gr.setGameNo(2);
		gr.setBettingAmount(bettingAmount);
		gd.insertGameResult(gr);

	}

	public void powerballGame3() {
		GameResult gr = new GameResult();
		double maxBettingAmount = pbd.selectAccountPoint(ID);
		double bettingAmount;
		int chooseNo;
		int pb = powerball();
		String unov;
		if (pb < 5) {// 언더
			unov = "언더";
		} else {// 오버
			unov = "오버";
		}
		String myUnov;

		System.out.println("============파워볼 언오버 맞추기==============");
		System.out.println("파워볼(0~9)이 언더(0~4) 오버(5~9)일지 맞추는 게임입니다.");
		System.out.printf("베팅 한도 >%13.3f\n", maxBettingAmount);
		while (true) {
			System.out.print("베팅할 금액>");
			bettingAmount = Double.parseDouble(scanner.nextLine());
			if (bettingAmount > maxBettingAmount) {
				System.out.println("보유하신 포인트보다 베팅 시도 금액이 더 큽니다. 다시 입력하세요.");
			} else {
				System.out.println("베팅 완료 되었습니다.");
				System.out.printf("잔여 포인트> %13.3f\n", (maxBettingAmount - bettingAmount));
				break;
			}
		}
		PowerballAccount pba = pbd.selectAccountInfo(ID);
		pba.setPBAPoint(-bettingAmount);
		pbd.updateAccountPoint(pba);
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("1.언더 2.오버 3.베팅취소>>>(숫자를 입력하세요)");
			chooseNo = menuSelect1();
			if (chooseNo == 1) {
				System.out.println("언더에 베팅하셨습니다.");
				myUnov = "언더";
				break;
			} else if (chooseNo == 2) {
				System.out.println("오버에 베팅하셨습니다.");
				myUnov = "오버";

			} else if (chooseNo == 3) {
				pba.setPBAPoint(+bettingAmount);
				pbd.updateAccountPoint(pba);
				System.out.println("포인트를 환불합니다.");
				return;
			} else {
				System.out.println("1 혹은 2 혹은 3을 입력하세요");
			}

		}
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("파워볼은 (" + pb + "), " + unov + "이고, " + ID + "님은  " + myUnov + "를 선택하셨습니다.");

		if (unov.equals(myUnov)) {
			System.out.println("축하합니다. 적중하셨습니다.");
			pba.setPBAPoint(1.97 * bettingAmount);
			pbd.updateAccountPoint(pba);
			gr.setWinPrize(1.97 * bettingAmount);
			gr.setIsWin(1);
		} else {
			System.out.println("아쉽습니다. 미적중하셨습니다.");
			gr.setIsWin(0);

		}
		gr.setAccountId(ID);
		gr.setGameNo(3);
		gr.setBettingAmount(bettingAmount);
		gd.insertGameResult(gr);

	}

	public void normalballGame1() {
		GameResult gr = new GameResult();
		double maxBettingAmount = pbd.selectAccountPoint(ID);
		double bettingAmount;
		int chooseNo;
		int[] nb = normalballArray();
		int sum = 0;
		for (int i = 0; i < nb.length; i++) {
			sum += nb[i];
		}

		String oddEven;
		if (sum % 2 == 0) {
			oddEven = "짝";

		} else {
			oddEven = "홀";
		}
		String myOddEven;

		System.out.println("============일반볼 합 홀짝 맞추기==============");
		System.out.println("일반볼(1~28) 5개를 무작위 추첨하고 5개 일반볼의 합이 홀수일지 짝수일지 맞추는 게임입니다.");
		System.out.printf("베팅 한도 > %13.3f\n", maxBettingAmount);
		while (true) {
			System.out.print("베팅할 금액>");
			bettingAmount = Double.parseDouble(scanner.nextLine());
			if (bettingAmount > maxBettingAmount) {
				System.out.println("보유하신 포인트보다 베팅 시도 금액이 더 큽니다. 다시 입력하세요.");
			} else {
				System.out.println("베팅 완료 되었습니다.");
				System.out.printf("잔여 포인트> %13.3f\n", (maxBettingAmount - bettingAmount));
				break;
			}
		}
		PowerballAccount pba = pbd.selectAccountInfo(ID);
		pba.setPBAPoint(-bettingAmount);
		pbd.updateAccountPoint(pba);
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("1.홀 2.짝 3.베팅취소 >>>(숫자를 입력하세요)");
			chooseNo = menuSelect1();
			if (chooseNo == 1) {
				System.out.println("홀에 베팅하셨습니다.");
				myOddEven = "홀";
				break;
			} else if (chooseNo == 2) {
				System.out.println("짝에 베팅하셨습니다.");
				myOddEven = "짝";
				break;
			} else if (chooseNo == 3) {
				pba.setPBAPoint(+bettingAmount);
				pbd.updateAccountPoint(pba);
				System.out.println("포인트를 환불합니다.");
				return;
			} else {
				System.out.println("1 혹은 2 혹은 3을 입력하세요");
			}

		}
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.print("일반볼은 (");
		showNormalball(nb);
		System.out.print(") 이고 + 총 합은 " + sum + "이고 " + oddEven + "입니다. " + ID + "님은 " + myOddEven + "을 선택하셨습니다.\n\n");

		if (oddEven.equals(myOddEven)) {
			System.out.println("축하합니다. 적중하셨습니다.");
			pba.setPBAPoint(1.97 * bettingAmount);
			pbd.updateAccountPoint(pba);
			gr.setWinPrize(1.97 * bettingAmount);
			gr.setIsWin(1);
		} else {
			System.out.println("아쉽습니다. 미적중하셨습니다.");
			gr.setIsWin(0);

		}
		gr.setAccountId(ID);
		gr.setGameNo(4);
		gr.setBettingAmount(bettingAmount);
		gd.insertGameResult(gr);

	}

	// 일반볼 보여주는 for each 메소드
	public void showNormalball(int[] intArray) {
		for (int i : intArray) {
			System.out.print(i + " ");
		}
	}

	// 일반볼 합 언오버 맞추기
	public void normalballGame2() {
		GameResult gr = new GameResult();
		double maxBettingAmount = pbd.selectAccountPoint(ID);
		double bettingAmount;
		int chooseNo;
		int[] nb = normalballArray();
		int sum = 0;
		for (int i = 0; i < nb.length; i++) {
			sum += nb[i];
		}
		String unov;
		if (sum < 73) {// 언더
			unov = "언더";
		} else {// 오버
			unov = "오버";
		}
		String myUnov;

		System.out.println("============일반볼 합 언오버 맞추기==============");
		System.out.println("일반볼(1~28) 5개를 무작위 추첨하고 5개 일반볼의 합이 언더(13~72)일지 오버(73~130)일지 맞추는 게임입니다.");
		System.out.printf("베팅 한도 >%13.3f\n", maxBettingAmount);
		while (true) {
			System.out.print("베팅할 금액>");
			bettingAmount = Double.parseDouble(scanner.nextLine());
			if (bettingAmount > maxBettingAmount) {
				System.out.println("보유하신 포인트보다 베팅 시도 금액이 더 큽니다. 다시 입력하세요.");
			} else {
				System.out.println("베팅 완료 되었습니다.");
				System.out.printf("잔여 포인트> %13.3f\n", (maxBettingAmount - bettingAmount));
				break;
			}
		}
		PowerballAccount pba = pbd.selectAccountInfo(ID);
		pba.setPBAPoint(-bettingAmount);
		pbd.updateAccountPoint(pba);
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("1.언더 2.오버 3.베팅취소 >>>(숫자를 입력하세요)");
			chooseNo = menuSelect1();
			if (chooseNo == 1) {
				System.out.println("언더에 베팅하셨습니다.");
				myUnov = "언더";
				break;
			} else if (chooseNo == 2) {
				System.out.println("오버에 베팅하셨습니다.");
				myUnov = "오버";
				break;
			} else if (chooseNo == 3) {
				pba.setPBAPoint(+bettingAmount);
				pbd.updateAccountPoint(pba);
				System.out.println("포인트를 환불합니다.");
				return;
			} else {
				System.out.println("1 혹은 2 혹은 3을 입력하세요");
			}

		}

		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.print("일반볼은 (");
		showNormalball(nb);
		System.out.print(") 이고 + 총 합은 " + sum + "이고 " + unov + "입니다. " + ID + "님은 " + myUnov + "을 선택하셨습니다.\n\n");

		if (unov.equals(myUnov)) {
			System.out.println("축하합니다. 적중하셨습니다.");
			pba.setPBAPoint(1.97 * bettingAmount);
			pbd.updateAccountPoint(pba);
			gr.setWinPrize(1.97 * bettingAmount);
			gr.setIsWin(1);
		} else {
			System.out.println("아쉽습니다. 미적중하셨습니다.");
			gr.setIsWin(0);

		}
		gr.setAccountId(ID);
		gr.setGameNo(5);
		gr.setBettingAmount(bettingAmount);
		gd.insertGameResult(gr);

	}

	// 충전하기
	public void chargePoint() {
		int accountNo;
		long money;
		long isTransfered;
		int chooseNo;
		Account accountUser;
		Account accountAdmin = ad.selectAccountInfo(1);
		PowerballAccount pba = pbd.selectAccountInfo(ID);
		System.out.println("============ 충전하기 ==============");
		System.out.println("관리자 계좌번호는 1입니다. 반드시 관리자 계좌번호로 입금해야 합니다.");
		System.out.println("입금 신청계좌와 입금신청액과 입금액이 모두 일치해야 포인트 충전이 됩니다 반드시 확인하세요.");
		System.out.println("다른 계좌로 입금하거나 잘못 입금하거나 입금금액이 정확하게 일치하지 않으면 충전이 불가하고 입금액은 환불 불가능하니 정확히 확인하세요");
		System.out.println("본인의 입금 신청 계좌를 입력하세요>>");
		accountNo = Integer.parseInt(scanner.nextLine());
		accountUser = ad.selectAccountInfo(accountNo);
		System.out.print("입금신청액을 입력하세요>");
		money = Long.parseLong(scanner.nextLine());
		System.out.print("입금을 취소하시려면 9, 입금을 계속하시려면 9를 제외한 숫자를 입력해주세요>\n");
		chooseNo = Integer.parseInt(scanner.nextLine());
		if (chooseNo == 9) {
			return;
		} else {
			System.out.println("은행 페이지로 접속하셨습니다. 계좌이체를 시작합니다. 본인 계좌번호를 입력하세요.");
			isTransfered = af.transfer1(accountUser, money, accountAdmin);
			if (isTransfered == 1) {
				pba.setPBAPoint((double) money);
				pbd.updateAccountPoint(pba);
				System.out.println("포인트 충전이 정상 처리되었습니다.");

			} else {
				System.out.println("포인트 충전이 정상 처리되지 않았습니다. 입금신청계좌, 관리자계좌, 입금신청액을 다시 확인하세요");
			}

		}

	}

	// 출금하기
	public void withdraw() {
		double maxBettingAmount = pbd.selectAccountPoint(ID);
		long withdrawAmount;
		int i;

		System.out.println("============ 출금하기 ==============");
		System.out.printf("출금 한도(회원님이 가지고 계신 포인트) > 13.3f\n", maxBettingAmount);
		// 출금
		while (true) {
			System.out.print("출금할 금액>");
			withdrawAmount = Long.parseLong(scanner.nextLine());
			if (withdrawAmount > maxBettingAmount) {
				System.out.println("보유하신 포인트보다 신청한 출금 금액이 더 큽니다. 다시 입력하세요.");
			} else {
				// 계좌번호를 입력받고 계좌번호가 은행에 존재하는지 안하는지 체크

				outer: while (true) {
					Account user = af.checkAccountNo(af.inputAccountNo());
					if (user != null) {
						PowerballAccount pba = pbd.selectAccountInfo(ID);
						pba.setPBAPoint(-withdrawAmount);
						pbd.updateAccountPoint(pba);

						// 회원에 입금
						af.depositPoint(user, withdrawAmount);

						// 관리자 계좌 출금
						Account accountAdmin = ad.selectAccountInfo(1);
						af.withdrawPoint(accountAdmin, withdrawAmount);

						System.out.println("출금 완료했습니다.");
						System.out.printf("잔여 포인트> %13.3f\n ",(maxBettingAmount - withdrawAmount));
						break;
					}
					if (user == null) {
						System.out.println("출금을 그만 두시려면 9를 입력, 계속 계좌번호를 입력하시려면 9를 제외한 숫자를 입력하세요");
						i = Integer.parseInt(scanner.nextLine());
						if (i == 9) {
							break outer;
						}
					}

				}

				break;
			}
		}

	}

	// 본인 포인트 확인
	public void checkPoint() {

		System.out.println("본인 포인트 확인");
		System.out.printf(ID + "님이 현재 가지고 계신 포인트는 %13.3f입니다.\n", pbd.selectAccountPoint(ID));
	}

	// 관리자 메뉴
	// 메뉴1 모든게임결과확인
	public void adminMenu1() {
		System.out.println("===================== 모든 게임 결과 확인 ========================");
		List<GameResult> list = new ArrayList<GameResult>();
		list = gd.selectAllGameResult();
		for (GameResult gr : list) {
			System.out.println(gr);
		}

	}

	// 메뉴2 게임별결과출력
	public void adminMenu2() {
		int chooseNo;
		System.out
				.println("===================== 게임별 결과 확인 ===========================================================");
		System.out.println("1.파워볼 맞추기| 2.파워볼 홀짝 맞추기 | 3.파워볼 언오버 맞추기 | 4.일반볼 합 홀짝 맞추기 | 5.일반볼 합 언오버 맞추기 |");
		System.out.print("보고싶은 게임별 결과의 게임 번호를 입력하세요>");
		while (true) {
			chooseNo = menuSelect();
			if (chooseNo < 6) {
				break;
			} else {
				System.out.println("1부터 5까지 중 하나의 숫자를 입력하세요");
			}
		}

		List<GameResult> list = new ArrayList<GameResult>();
		list = gd.selectGameResultsbyGames(chooseNo);
		for (GameResult gr : list) {
			System.out.println(gr);
		}

	}

	// 메뉴3 회원별게임결과출력
	public void adminMenu3() {
		String accountId;
		PowerballAccount pba = null;
		List<GameResult> list = new ArrayList<GameResult>();
		System.out.println("===================== 회원 ID별 게임 결과 조회 ===================================================");
		while (true) {
			System.out.print("조회할 ID를 입력하세요>");
			accountId = scanner.nextLine();
			pba = pbd.selectAccountInfo(accountId);
			if (pba != null) {
				list = gd.selectGameResultsbyId(accountId);
				for (GameResult gr : list) {
					System.out.println(gr);

				}
				break;
			} else {
				System.out.println("등록된 ID가 아닙니다. 회원별 결과 출력을 그만하시려면 9를 계속하시려면 다른 숫자를 입력하세요");
				int i = menuSelect();
				if (i == 9) {
					break;
				}
			}
		}

	}

	// 메뉴4 회원리스트보기
	public void adminMenu4() {
		System.out.println("===================== 전체 회원 리스트 보기 ===================================================");
		List<PowerballAccount> list = new ArrayList<PowerballAccount>();
		list = pbd.selectAll();
		for (PowerballAccount pba : list) {
			System.out.println(pba);
		}

	}

}
