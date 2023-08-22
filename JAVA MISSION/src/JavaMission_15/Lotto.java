package JavaMission_15;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lotto { // 실제로 사용하는 코드 만들기

public static void main(String[] args) {
	LottoBoard board = LottoBoard.getInstance(); //싱글톤 패턴 구현
	
	List<Integer> lottoList = new ArrayList<>();
	List<Integer> result = new ArrayList<>();
	List<String> isAuto = new ArrayList<>();
	List<Integer> A_S = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	

	System.out.print("몇 게임? ");
	int N = sc.nextInt();
	
	if(N>=6) { 
		System.out.println("최대 5게임까지만 가능합니다.");
	}
	else {
	// 게임 번호 선택하는 부분
	for(int i = 0; i < N; i++) {
	System.out.print("[" + (i+1) + "] 게임 ");
	System.out.print("(1.자동 / 2.수동) : ");
	int Auto = sc.nextInt();
	
	A_S.add(Auto);
	
	switch(Auto) {
	case 1 : // 자동
		board.resetNumbers();
		lottoList = board.getNumbers();
		System.out.println(lottoList);
		
		result.addAll(lottoList);
		break;
		
	case 2 : // 수동
		List<Integer> numbers2 = new ArrayList<>();
		int n = 1;
	        for(int y=0; y<6; y++) {
				char circleNumber = (char) (0x245F + n++);
		
				System.out.print(circleNumber + " : ");
			
		        int value = sc.nextInt();
		        numbers2.add(value);
	        }
			Collections.sort(numbers2);
			   	
			System.out.println(numbers2.subList(0, 6));
			result.addAll(numbers2);
		break;
	}
}
	// 로또 용지 부분
	System.out.println("########## 인생역전 Lottoria ##########");
	board.Date(); // 발행일 + 추첨일 + 지급기한
	
	System.out.println("-------------------------------------");

	char ch = 'A';
      for (int z = 0; z < N; z++) {
         System.out.print(ch++ + " ");
         List<Integer> check = result.stream().skip(z * 6).limit(6).collect(Collectors.toList());
         if(A_S.get(z) == 1) {
            System.out.println("[자동] " + check);
         } else {
            System.out.println("[수동] " + check);
         }
         // 자동인지 수동인지
      }
	
	System.out.println();	
	
	System.out.println("-------------------------------------");
    System.out.print("금액");

    int money = 1000 * N;
    DecimalFormat df = new DecimalFormat("###,###");
    String money2 = df.format(money);
    System.out.print("                           ￦" + money2);

    System.out.println();
    System.out.println();
    System.out.println("#####################################");
	
	// 당첨번호 출력
	System.out.print("당첨 번호 : ");
	List<Integer> Winning = new ArrayList<>();
	Winning = board.winNumber();
	System.out.println();
	
	// 보너스 번호 출력
	System.out.print("보너스 번호 : ");
	int bonus = board.bonusNumber();
	System.out.println(bonus);
	
	// 당첨 결과 출력
	System.out.println("############## 당첨 결과 ##############");

	char charc = 'A';
    for (int z = 0; z < N; z++) {
       System.out.print(charc++ + " ");
       
       List<Integer> check = result.stream().skip(z * 6).limit(6).collect(Collectors.toList());
       if(A_S.get(z) == 1) {
          System.out.print("[자동] " + check + " ");
          board.Rank(Winning ,bonus, result);
       } else {
          System.out.print("[수동] " + check  + " ");
      	  board.Rank(Winning ,bonus, result);
       }
}	
	sc.close();	
    System.out.println("####################################");
	}

}
}