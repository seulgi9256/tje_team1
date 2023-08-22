package JavaMission_15;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

// 싱글톤 패턴으로 로또 용지 만들기
public class LottoBoard {
	
	private List<Integer> numbers1 = new ArrayList<>();
	private List<Integer> numbers2 = new ArrayList<>();
	//
//	private List<Integer> userNumber = new ArrayList<>(); // 사용자 로또 번호
//	private char ch; // A,B,C,D,E
//	private String Auto; // 수동 자동 여부
//	private String Win; // 당첨 여부
	
	// 클래스 내부에 static으로 유일한 인스턴스 생성
	private static LottoBoard instance = new LottoBoard();

    // private 생성자 만들기
	private LottoBoard() {
		 generateNumbers(); // 자동
		// Rank(); //당첨번호 조회
	}

	/**
	 * 자동 번호 생성
	 * */
	private void generateNumbers() {
		
		for (int j = 0; j < 6; j++) {
			int rand = (int) (Math.random() * 45 + 1);

			if (numbers1.contains(rand)) {
				j--;
			}
			else {
				numbers1.add(rand);
			}
		}
			// 정렬
			Collections.sort(numbers1);
	}
	
	public List<Integer> getNumbers1() {
		return numbers1;
	}

	public void setNumbers1(List<Integer> numbers1) {
		this.numbers1 = numbers1;
	}

	//로또 번호 1회당 6개 랜덤 발생 수
    public List<Integer> getNumbers() {
        return numbers1.subList(0, 6);
    }
	
    /**
      * 당첨 번호 생성
     */
    public List<Integer> winNumber() {
       for (int i = 0; i < 6; i++) {
          int random = (int) (Math.random() * 45 + 1);

          if (numbers2.contains(random)) {
            i--;
         }
         else {
            numbers2.add(random);
         }
      }
       Collections.sort(numbers2);
       for (Integer integer : numbers2) {
         System.out.print(integer + " ");
      }
       
       return numbers2;
    }

    /**
      * 보너스 번호 생성
     */
    public int bonusNumber() {
       int random;
        do {
            random = (int) (Math.random() * 45 + 1);
        } while (numbers2.contains(random));

//        System.out.print(random);
        return random;
    }

	/**
	 * 당첨 번호 조회
	 * */
	void Rank(List<Integer> winningNumber, int bonus, List<Integer> userNumber) {
//		int[] winningNumber = {14, 19, 24, 29, 36, 42};
//		int bonusNumber = 45;
		
		int MatchedNumber = count(winningNumber, userNumber);
		boolean hasBonusNumber = check(winningNumber, bonus, userNumber);
		
		if(MatchedNumber==6) {
			System.out.println("(1등)");
		}
		else if(MatchedNumber==5 && hasBonusNumber) {
			System.out.println("(2등)");
		}
		else if(MatchedNumber==5) {
			System.out.println("(3등)");
		}
		else if(MatchedNumber==4) {
			System.out.println("(4등)");
		}
		else if(MatchedNumber==3) {
			System.out.println("(5등)");
		}
		else{
			System.out.println("(낙첨)");
		}
	}
	
	public int count(List<Integer> winningNumber, List<Integer> userNumber) {
		int count = 0;
		for (int i : userNumber) {
			if(winningNumber.contains(userNumber)) {
				count++;
			}
		}
		return count;
	}
	
	public boolean check(List<Integer> winningNumber, int bonusNumber, List<Integer> userNumber ) {
		return winningNumber.contains(bonusNumber);
	}

	/**
	 * 날짜 생성
	 * */
	public void Date() { // 발행일
		Date cd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd일 (E) HH:mm:ss");
		String now = sdf.format(cd);
		System.out.println("발행일 \t : " + now);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(cd);
		
		int currentDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int daysUntilNextSaturday = Calendar.SATURDAY - currentDayOfWeek;
		if(daysUntilNextSaturday < 0) {
			daysUntilNextSaturday += 7; // 다음주로 이동
		}
		cal.add(Calendar.DAY_OF_MONTH, daysUntilNextSaturday);
		cal.set(Calendar.HOUR_OF_DAY, 21);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		String date = sdf.format(cal.getTime());
		System.out.println("추첨일 \t : " + date);
		
		SimpleDateFormat date2 = new SimpleDateFormat("yyyy/MM/dd일 (E)");
		LocalDateTime pd = LocalDateTime.now();
		LocalDateTime targetTime = pd.plusYears(1).plusDays(1); // 1년과 1일 후의 LocalDateTime 계산
		Date targetDate = Date.from(targetTime.atZone(ZoneId.systemDefault()).toInstant()); // LocalDateTime을 Date로 변환
		String targetdate = date2.format(targetDate); // 포맷팅
		System.out.println("지급기한 \t : " + targetdate);
	}
	
	public void resetNumbers() {
		numbers1.clear();
		generateNumbers();
	}

	// 외부에서 참조할 수 있는 pulic 메소드 정의
	public static LottoBoard getInstance() {
		if(instance == null) {
			instance = new LottoBoard();
		}
		return instance;
	}
}