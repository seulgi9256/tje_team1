package JavaMission_07;

import java.util.Scanner;

public class Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input;
		int arr[] = new int[5];
		int arr2[] = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			input = sc.nextInt();
			arr[i] = input;
			arr2[i] = input;
		}
		 
		// 선택정렬 
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// 오름차순
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				// 내림차순
				if(arr2[i] < arr2[j]) {
					int temp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = temp;
				}
			}
		}
//		// 버블정렬
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length - 1; j++) {
//				// 오름차순
//				if(arr[j] > arr[j+1]) {
//					int temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//				// 내림차순
//				if(arr2[j] < arr2[j+1]) {
//					int temp = arr2[j];
//					arr2[j] = arr2[j+1];
//					arr2[j+1] = temp;
//				}
//			}
//		}
//		// 삽입정렬
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i; j > 0; j--) {
//				// 오름차순
//				if(arr[j-1] > arr[j]) {
//					int temp = arr[j];
//					arr[j] = arr[j-1];
//					arr[j-1] = temp;
//				}
//				// 내림차순
//				if(arr2[j-1] < arr2[j]) {
//					int temp = arr2[j];
//					arr2[j] = arr2[j-1];
//					arr2[j-1] = temp;
//				}
//			}
//		}
		
		// 출력
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
}
