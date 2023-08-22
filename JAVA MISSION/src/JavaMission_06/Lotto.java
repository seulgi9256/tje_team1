package JavaMission_06;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		
		System.out.print("몇 게임? ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int lottoNo[] = new int[6];
		int random =0 ;
		int i, j = 0 ;
		int count = 0;
		
		while(count<N) {
			System.out.print("["+ (count+1) + "게임] : ");
			
			for(i = 0; i<lottoNo.length; i++) {
				
				random = (int) (Math.random()*45) + 1;
				lottoNo[i] = (int) random;
				
//				lottoNo[i] = random;
				
				for(j=0; j<i; j++) {
						if(lottoNo[i]==lottoNo[j]) {
							i--;
						break;
						} 	
				}
			}
								
			//sort
			for(i = 0; i<lottoNo.length; i++) {
				for(j = 0; j < lottoNo.length-1; j++) {
					if(lottoNo[j]>lottoNo[j+1]) {
						int min = lottoNo[j+1];
						lottoNo[j+1] = lottoNo[j];
						lottoNo[j] = min;
					}
				}
			}	
			
			// 출력
			for (i = 0; i < lottoNo.length; i++) {
				System.out.print(lottoNo[i] + " ");
			}	
			System.out.println();
			count++;;
	}
			sc.close();					
}
	}