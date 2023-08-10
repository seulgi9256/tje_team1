package JavaMission_04;

import java.util.Scanner;

public class _4 {
	public static void main(String[] args) {
		// 정수 하나를 입력 받아, 정수형 변수 N에 초기화시키고
		// *을 1 3 5 7 9로 출력
		int num = 1;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		

		for(int i = 0; i < N; i++) {
			
			for(int j=0; j<num; j++) {
				System.out.print("*");
			}
			num +=2;
			System.out.println();
		}
		sc.close();	 

	}
}
