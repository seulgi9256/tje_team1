package CodeUp;

import java.util.Scanner;

public class _1207 {

	public static void main(String[] args) {
		// 윷놀이
		Scanner sc = new Scanner(System.in);
	//	System.out.print("입력 : ");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int count=0;
		
		if(a==1) count++;
		if(b==1) count++;
	    if(c==1) count++;
		if(d==1) count++;
		
		
			if(count==0)
				System.out.println("모");
			else if(count==1)
				System.out.println("도");
			else if(count==2)
				System.out.println("개");
			else if(count==3)
				System.out.println("걸");
			else if(count==4)
				System.out.println("윷");
			
		
		sc.close();
				
	}

}
