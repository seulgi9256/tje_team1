package JavaMission_29;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _29 {
	
	public static void main(String[] args) {
		Map<String, String> hash = new HashMap<>();
	
		System.out.print("입력한 단어 수 : ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		
		while(count<N) {
			System.out.print(">>한글 : ");
			String str1 = sc.next();
			System.out.print(">>영어 : ");
			String str2 = sc.next();
			
			hash.put(str1, str2);
			
			count++;
		}
		
		while(true) {
			System.out.print("검색할 단어 : ");
			String search = sc.next();
			
			if(hash.containsKey(search)) {
				String result = hash.get(search);
				System.out.println(">> '" + search + "' 은 영어로 '" + result +"' 입니다.");
			}
			else {
				System.out.println("종료합니다.");
				break;
			}
		}
		sc.close();
	}

}
