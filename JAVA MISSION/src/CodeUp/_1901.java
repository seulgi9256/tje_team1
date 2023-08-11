package CodeUp;

import java.util.Scanner;

public class _1901 {
	
	public static void method(int N) {
		if(N==0) return;
		
		method(N-1);
		System.out.println(N);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		method(N);
		
		sc.close();
	}

}
