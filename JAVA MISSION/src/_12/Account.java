package _12;

public class Account {
	String accountNumber;
	String accountHolder;
	int balance;
	String password;
	final int MIN_BALANCE = 0;
	final int MAX_BALANCE = 1000000000; //10억
	final int MIN_TRANSFER = 1;
	final int MAX_TRANSFER = 1000000; // 100만원
	
	public Account() {
		this("번호없음", "이름없음", 0, "0000");
	}

	public Account(String accountNumber, String accountHolder, int balance, String password) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 입금
	public void deposit(int deposit) {
		System.out.println("예금액 >> " + deposit);
	}
	
	// 출금
	public void withdrawal(int withdrawal){
		System.out.println("출금액 >> " + withdrawal);
	}
	
	
}
