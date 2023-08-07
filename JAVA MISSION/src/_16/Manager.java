package _16;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.LinkedList;
	import java.util.Scanner;

	public class Manager {

		public static void main(String[] args) {
			
			LinkedList<Student> list = new LinkedList<Student>();
			list = getTxtToList(list);
			list = sortScoreAndNo(list);
			printList(list);
		}
		
		/**
		 * 리스트 정렬
		 * @param list
		 * @return
		 */
		public static LinkedList<Student> sortScoreAndNo(LinkedList<Student> list) {
		
			LinkedList<Student> newList = (LinkedList<Student>) list.clone();
			
			/* TODO 여기에 코드를 작성해보세요:D */
			 
			return newList;
		}
		
		/**
		 * 텍스트 파일입력
		 * @param list
		 * @return
		 */
		public static LinkedList<Student> getTxtToList(LinkedList<Student> list) {
			try {
				
				File file = new File("student.txt");
				Scanner sc = new Scanner(file);
				Student std;
				while (sc.hasNextLine()) {
					String stn = sc.nextLine();
					String[] data = stn.split("/");
					
					int no = Integer.parseInt( data[0] );
					String name = data[1];
					int score = Integer.parseInt( data[2] );
					String className = data[3];
					
					std = new Student(no, name, score, className);
					list.offer(std);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			return list;
		}
		
		/**
		 * 리스트 출력
		 * @param list
		 */
		public static void printList(LinkedList<Student> list) {
			
			System.out.println("번호\t이름\t성적\t반");
			/* TODO 여기에 코드를 작성해보세요:D */

			
		}
	}

}
