package JavaMission_28;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/*
정수를 다루는 Vector 컬렉션을 생성하고 활용하는 프로그램을 <실행결과> 을 참고하여 완성하시오.
( 단, 반복이 필요한 경우 Iterator 를 이용하시오. )
벡터 요소 수 : 5
10 20 30 40 50
요소 수 : 5
벡터 용량 : 10
총합 : 150
 */
public class VectorCollection {
	
	public static void main(String[] args) {
		
		Vector<Integer> vector = new Vector<>(10);
		
		System.out.print("벡터 요소 수 : ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int value = 10;
		
		for (int i = 0; i < N; i++) {
			vector.add(value);
			value += 10;
		}

		// 요소 출력
		Iterator<Integer> it = vector.iterator();
		
		while( it.hasNext() ) {
			Integer result = it.next();
			System.out.print(result + " ");
		}
		System.out.println();

		System.out.println("요소 수 : " + vector.size());
		System.out.println("벡터 용량 : " + vector.capacity());
		
		// 요소 총합
		int sum = 0;
		for (int i = 0; i < vector.size(); i++) {
			sum += vector.get(i);
		}
		
//		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
//			String item = (String) iterator.next();
//			System.out.println("item" + ++i + " : " + item);
//		}
		
		System.out.println("총합 : " + sum);
		sc.close();

	}

}
