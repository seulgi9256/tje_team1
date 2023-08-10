package JavaMission_12;

public class Account {
    // 잔고 직접 지정과 입금 및 출금은 허용된 금액 범위에서만 적용 가능

    String accountNumber;
    String accountholder;
    int balance;
    String password;

    final int MIN_BALANCE = 0;
    final int MAX_BALANCE = 1000000000; // 10억원
    final int MIN_TRANSFER = 1;
    final int MAX_TRANSFER = 1000000; // 100만원

    public Account() {
        this("계좌없음", "이름없음", 0);
    }

    public Account(String accountNumber, String accountholder, int balance) {
        this.accountNumber = accountNumber;
        this.accountholder = accountholder;
        this.balance = balance;
    }

    public Account(String accountNumber, String accountholder, int balance, String password) {
        this.accountNumber = accountNumber;
        this.accountholder = accountholder;
        this.balance = balance;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountholder() {
        return accountholder;
    }

    public void setAccountholder(String accountholder) {
        this.accountholder = accountholder;
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
    
    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", accountholder=" + accountholder + ", balance=" + balance
                + ", password=" + password + ", MIN_BALANCE=" + MIN_BALANCE + ", MAX_BALANCE=" + MAX_BALANCE
                + ", MIN_TRANSFER=" + MIN_TRANSFER + ", MAX_TRANSFER=" + MAX_TRANSFER + "]";
    }

    public int deposit(int deposit){
        if(balance>MAX_BALANCE) {
            System.out.println("하나의 계좌에 10억원 이상 예금 할 수 없습니다.");
            return 0;
        }
        else {
        	return balance += deposit;
        }
    }

    public int withdraw(int withdraw){
    	int check = 0;
        if(balance<withdraw) {
            System.out.println("잔고가 부족합니다.");
            return 0;
        }
        else{
            check = 1;
            return balance -= withdraw;
        }
    }
}
