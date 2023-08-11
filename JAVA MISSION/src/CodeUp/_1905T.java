package CodeUp;

import java.util.Scanner;

public class _1905T {
	public static int method(int N) {
		if(N == 0) return 0;
		
		return N + method(N-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = method(N);
		System.out.println(result);
		
		sc.close();
	}
}
