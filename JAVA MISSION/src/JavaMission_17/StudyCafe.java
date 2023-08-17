package JavaMission_17;

import java.util.Scanner;

public class StudyCafe {
	static Scanner sc = new Scanner(System.in);
	
	static String seat1[][] = new String[4][10];
	static String seat2[][] = new String[5][4];
	static String seat3[][] = new String[6][5];	
	
	static int count = 0;
	static Reserve reserve = new Reserve(); // 여기에 있으면 한 번은 제대로 돌고 그 다음 안돌아감... use로 들어가면 초기화됨
	
	public static void ViewSeat1() {
		int left = 40;
		System.out.println("==============이용현황================");
		System.out.println("================1층=================");
		for (int i = 0; i < seat1.length; i++) {
			for (int j = 0; j < seat1[i].length; j++) {
				System.out.print(seat1[i][j] + "\t");
			} System.out.println();
		}
		System.out.println("====================================");
		System.out.println("이용가능 : " + (left-count) + "석");
	}
	
	public static void ViewSeat2() {
		int left = 20;
		System.out.println("==============이용현황================");
		System.out.println("================2층=================");
		for (int i = 0; i < seat2.length; i++) {
			for (int j = 0; j < seat2[i].length; j++) {
				System.out.print(seat2[i][j] + "\t");
			} System.out.println();
		}
		System.out.println("====================================");
		System.out.println("이용가능 : " + (left-count) + "석");
	}
	
	public static void ViewSeat3() {
		int left = 30;
		System.out.println("==============이용현황================");
		System.out.println("================3층=================");
		for (int i = 0; i < seat3.length; i++) {
			for (int j = 0; j < seat3[i].length; j++) {
				System.out.print(seat3[i][j] + "\t");
			} System.out.println();
		}
		System.out.println("====================================");
		System.out.println("이용가능 : " + (left-count) + "석");
	}
	
	public static void use() {
		
		System.out.print(">>수강번호 : ");
		int number = sc.nextInt();
		
		if(number==reserve.getNumber()) { //이미 존재하는 번호면 이용 현황 보여주고
			ViewSeat1();
			System.out.println(">>좌석번호 : " + reserve.getSeatNo());
			System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
		}
		else if(number!=reserve.getNumber()){
			reserve.setNumber(number);
		
			System.out.print(">>이름 : ");
			String name = sc.next();
			
			System.out.println("(1) 1F - 오픈라운지");
			System.out.println("(2) 2F - 미디어실");
			System.out.println("(3) 3F - 프로젝트실");
			
			System.out.print(">>압력 : ");
			int floor = sc.nextInt();
			reserve.setFloor(floor);
			
			switch(floor) {
			case 1 :
				//1층 이용현황
					int num = 1;
					if(!reserve.isReserved()) { //예약 가능한 좌석
						for (int i = 0; i < seat1.length; i++) {
							for (int j = 0; j < seat1[i].length; j++) {
								seat1[i][j] = String.format("%02d", num++);
							}
						}
					}
	
					ViewSeat1();
				
				System.out.print(">>좌석번호 : ");
				int seatNo = sc.nextInt();
				reserve.setSeatNo(seatNo);
				
				// index = seat1[seatNo/10-1][seatNo%10+9];
				if(!reserve.isReserved()) { // 예약 가능한 상태면
					
					if(seatNo<10) {
						seat1[0][seatNo%10-1] = "--";
					}
					else if(seatNo<20){
						seat1[1][seatNo%10+9] = "--";
					}
					else {
						seat1[seatNo/10-1][seatNo%10+9] = "--"; // 우선 0으로 표기 -> "--"로 바꿔야함
					}
					
					reserve.reserve(seatNo); // 예약되면 자리를 seatNo를 true로 변경
					count++; // true로 바뀔 때마다 1씩 카운팅
					
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					break;
				}
				else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			case 2 :
				//2층 이용현황
				int num2 = 1;
				if(!reserve.isReserved()) { //예약 가능한 좌석
					for (int i = 0; i < seat2.length; i++) {
						for (int j = 0; j < seat2[i].length; j++) {
							seat2[i][j] = String.format("%02d", num2++);
						}
					}
				}

				ViewSeat2();
			
			System.out.print(">>좌석번호 : ");
			int seatNo2 = sc.nextInt();
			reserve.setSeatNo(seatNo2);
			
			// index = seat1[seatNo/10-1][seatNo%10+9];
			if(!reserve.isReserved()) { // 예약 가능한 상태면
				
				if(seatNo2<5) {
					seat2[0][seatNo2%4-1] = "--";
				}
				else {
					seat2[seatNo2/4-1][seatNo2%4+9] = "--";
				}
				
				reserve.reserve(seatNo2); // 예약되면 자리를 seatNo를 true로 변경
				count++; // true로 바뀔 때마다 1씩 카운팅
				
				System.out.println(floor +"층 - " + seatNo2 + "번 좌석이 배정되었습니다.");
				System.out.println("즐거운 코딩시간 되세요!");
				break;
			}
			else {
				System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
				break;
			}
			case 3 :
				//3층 이용현황
				int num3 = 1;
				if(!reserve.isReserved()) { //예약 가능한 좌석
					for (int i = 0; i < seat3.length; i++) {
						for (int j = 0; j < seat3[i].length; j++) {
							seat3[i][j] = String.format("%02d", num3++);
						}
					}
				}

				ViewSeat3();
			
			System.out.print(">>좌석번호 : ");
			int seatNo3 = sc.nextInt();
			reserve.setSeatNo(seatNo3);
			
			// index = seat1[seatNo/10-1][seatNo%10+9];
			if(!reserve.isReserved()) { // 예약 가능한 상태면
				//???????????????????????????????????여기 정리해야함
				if(seatNo3<6) {
					seat3[0][seatNo3-1] = "--";
				}
				else if(seatNo3<10){
					seat3[seatNo3/5-1][seatNo3%5-1] = "--";
				}
				else if(seatNo3==10){
					seat3[seatNo3/5-1][seatNo3%5+4] = "--";
				}
				
				reserve.reserve(seatNo3); // 예약되면 자리를 seatNo를 true로 변경
				count++; // true로 바뀔 때마다 1씩 카운팅
				
				System.out.println(floor +"층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
				System.out.println("즐거운 코딩시간 되세요!");
				break;
			}
			else {
				System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
				break;
			}
				
			case 0 :
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
		
	}
	
	// 반납하기
	public static void cancle() {
		System.out.println("(1) 1F - 오픈라운지");
		System.out.println("(2) 2F - 미디어실");
		System.out.println("(3) 3F - 프로젝트실");
		
		System.out.print(">>압력 : ");
		int floor = sc.nextInt();
		reserve.setFloor(floor);
		
		//
		System.out.println(">>좌석번호 : ");
		int seatNo = sc.nextInt();
		System.out.println(">>수강번호 : ");
		int number = sc.nextInt();
		// 좌석 번호가 등록되어 있는지 확인하고 등록되어 있으면 반납해주고 아니면 원위치
		// 좌석 번호도 원래 대로 돌려놔야함
		//?????????????
		reserve.cancle(seatNo); // 반납되면 자리를 seatNo를 false로 변경
		count--; // false로 바뀔 때마다 -1씩 카운팅
		
		System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
		System.out.println("다음에 또 이용해 주세요!");
	
	}
	
	public static void show() {

		
		
	}
	
	public static void main(String[] args) {

		int menuInput;
		
		do {
			System.out.println("☆☆☆☆☆☆☆☆☆☆ 휴먼 스터디카페 ☆☆☆☆☆☆☆☆☆☆");
			System.out.println("1. 이용하기");
			System.out.println("2. 반납하기");
			System.out.println("3. 좌석현황");
			System.out.println("0. 종료하기");
			System.out.println("====================================");
			System.out.print(">>입력 : ");
			menuInput = sc.nextInt();
			
			switch(menuInput) {
			case 1 : // 이용하기
				use();
				break;
			case 2 : // 반납하기
				cancle();
				break;
				
			case 3 : // 좌석현황
				show();
				break;
				
			case 0 : // 종료
				System.out.println("시스템이 종료되었습니다.");
				break;
			}
		}while(menuInput!=0);
	}
}
