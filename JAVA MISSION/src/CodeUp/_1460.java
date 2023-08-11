package CodeUp;

import java.util.Scanner;

public class _1460 {

	public static void main(String[] args) {
		// n*n 배열 출력
		// 1부터 순서대로

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력
		
		int num = 1;
		int arr[][] = new int[N][N];
				
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num;
				num++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();

		}		
		System.out.println();
		sc.close();
	}

}
