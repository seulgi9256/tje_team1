package _10;
import java.util.Scanner;

public class _10 {
/*
솔라 623843
문별 728394
휘인 432942
화사 942783
 */
    public static void main(String[] args) {

        String []arrName = new String[20];
        int []result = new int[100];
        int index1=0;
        int index2=0;
        int index3=1;
        int i = 0;
        int j = 0;
        int k = 0;

        //각 전체 화폐매수
        boolean sw = true;
        int money = 50000; //화폐단위
        int quotient = 0;
        int count = 0;
        int []sum = new int[100];

        //출력
        // 성명, 간식비 지금액, 개인별 각 화폐 매수, 마지막에 전체 화폐 매수
        Scanner sc = new Scanner(System.in);

        while(true) {

        String name = sc.next();
        count++;
        if(name.equals("quit")||name.equals("QUIT")) {
            System.out.println("성명\t"+"출장비\t"+"오만원\t"+"만원\t"+"오천원\t"+"천원\t"+"오백원\t"+"백원\t"+"오십원\t"+"십원\t"+"오원\t"+"일원");
            break;
        }

        arrName[index1] = name;
        index1++;

        int input = sc.nextInt();

        result[index2++] = input;

        if(index2%11==0) {
            input = result[index2];
        }

        while(money>=1) {

            if(sw) {
                quotient = input/money;
                result[index2++] = quotient;

                input = input%money;
                money = money/5;
            }

            else {
                quotient = input/money;
                result[index2++] = quotient;

                input = input%money;
                money = money/2;
            }
            sw=!sw;

        } money = 50000;

    }       

        //출력
            for (i = 0; i < count-1; i++) {
            		System.out.print(arrName[i] + "\t");
            	
                for(j=k; j<k+11; j++) {
                    System.out.print(result[j] + "\t ");    
                }
                k = k+11;
                System.out.println();    
            }

            // 전체 화폐매수 출력
            System.out.print(" 전체 화폐매수 : \t");

            sum[0]=0;
            for(i=0; i<10; i++) { // 화폐 단위
                for(index3=i+1; index3<result.length; index3+=11) {
                    sum[i] += result[index3];
                }
            }

            for(i=0; i<10; i++) {
                System.out.print(sum[i] + "\t");
            }

        System.out.println();
        sc.close();
    }
}