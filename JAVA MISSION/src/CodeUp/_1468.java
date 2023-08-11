package CodeUp;

import java.util.Scanner;

public class _1468 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력
		
		int num = 1;
		int arr[][] = new int[N][N];
		int sw=1;
		
		for (int i = 0; i < arr.length; i++) {
				// 짝수
				if(sw==1) {
					for(int k=0; k<N; k++) {
						arr[i][k]=num;
						num++;
					}
					sw=0;					
				}
				
				// 홀수
				else{
					for(int l=N-1; l>=0; l--) {
						arr[i][l]=num;
						num++;
					}
					sw=1;
				}
				
		}
		
		//2차원 배열 출력
		for (int a = 0; a < arr.length; a++) {
			for (int j = 0; j < arr[a].length; j++) {
				System.out.print(arr[a][j] + " ");
		}			
		System.out.println();
		sc.close();
		}
		
	}
	
}


		

