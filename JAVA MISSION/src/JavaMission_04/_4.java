package JavaMission_04;

import java.util.Scanner;

public class _4 {
	public static void main(String[] args) {
		// 정수 하나를 입력 받아, 정수형 변수 N에 초기화시키고
		// *을 1 3 5 7 9로 출력
		int j = 1;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i=1 ; i <= N; i++) { // 빈칸은 N-1씩
			for(j=N; j > i; j--) {
				System.out.print(" ");
			}
			for(j=1; j < 2*i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
		sc.close();	 
	}
}
