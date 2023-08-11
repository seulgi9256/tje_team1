package CodeUp;

import java.util.Scanner;

public class _1066 {

	public static void main(String[] args) {
		// 세 정수를 입력받아 홀/짝 표시
		Scanner sc = new Scanner(System.in);
//		System.out.print("세 정수를 입력 : ");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String result1 = a%2==0 ? "even" : "odd";
		String result2 = b%2==0 ? "even" : "odd";
		String result3 = c%2==0 ? "even" : "odd";
				
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	
		sc.close();
	}

}
