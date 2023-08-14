package JavaMission_16;

import java.util.LinkedList;

public class Student implements Cloneable, Comparable<Student>{
	
	int no;
	String name;
	int score;
	String className;
	
	public Student() {

		}

	public Student(int no, String name, int score, String className) {
		this.no = no;
		this.name = name;
		this.score = score;
		this.className = className;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", score=" + score + ", className=" + className + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object list = (LinkedList<?>) super.clone();
		
		return list;
	}
	
	//private Student student = new Student ();
//	List<Student> list = new LinkedList<Student>();
	

	@Override
	public int compareTo(Student s2) {
		
		int s1Score = this.getScore();
		int s2Score = s2.getScore();
		
		int s1No = this.getNo();
		int s2No = s2.getNo();
		
		int result1 = s2Score - s1Score; // 내림차순
		int result2 = s1No - s2No; // 오름차순
		
		if(result1>0) {
			return 1;
		}
		else if(result1==0) {
			if(result2>0) return 1;
			else if(result2==0) return 0;
			else return -1;
		}
		else
			return -1;

	}
	
}