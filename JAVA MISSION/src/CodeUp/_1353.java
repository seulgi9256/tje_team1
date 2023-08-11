package CodeUp;

import java.util.Scanner;

public class _1353 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(); // 입력
		
		for(int i=0; i<input; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print("*");
			}				System.out.println();
		}
		sc.close();

	}

}
