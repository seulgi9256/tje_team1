package CodeUp;

import java.util.Scanner;

public class _1408 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String pwd = sc.next();
		int temp1;
		int temp2;
		char[] result = new char[20];
		
		for (int i = 0; i < pwd.length(); i++) {
			temp1 = pwd.charAt(i);
			temp1+=2;
			result[i] = (char) temp1;
			System.out.print(result[i] + "");
		}
			System.out.println();
		
		for (int i = 0; i < pwd.length(); i++) {
			temp2 = pwd.charAt(i);
			temp2 = (temp2*7)%80+48;
			result[i] = (char) temp2;
			System.out.print(result[i] + "");
		}
		sc.close();
	}
}
