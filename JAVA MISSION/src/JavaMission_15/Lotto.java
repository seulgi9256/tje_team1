package JavaMission_15;

import java.util.Scanner;

public class Lotto { // 실제로 사용하는 코드 만들기
	
	public static void main(String[] args) {
		LottoBoard board = LottoBoard.getInstance(); //싱글톤 패턴 구현
		
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임? ");
		int N = sc.nextInt();
		
		// 게임 번호 선택하는 부분
		for(int i = 0; i < N; i++) {
		System.out.print("[" + (i+1) + "] 게임 ");
		System.out.print("(1.자동 / 2.수동) : ");
		int Auto = sc.nextInt();
		//board.isAuto();
		switch(Auto) {
		case 1 : // 자동
			
			break;
		case 2 : // 수동
			for (int j = 0; j < 6; j++) {
				
			}
			
			break;
		}
		}
		
		// 로또 용지 부분
		System.out.println("########## 인생역전 Lottoria ##########");
		System.out.println("발행일  \t : "); //날짜);
		System.out.println("추첨일  \t : ");
		System.out.println("지급기한 \t : ");
		System.out.println("-------------------------------------");
		
		char ch = 'A';
		for (int i = 0; i < N; i++) {
			System.out.print(ch++ + " ");
			// 자동인지 수동인지 
			System.out.println(board.getNumbers()); // 싱글톤클래스에서 번호 가져오기
			
		}
		
		System.out.println("-------------------------------------");
		System.out.print("금액");
		String money = "1000";
		money = String.format("%,d", money);
		String money2 = Integer.toString(Integer.parseInt(money)*N);
		System.out.print("\\" + money2); //오른쪽 정렬은 어떻게 하지?
		
		System.out.println();
		System.out.println();
		
		// 당첨번호 출력
		
		// 보너스 번호 출력
		
		// 당첨 결과 출력
		ch = 'A';
		System.out.println("############## 당첨 결과 ##############");
		for (int i = 0; i < N; i++) {
			System.out.print(ch++ + " ");
			System.out.print(" "); // 자동 수동 여부
			System.out.print(""); // 위에서 발생한 번호 가져오기
			System.out.println(); // 보드에서 당첨 결과 가지고 오기
		}
		System.out.println("####################################");
		
    }	
		
}
