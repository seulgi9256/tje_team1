package JavaMission_14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ArrayListLotto {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        Random random = new Random();
	        ArrayList<Integer> list = new ArrayList<Integer>(6);

	        System.out.print("몇 게임? ");
	        int N = sc.nextInt();
	        int i = 1;
	        int count = 0;

	        while(count<N) {

	        System.out.print("[" + (i++) + "게임] ");

	        while(list.size()!=6) {
	            int number = random.nextInt(45) + 1;
	            if(!list.contains(number)) {
	                list.add(number);
	            }
	            if(list.size() == 6) break;
	        }

	        // 정렬
	        Collections.sort(list);

	        // 출력
	        System.out.println(list);
	        count++;
	        list.clear();
	        }

	     sc.close();
	    }
}
