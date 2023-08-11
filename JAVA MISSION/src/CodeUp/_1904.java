package CodeUp;

import java.util.Scanner;

public class _1904 {

	public static void mathod(int a, int b) {
		
		if(a==b+1) return;
		
		if(a%2==1) {
			System.out.print(a + " ");
		}
		mathod(a+1, b);


	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		mathod(a,b);
		
		sc.close();
	}
}
