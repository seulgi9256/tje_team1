import java.util.Scanner;

public class Exercise07 {
		
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		int DepositMoney = 0;
		int WithdrawMoney = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------");	
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");	
			System.out.println("--------------------------------");	
			System.out.print("선택> ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1 : System.out.println("---------------예금-----------------");
					 System.out.print("예금액> ");
					 DepositMoney = sc.nextInt();
					 System.out.println(DepositMoney + "가 예금되었습니다.");
					 balance += DepositMoney;
				break;
			case 2 : System.out.println("---------------출금-----------------");
					 System.out.print("출금액> ");
					 WithdrawMoney = sc.nextInt();
					 System.out.println(WithdrawMoney + "가 출금되었습니다.");
					 balance -= WithdrawMoney;
				break;
			case 3 : 
				System.out.println("잔고 : " + balance);
			
				break;
			case 4 : run = false;
				break;
			default :
				System.out.println("1~4까지의 숫자를 입력해주세요.");
				break;
			}  
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
}
