package CodeUp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//재귀함수 피보나치
public class _1916 {
	
	public static long method(long N, Map<Long, Long> map) {
		
		if(map.containsKey(N)) {
			return map.get(N);
		}
		else if(N <= 2) {
			return 1;
		}
		else {
			long value = method(N-2, map)+method(N-1, map);
			map.put(N, value);
			return value%10009;
		}
			
	}
	// 1 1 2 3 5 8 13 21 34
	public static void main(String[] args) {
		
		Map<Long, Long> map = new HashMap<>(); // 중복제거
		
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long result = method(N, map);
		System.out.println(result);
		
		sc.close();
	}
}
