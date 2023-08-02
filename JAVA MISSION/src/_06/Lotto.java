package _06;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// Math.random() : 0.xxxxx ~ 0.9xxxxx 사이의 임의 수를 반환
		
		 
		// 1~45 사이의 랜덤 한 정수
		// Math.random()					: 0.0xxxx ~ 0.9xxxxx
		// Math.random() * 10				: 0.xxxxx ~ 9.xxxxx
		// Math.random() * 10 + 1			: 1.xxxxx ~ 10.xxxxx
		// (int) (Math.random() * 10 + 1)	: 1 ~ 10
		
		// Math.random() * 45				: 0.0xxxxx ~ 44.xxxxx
		// Math.random() *45 + 1			: 1.0xxxxx ~ 45.xxxxx
		// (int) (Math.random() * 45 + 1)	: 1 ~ 45
		
		// (공식)
		// (int) (Math.random() * 10 + 1)	: 1 ~ 10
		// (int) (Math.random() * 45 + 1)	: 1 ~ 45
		
		// (int) (Math.random() * [개수] + [시작숫자]
//		int Lotto_num = (int)(random * 10);
		
//		System.out.println(random);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("게임 횟수 입력 : ");
		int cnt = sc. nextInt();
		
		int lotto[] = new int[6];
		for (int x = 1; x <= cnt; x++) {
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = (int)(Math.random() * 45) + 1;
				System.out.println(i + "----- 첫번째 포문 Start------");
				System.out.print(lotto[i]);
				System.out.println();
				System.out.println(i + "----- 첫번째 포문 End------");
				for (int j = 0; j < i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
					}
					if(lotto[i] < lotto[j]) {
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
					System.out.println(j + "----- 두번째 포문 Start------");
					System.out.print(lotto[j]);
					System.out.println();
					System.out.println(j + "----- 두번째 포문 End------");
				}
			}
			System.out.print(x + "번 게임 : ");
			for (int i = 0; i < lotto.length; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
		}
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("게임 횟수 입력 : ");
//		int num = sc.nextInt();
//		
//		int number[] = new int[num];
//
//		int arr[] = new int[6];
//		
//		for (int i = 0; i < number.length; i++) {
//			System.out.print(i+1 + "번째 게임 : ");
//			for (int j = 0; j < 6; j++) {
//				int result = (int)(Math.random() * 45) + 1;
//				if(number[j] == result) {
//					j--;
//					break;
//				} else {
//					number[j] = result;
////					arr[j] = number[j]; 
//				}
////				Arrays.sort(arr);
//				System.out.print(arr[j] + " ");
//			}
//			System.out.println();
//		}
//		
		
		
//		
//		int number[][] = new int[num][6];
//		
//		for (int i = 0; i < number.length; i++) {
//			System.out.print(i+1 + "번째 게임 : ");
//			for (int j = 0; j < number[i].length; j++) {
//				int result = (int)(Math.random() * 45) + 1;
//				number[i][j] = result;
//				int[][] sort = number[i][j];
//				System.out.print(number[i][j] + " ");
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < number.length; i++) {
////			double random = Math.random();
//			for (int j = 0; j < 6; j++) {
//				int result = (int)(Math.random() * 45) + 1;
//				number[j] = result;
//				
//				if(number[i] == number[j]) {
//					j--;
//					break;
//				}
//				System.out.print(number[j] + " ");
//			}
//			System.out.println();
//		}

	}
	
}
