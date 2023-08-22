package JavaMission_08;

import java.util.Scanner;

public class _8 {
	public static void main(String[] args) {
        // 정수 N을 입력받아
        // N행 N열의 2차원 배열을 선언
        // 배열 요소의 1부터 1씩 증가하는 값을 순서대로 저장
        // 1행이 증가할 때마다 배열요소에 접근하는 방향을 반대로 하여 값을 저장하고 출력
        // 지그재그

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 1;

        int arr[][] = new int[N][N];

        for (int i = 0; i < arr.length; i++) {

                if(i%2==0) {
                    for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = num;
                    num++;
                    }
                }

                else if(i%2==1) {
                    for (int j = arr.length-1; j>=0; j--) {
                    arr[i][j] = num;
                    num++;

                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }

        System.out.println();
        sc.close();
 
    }
        }
}
