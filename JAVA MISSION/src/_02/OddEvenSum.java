package _02;

import java.util.Scanner;

public class OddEvenSum {
	public static void main(String[] args) {
		// 정수 하나를 입력 받아, 정수형 변수 N에 초기화시키고
		// 정수 1부터 N까지의 홀수의 합계와 짝수의 합계
		// 그리고 정수 N의 약수를 구하여 예시 <출력>과 같이 출력하는 프로그램을 작성하시오.
		// (1<=N<=100)
		// (입력)
		// 10
		// (출력)
		// 1+3+5+7+9=25
		// 2+4+6+8+10=30 

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum1 = 0;
		int sum2 = 0;
		
		// i : 1 2 3 4 5 6 7 8 9 10
		// 홀수	
		for(int i=1; i<=N; i++) {
			if(i%2==1) {
			System.out.print(i + "+");
			sum1+=i;
			}
		}	
		System.out.println("=" + sum1);
		
		//짝수
		for(int i=1; i<=N; i++) {
			//i : 1 2 3 4 5 6 7 8 9 10
			if(i%2==0) {
			System.out.print(i + "+");
			sum2+=i;
			}
		}
		System.out.println("=" + sum2);
		
		// 약수
		for(int i=1; i<=N; i++) {
			if(N%i==0) {
				System.out.print(i + " ");
			}
		}

		sc.close();
	}
}
