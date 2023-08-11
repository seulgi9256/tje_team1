package CodeUp;

import java.util.Scanner;

public class _1228 {

	public static void main(String[] args) {
		// 비만도 측정하기
		
		Scanner sc = new Scanner(System.in);
	//	System.out.println("키와 몸무게를 입력하세요.");
	
	//	System.out.print("키 : ");
		double height = sc.nextDouble();
		
	//	System.out.print("몸무게 : ");
		double weight = sc.nextDouble();
		
		double avg_weight = (height-100)*0.9;
		double score = (weight-avg_weight)*100/avg_weight;
		/*
		System.out.println("표준몸무게 : " + avg_weight);
		System.out.println("비만도 : " + score);
		*/
		if(score<=10)
			System.out.println("정상");
		else if(score>10 && score<=20)
			System.out.println("과체중");
		else if(score>20)
			System.out.println("비만");

		sc.close();

	}

}
