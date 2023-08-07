package _12;

import java.util.Scanner;

public class Bank extends Account {
	static int max = 100;
	static Account[] accountList = new Account[max];
	static Scanner sc = new Scanner(System.in);
	static String adminPassword = "0000";
	
	public static void menu() {
		//메뉴
		System.out.println("====================");
		System.out.println("1. 계좌등록");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 계좌목록");
		System.out.println("6. 종료");
		System.out.println("====================");
	}
	
	// 계좌등록
	public static void join() {
		Account accunt = new Account();
		
		
		System.out.print("계좌번호>> ");
		accountNumber = sc.nextLine();
		sc.nextLine();
		
		System.out.print("예금주>> ");
		accountHolder = sc.nextLine();
		sc.nextLine();
		
		System.out.print("비밀번호>> ");
		password = sc.nextLine();
		sc.nextLine();
		
		System.out.println("'" + accountHolder + "' 님의 계좌가 개설되었습니다.");

	}
	// 입금
	public static void deposit() {
		System.out.println("==========입금==========");
	}
	// 출금
	public static void withdrawal() {
		System.out.println("==========출금==========");
		
	}
	
	// 계좌조회
	public static void search() {
		System.out.println("==========계좌조회==========");
		System.out.print("계좌번호>> ");
		String accountNumber = sc.nextLine();
		System.out.print("비밀번호>> ");
		String password = sc.nextLine();
		
	}
	// 계좌목록
	public static void list() {
		System.out.println("==========계좌목록==========");
		
//		String accountHolder = Account.getAccountHolder(); 
//		String accountNumber = Account.getAccountNumber();
//		int balance = Account.getBalance();
//		
//		System.out.println("예금주 \t" + "계좌번호 \t" + "잔고 \t");
//		System.out.println(acountHolder + "\t" + accountNumber + "\t" + balance+ "\t");
		
	}
	
	public static void main(String[] args) {
		
		int menuNo = 0;			// 메뉴번호
		
		do {
			menu();
			System.out.print("입력 >> ");
			menuNo = sc.nextInt(); 	// 메뉴번호 입력
			sc.nextLine();			// 엔터를 입력버퍼에서 제거
			
			// 프로그램 종료
			if(menuNo == 0) break;
			
			//메뉴선택
			switch (menuNo) {
			case 1 : 	join();// 계좌등록		
						break;
			case 2 : 	deposit();// 입금		
						break;
			case 3 : 	withdrawal();// 출금
						break;
			case 4 : 	search();// 계좌조회
						break;
			case 5 : 	list();//계좌목록
						break;
			default:	System.out.println("(0~6) 사이의 숫자를 입력해주세요.");
						break;
			}
			
		} while (menuNo !=6);
		System.out.println("시스템을 종료합니다.");
	}
		

}
