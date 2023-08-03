
import java.util.Scanner;
public class _10 {
/*
솔라 623843
문별 728394
휘인 432942
화사 942783
*/
	public static void main(String[] args) {
		String []arr1 = new String[100];
		int []arr2 = new int[2];
		int []result1 = new int[100];
		int index=0;
		
		//각 전체 화폐매수
		boolean sw = true;
		int money = 50000; //화폐단위
		int result = 0;
		
		//출력
		// 성명, 간식비 지금액, 개인별 각 화폐 매수, 마지막에 전체 화폐 매수
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		String name = sc.next();
		
		if(name.equals("quit")||name.equals("QUIT")) {
			System.out.println("성명\t"+"출장비\t"+"오만원\t"+"만원\t"+"오천원\t"+"천원\t"+"오백원\t"+"백원\t"+"오십원\t"+"십원\t"+"오원\t"+"일원");
			break;
		}
		
		int input = sc.nextInt();
		
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = name;
			} //System.out.print(name + " ");
					
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = input;
			} //System.out.println(input);
		
		while(money>=1) {
			if(sw) {
				result = input/money;
				input = input%money;
				money = money/5;
				
			}
			else {
				result = input/money;
				input = input%money;
				money = money/2;
			} sw=!sw;
			result1[index] = result;
			index++;
			
		}
		}
		
		System.out.println();
		sc.close();
	}
		
}

