package CodeUp;

import java.util.Scanner;

public class _1905 {
	
	public static void mathod(int N, int sum) {

		if(N==-1) {
			System.out.println(sum);
			return;
		}
		mathod(N-1, sum+N);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		
		mathod(N, sum);
		sc.close();
	}
}
