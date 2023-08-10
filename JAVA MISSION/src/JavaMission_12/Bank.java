package JavaMission_12;

import java.util.Scanner;

public class Bank {
	static int MAX = 1000; // 최대 고객 수
	static Account[] accountList = new Account[MAX];
	static Scanner sc = new Scanner(System.in);
	static String adminPassword ="1111";
	static int index = 0;

	// 메뉴
	public static void menu() {
		System.out.println("===========================================================");
		System.out.println("1. 계좌등록 \n2. 입금 \n3. 출금 \n4. 계좌조회 \n5. 계좌목록 \n6. 종료");
		System.out.println("===========================================================");
	}
	
	// 계좌등록
	public static void joinAccount() {
		Account account1 = new Account();

		
		System.out.print("계좌번호>> ");
		String accountNo = sc.next();
		account1.setAccountNumber(accountNo);
		
		System.out.print("예금주>> ");
		String accountholder = sc.next();
		account1.setAccountholder(accountholder);
		
		System.out.print("최초예금액>> ");
		int deposit = sc.nextInt();
		account1.deposit(deposit);
		
		System.out.print("비밀번호>> ");
		String password = sc.next();
		account1.setPassword(password);
		
		account1 = new Account(accountNo, accountholder, deposit, password);
		accountList[index++] = account1;
		
		System.out.println(account1.getAccountholder() + "님의 계좌가 개설되었습니다.");
	}
	
	// 입금
	public static void deposit() {
		Account account2 = new Account();
		System.out.println("=============================입금===========================");

		System.out.print("계좌번호>> ");
		String accountNo = sc.next();

		System.out.println("체크 : " + accountList[0].accountNumber + " " + accountNo);
		
		for (int i = 0; i < accountList.length; i++) {
			if(accountList[i].accountNumber.equals(accountNo) && accountList[i]!=null) {
				System.out.print("입금액>> ");
				int money = sc.nextInt();
				
				int balance = account2.deposit(money);
				accountList[i].balance=balance;
				
				System.out.println("'" + accountList[i].getAccountholder() +"' 님에게 입금하는게 맞으십니까?");
				System.out.println("1. 예\n2. 아니오");
				System.out.print("입력>> ");
				int input = sc.nextInt();
				
				if(input==1) {
					System.out.println("'" + accountList[i].getAccountholder() + "' 님의 계좌에 " + money + " 원이 입금되었습니다.");
				break;
				}
				else break;
			}
		}
	}
	
	// 출금
	public static void withdraw() {
		Account account3 = new Account(); // 클래스 객체 생성
		int check = 0;
		System.out.println("=============================출금===========================");
		
		System.out.print("계좌번호>> ");
		String accountNo = sc.next();
		
		System.out.println("체크 : " + accountList[0].accountNumber + " " + accountNo);
		
		for (int i = 0; i < accountList.length; i++) {
			if(accountList[i].accountNumber.equals(accountNo) && accountList[i]!=null) {
				System.out.print("비밀번호>> ");
				String password = sc.next();
				
				if(accountList[i].password.equals(password)) {
					System.out.print("출금액>> ");
					int money = sc.nextInt();
					
					int balance = account3.withdraw(money);
					accountList[i].balance=balance;
					
					if(check==1) {
					System.out.println("'" + accountList[i].getAccountholder() + "' 님의 계좌에 " + money + " 원이 출금되었습니다.");
					break;
					}
					else break;
				}
			
				else {
					System.err.println("비밀번호가 다릅니다!");
					break;
				}
			}
		}
	}
		
	
	// 계좌조회
	public static void searchAccount() {
		System.out.println("============================계좌조회==========================");
		System.out.print("계좌번호>> ");
		String accountNo = sc.next();
		
		for (int i = 0; i < accountList.length; i++) {
			if(accountList[i].accountNumber.equals(accountNo) && accountList[i]!=null) {
				System.out.print("비밀번호>> ");
				String password = sc.next();

				if(accountList[i].password.equals(password)) {
					System.out.println("'" + accountList[i].accountholder  + "' 님의 계좌잔액은 " + accountList[i].balance + " 원 입니다.");
					break;
				}
				else break;
			}
		}
	}
	
	// 계좌목록
	public static void AccountList() {
		System.out.print("관리자 비밀번호>> ");
		String admpw = sc.next();
		
		if(admpw.equals(adminPassword) && adminPassword!=null) {
			System.out.println("============================계좌목록==========================");
			System.out.println("예금주\t계좌번호\t잔고\t");
			
			for (int i = 0; i < accountList.length; i++) {
				if(accountList[i]==null) break;
				System.out.println(accountList[i].accountholder + "\t" + accountList[i].accountNumber + "\t" + accountList[i].balance);
			}
		}
	}
	
	// 프로그램 실행
	public static void main(String[] args) {
		int input = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
			menu();
			
			System.out.print("입력>> ");
			input = sc.nextInt();
			
			if(input==6) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
			
			switch(input) {
				case 1: joinAccount();
					break;
				case 2 : deposit();
					break;
				case 3 : withdraw();
					break;
				case 4 : searchAccount();
					break;
				case 5 : AccountList();
					break;
				default :
					System.out.println("(0~6) 사이의 숫자를 입력해주세요");
			}
		} while(input!=6);

		sc.close();
}
}

