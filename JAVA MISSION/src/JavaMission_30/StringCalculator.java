package JavaMission_30;

import java.util.Scanner;
import java.util.Stack;

public class StringCalculator {
	
	public static boolean Operators(char op) {
		return op == '+' || op == '-' || op == '*' || op == '/';
	}
	
	public static boolean Precedence(char op1, char op2) {
		if(op2 == '(' || op2 == ')') return false;		

		return op1 == '*' || op1 == '/' && op2 == '+' || op2 == '-';		
	}
	
	public static int Calculator(char op, int a, int b) {
		switch(op) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			if(b==0) {
				System.out.println("0으로 나눌 수 없습니다.");
				break;
			}
			return a/b;
		default :
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String str1 = str.replaceAll("\\s", "");
		
		Stack<Character> op = new Stack<>();
		Stack<Integer> value = new Stack<>();
		int result = 0;
		
		if(str1==null || str1.isEmpty()) {
			System.out.println("문자열이 입력되지 않았습니다.");
		}
		
		for(char ch : str1.toCharArray()) {
			if(Character.isDigit(ch)) { // ch값이 숫자이면
				value.add((int) ch - 48);
			}
			else if(ch=='('){ // ( ) 부분 먼저 계산
				op.push(ch);
			}
			else if(ch==')'){
				while(op.peek() != '(') {
					value.push(Calculator(op.pop(), value.pop(), value.pop()));
				}
				op.pop(); // '('
			} 
			else if(Operators(ch)) { // 사칙 연산에 따라 계산
				while(!op.isEmpty() && Precedence(ch, op.peek())) {
					value.push(Calculator(op.pop(), value.pop(), value.pop()));
				}
				op.push(ch);
			}
			
			while(!op.isEmpty()) {
				value.push(Calculator(op.pop(), value.pop(), value.pop()));
			}
			value.pop();
		}
		result = value.pop();
		System.out.println(result);
		sc.close();
		}

	}
