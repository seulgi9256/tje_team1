package _30;

import java.util.Scanner;

public class StringCalculator {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		String[] sp = str.split("");
		for (int i = 0; i < sp.length; i++) {
			System.out.println(i + " \t" + sp[i]);
		}
		
		String operator = " ";
		
		str.substring(str.indexOf("("), str.indexOf(")")+1);

	}

}
