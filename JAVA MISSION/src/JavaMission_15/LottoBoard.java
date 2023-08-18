package JavaMission_15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 싱글톤 패턴으로 로또 용지 만들기
public class LottoBoard {

	// 클래스 내부에 static으로 유일한 인스턴스 생성
	private static LottoBoard instance = new LottoBoard(Auto);
	
	private List<Integer> numbers;
	private boolean Auto;
	
	private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_PER_TICKET = 6;
	
	private LottoBoard(boolean Auto) { // private 생성자 만들기
		this.Auto = Auto;
		if(Auto) {
			generateNumbers(); // 자동
		}
		else {
			Manually();//수동
		}
		Rank(); //당첨번호 조회
			}
	
	
	public LottoBoard(List<Integer> numbers, boolean auto) {
		super();
		this.numbers = numbers;
		Auto = auto;
	}

	public boolean isAuto() {
		return Auto;
	}

	/**
	 * 자동 번호 생성
	 * */
	private void generateNumbers() {
	   numbers = new ArrayList<>();
	
	   for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
	        numbers.add(i);
	   }
	   	Collections.shuffle(numbers);
	}
	
	/**
	 * 수동 번호 생성
	 * */
	private void Manually() {
		
	}
	
	/**
	 * 당첨 번호 조회
	 * */
	private void Rank() {
		
	}
	    public List<Integer> getNumbers() {
	        return numbers.subList(0, NUMBERS_PER_TICKET);
	    }

	/**
	 * 날짜 생성
	 * */
	
	// 외부에서 참조할 수 있는 pulic 메소드 정의
	public static LottoBoard getInstance() {
		if(instance == null) {
			instance = new LottoBoard(false);
		}
		return instance;
	}
}