package JavaMission_15;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Lotto { // 실제로 사용하는 코드 만들기
	
	public static void main(String[] args) {
		LottoBoard board = LottoBoard.getInstance(); //싱글톤 패턴 구현
		
		Date now = new Date();
		LocalDateTime now2 = LocalDateTime.now();
		SimpleDateFormat date = new SimpleDateFormat();
		SimpleDateFormat date2 = new SimpleDateFormat();
		LocalDateTime pd = LocalDateTime.now();
		date = new SimpleDateFormat("yyyy/MM/dd일 (E) HH:mm:ss");
		date2 = new SimpleDateFormat("yyyy/MM/dd일 (E)");
		
		String dataFormat = date.format(now);
		
		LocalDateTime targetTime = pd.plusYears(1).plusDays(1); // 1년과 1일 후의 LocalDateTime 계산
		Date targetDate = Date.from(targetTime.atZone(ZoneId.systemDefault()).toInstant()); // LocalDateTime을 Date로 변환
		String targetdate = date2.format(targetDate); // 포맷팅
		
		// 다음 추첨일을 확인 (매번 다음주 토요일 출력하는 거 같음)
		LocalDateTime nextSaturday = now2.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(21).withMinute(0).withSecond(0);
        String nextdate = date.format(Date.from(nextSaturday.atZone(ZoneId.systemDefault()).toInstant()));
        System.out.println(now2.until(nextSaturday, ChronoUnit.DAYS));

		
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
			if(board.isAuto()) {
				List<Integer> autoNumbers = board.getNumbers(); // 자동 번호 얻기
	            System.out.println("자동 번호: " + autoNumbers);
			}
			break;
		case 2 : // 수동
			for (int j = 0; j < 6; j++) {
				
			}
			
			break;
		}
		}
		
		boolean isAuto = board.isAuto();
        System.out.println("Auto 값: " + isAuto);

		// 로또 용지 부분
		System.out.println("########## 인생역전 Lottoria ##########");
		System.out.println("발행일  \t : " + date.format(now) ); //날짜);
		System.out.println("추첨일  \t : " + nextdate );
		System.out.println("지급기한 \t : " + targetdate );
		System.out.println("-------------------------------------");
		
		char ch = 'A';
		for (int i = 0; i < N; i++) {
			System.out.println(ch++ + " ");
			// 자동인지 수동인지
//			System.out.println(board.getNumbers()); // 싱글톤클래스에서 번호 가져오기
			
		}
		
		System.out.println("-------------------------------------");
		System.out.print("금액");
//		String money = String.format("%,d", Integer.parseInt("1000"));
//		money = String.format("%,d", money);
//		String money2 = Integer.toString(Integer.parseInt(money)*N);
//		System.out.print("\\" + money2); //오른쪽 정렬은 어떻게 하지?
		String moneyFormatted = "1,000";
		String moneyCleaned = moneyFormatted.replace(",", "");
		int moneyInt = Integer.parseInt(moneyCleaned);
		String money2 = Integer.toString(moneyInt * N);
		System.out.print("                             ￦" + money2);
		
		System.out.println();
		System.out.println("#####################################");
		System.out.println();
		
		// 당첨번호 출력
		System.out.println("당첨 번호 : ");
		// 보너스 번호 출력
		System.out.println("보너스 번호 : ");
		
		System.out.println();
		// 당첨 결과 출력
		ch = 'A';
		System.out.println("############## 당첨 결과 ###############");
		for (int i = 0; i < N; i++) {
			System.out.print(ch++ + " ");
			System.out.print(" "); // 자동 수동 여부
			System.out.print(""); // 위에서 발생한 번호 가져오기
			System.out.println(); // 보드에서 당첨 결과 가지고 오기
		}
		System.out.println("#####################################");
		
    }	
		
}