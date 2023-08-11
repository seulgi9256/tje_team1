package CodeUp;

import java.util.Scanner;

public class _1902 {
	public static void method(int N) {
		if(N==0) return;
		System.out.println(N);
		method(N-1);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		method(N);
		
		sc.close();
	}
}
