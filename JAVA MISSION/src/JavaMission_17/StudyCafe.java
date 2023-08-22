package JavaMission_17;

import java.util.Scanner;

public class StudyCafe {
	static Scanner sc = new Scanner(System.in);
    /*------------------------배열 선언부----------------------------*/
    static String seat1[][] = new String[4][10];
    static String seat2[][] = new String[5][4];
    static String seat3[][] = new String[6][5];
    static String t_f[][] = new String[4][10];
    static String t_f2[][] = new String[5][4];
    static String t_f3[][] = new String[6][5];
    
	static int floorIndex = -1;
	static int maxSeatsPerFloor = 10;
	static int maxSeatsPerFloor2 = 4;
	static int maxSeatsPerFloor3 = 5;
    /*------------------------------------------------------------*/

    /*------------------------좌석번호 및 예약상태 초기화----------------------------*/
    // 좌석번호
    static void seatArrays(String[][] arr) {
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.format("%02d", num++);
            }
        }
    }
    // 예약상태
    static void truefalseArrays(String[][] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = "true";
            }
        }
    }
    /*------------------------------------------------------------------------*/
	static int count1 = 0;
	static int count2 = 0;
	static int count3 = 0;
	static Reserve reserve = new Reserve(); // 여기에 있으면 한 번은 제대로 돌고 그 다음 안돌아감... use로 들어가면 초기화됨
	
	public static void ViewSeat1() {
		int left = 40;
		System.out.println("================1층=================");
		for (int i = 0; i < seat1.length; i++) {
			for (int j = 0; j < seat1[i].length; j++) {
				// 해당 자리가 false 일경 -- 로 표시 아닐경우 숫자로 정상 표기
				if(t_f[i][j].equals("false")) {
					System.out.print("--" + "\t");					
				} else {
					System.out.print(seat1[i][j] + "\t");					
				}
			} System.out.println();
		}
		System.out.println("====================================");
		System.out.println("                        이용가능 : " + (left-count1) + "석");
	}
	
	public static void ViewSeat2() {
		int left = 20;
		System.out.println("================2층=================");
		for (int i = 0; i < seat2.length; i++) {
			for (int j = 0; j < seat2[i].length; j++) {
				if(t_f2[i][j].equals("false")) {
					System.out.print("--" + "\t");					
				} else {
					System.out.print(seat2[i][j] + "\t");					
				}
			} System.out.println();
		}
		System.out.println("====================================");
		System.out.println("                       이용가능 : " + (left-count2) + "석");
	}
	
	public static void ViewSeat3() {
		int left = 30;
		System.out.println("================3층=================");
		for (int i = 0; i < seat3.length; i++) {
			for (int j = 0; j < seat3[i].length; j++) {
				if(t_f3[i][j].equals("false")) {
					System.out.print("--" + "\t");					
				} else {
					System.out.print(seat3[i][j] + "\t");					
				}
			} System.out.println();
		}
		System.out.println("====================================");
		System.out.println("                       이용가능 : " + (left-count3) + "석");
	}
	
	public static void use() {
		
		System.out.print(">>수강번호 : ");
		int number = sc.nextInt();
		boolean check = Reserve.seatNumber.contains(number);
//		System.out.println(check);
		if(check) { //이미 존재하는 번호면 이용 현황 보여주고
			ViewSeat1();
			System.out.println(">>좌석번호 : " + reserve.getSeatNo());
			System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
		}
		else {
			reserve.setNumber(number);
		
			System.out.print(">>이름 : ");
			String name = sc.next();
			
			System.out.println("(1) 1F - 오픈라운지");
			System.out.println("(2) 2F - 미디어실");
			System.out.println("(3) 3F - 프로젝트실");
			
			System.out.print(">>입력 : ");
			int floor = sc.nextInt();
			reserve.setFloor(floor);
			
			switch(floor) {
				case 1 :
				//1층 이용현황
//				int num = 1;
				ViewSeat1();
				System.out.print(">>좌석번호 : ");
				int seatNo = sc.nextInt();
				reserve.setSeatNo(seatNo);
				
				if (seatNo >= 1 && seatNo <= 40) {
				    floorIndex = (seatNo - 1) / maxSeatsPerFloor; // Calculate floor index
				    
				    int seatIndexOnFloor = (seatNo - 1) % maxSeatsPerFloor; // Calculate seat index on the floor
				    
				    if (t_f[floorIndex][seatIndexOnFloor].equals("true")) {
				        t_f[floorIndex][seatIndexOnFloor] = "false";
				        count1++;
				        System.out.println(floor + "층 - " + seatNo + "번 좌석이 배정되었습니다.");
				        System.out.println("즐거운 코딩시간 되세요!");
				        reserve.seatNumber.add(number);
				    } else {
				        System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
				    }
				} else {
				    System.out.println("잘못된 좌석 번호입니다. 1에서 40까지의 번호를 입력해주세요.");
				}
				break;
				
				
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
				System.out.println("==============이용현황================");
				ViewSeat2();
			
			System.out.print(">>좌석번호 : ");
			int seatNo2 = sc.nextInt();
			reserve.setSeatNo(seatNo2);
			
			if (seatNo2 >= 1 && seatNo2 <= 20) {
			    floorIndex = (seatNo2 - 1) / maxSeatsPerFloor2; // Calculate floor index
			    
			    int seatIndexOnFloor2 = (seatNo2 - 1) % maxSeatsPerFloor2; // Calculate seat index on the floor
			    
			    if (t_f2[floorIndex][seatIndexOnFloor2].equals("true")) {
			        t_f2[floorIndex][seatIndexOnFloor2] = "false";
			        count2++;
			        System.out.println(floor + "층 - " + seatNo2 + "번 좌석이 배정되었습니다.");
			        System.out.println("즐거운 코딩시간 되세요!");
			        reserve.seatNumber.add(number);
			    } else {
			        System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
			    }
			} else {
			    System.out.println("잘못된 좌석 번호입니다. 1에서 40까지의 번호를 입력해주세요.");
			}
				break;
				
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
				System.out.println("==============이용현황================");
				ViewSeat3();
			
			System.out.print(">>좌석번호 : ");
			int seatNo3 = sc.nextInt();
			reserve.setSeatNo(seatNo3);
			
			if (seatNo3 >= 1 && seatNo3 <= 30) {
			    floorIndex = (seatNo3 - 1) / maxSeatsPerFloor3; // Calculate floor index
			    
			    int seatIndexOnFloor3 = (seatNo3 - 1) % maxSeatsPerFloor3; // Calculate seat index on the floor
			    
			    if (t_f3[floorIndex][seatIndexOnFloor3].equals("true")) {
			        t_f3[floorIndex][seatIndexOnFloor3] = "false";
			        count3++;
			        System.out.println(floor + "층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
			        System.out.println("즐거운 코딩시간 되세요!");
			        reserve.seatNumber.add(number);
			    } else {
			        System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
			    }
			} else {
			    System.out.println("잘못된 좌석 번호입니다. 1에서 30까지의 번호를 입력해주세요.");
			}
				break;
				
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
		
		System.out.print(">>입력 : ");
		int floor = sc.nextInt();
		reserve.setFloor(floor);
		
		//
		System.out.println(">>좌석번호 : ");
		int seatNo = sc.nextInt();
		System.out.println(">>수강번호 : ");
		int number = sc.nextInt();
		
	switch(floor) {
		case 1 : /////////////////////////////////////////////////////////////////1층 반납

			if (seatNo >= 1 && seatNo <= 40) {
			    floorIndex = (seatNo - 1) / maxSeatsPerFloor; // Calculate floor index
			    
			    int seatIndexOnFloor = (seatNo - 1) % maxSeatsPerFloor; // Calculate seat index on the floor
			    
			    if (t_f[floorIndex][seatIndexOnFloor].equals("false")) {
			        t_f[floorIndex][seatIndexOnFloor] = "true";
			        count1--;
			        System.out.println(floor + "층 - " + seatNo + "번 좌석이 반납되었습니다.");
			        System.out.println("다음에 또 이용해 주세요!");
			        reserve.seatNumber.remove(number);
			    } else {
			        System.out.println("빌린 좌석이 아닙니다.");
			    }
			} else {
			    System.out.println("잘못된 좌석 번호입니다. 1에서 40까지의 번호를 입력해주세요.");
			}
			break;
			
		case 2 : /////////////////////////////////////////////////////////////////2층 반납
			if (seatNo >= 1 && seatNo <= 20) {
			    floorIndex = (seatNo - 1) / maxSeatsPerFloor2; // Calculate floor index
			    
			    int seatIndexOnFloor2 = (seatNo - 1) % maxSeatsPerFloor2; // Calculate seat index on the floor
			    
			    if (t_f2[floorIndex][seatIndexOnFloor2].equals("false")) {
			        t_f2[floorIndex][seatIndexOnFloor2] = "true";
			        count2--;
			        System.out.println(floor + "층 - " + seatNo + "번 좌석이 반납되었습니다.");
			        System.out.println("다음에 또 이용해 주세요!");
			        reserve.seatNumber.remove(number);
			    } else {
			        System.out.println("빌린 좌석이 아닙니다.");
			    }
			} else {
			    System.out.println("잘못된 좌석 번호입니다. 1에서 20까지의 번호를 입력해주세요.");
			}
				break;
				
		case 3 ://///////////////////////////////////////////////////////////////3층 반납
			if (seatNo >= 1 && seatNo <= 30) {
			    floorIndex = (seatNo - 1) / maxSeatsPerFloor3; // Calculate floor index
			    
			    int seatIndexOnFloor3 = (seatNo - 1) % maxSeatsPerFloor3; // Calculate seat index on the floor
			    
			    if (t_f3[floorIndex][seatIndexOnFloor3].equals("false")) {
			        t_f3[floorIndex][seatIndexOnFloor3] = "true";
			        count3--;
			        System.out.println(floor + "층 - " + seatNo + "번 좌석이 반납되었습니다.");
			        System.out.println("다음에 또 이용해 주세요!");
			        reserve.seatNumber.remove(number);
			    } else {
			        System.out.println("빌린 좌석이 아닙니다.");
			    }
			} else {
			    System.out.println("잘못된 좌석 번호입니다. 1에서 30까지의 번호를 입력해주세요.");
			}
				break;
	}
		}
	
	public static void show() {
		System.out.println("==============이용현황================");
		ViewSeat1();
		ViewSeat2();
		ViewSeat3();
	}
	
	public static void main(String[] args) {
        seatArrays(seat1);
        seatArrays(seat2);
        seatArrays(seat3);
        truefalseArrays(t_f);
        truefalseArrays(t_f2);
        truefalseArrays(t_f3);

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