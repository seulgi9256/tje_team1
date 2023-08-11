package CodeUp;

import java.util.Scanner;

public class _1912 {
	public static void mathod(int n, int result) {
		if(n==1) {
			System.out.println(result);
			return;
		}
		mathod(n-1, result*n);
		

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int result = 1;
		
		mathod(n, result);
		sc.close();
	}
}
