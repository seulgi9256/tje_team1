package JavaMission_17;

import java.util.Scanner;

public class StudyCafe {
	static Scanner sc = new Scanner(System.in);
	
	static String seat1[][] = new String[4][10];
	static String seat2[][] = new String[5][4];
	static String seat3[][] = new String[6][5];
	static String t_f[][] = new String[4][10];
	static String t_f2[][] = new String[5][4];
	static String t_f3[][] = new String[6][5];
	static {
		int num = 1;
		for (int i = 0; i < seat1.length; i++) {
			for (int j = 0; j < seat1[i].length; j++) {
				seat1[i][j] = String.format("%02d", num++);
			}
		}
		
		num = 1;
		for (int i = 0; i < seat2.length; i++) {
			for (int j = 0; j < seat2[i].length; j++) {
				seat2[i][j] = String.format("%02d", num++);
			}
		}
		
		num = 1;
		for (int i = 0; i < seat3.length; i++) {
			for (int j = 0; j < seat3[i].length; j++) {
				seat3[i][j] = String.format("%02d", num++);
			}
		}
	}
	static { // 프로그램 실행될 때 딱 한번만 실행 ( true&false 배열에 true로 전체 초기화) : true일 경우 좌석 예약가능
       
        for (int i = 0; i < t_f.length; i++) {
            for (int j = 0; j < t_f[i].length; j++) {
                t_f[i][j] = "true";
            }
        }
        
        for (int i = 0; i < t_f2.length; i++) {
            for (int j = 0; j < t_f2[i].length; j++) {
                t_f2[i][j] = "true";
            }
        }
        
        for (int i = 0; i < t_f3.length; i++) {
            for (int j = 0; j < t_f3[i].length; j++) {
                t_f3[i][j] = "true";
            }
        }
    }
	
	static int count = 0;
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
		System.out.println("이용가능 : " + (left-count) + "석");
//		System.out.println("==============이용현황================");
//		System.out.println("================1층=================");
//		for (int i = 0; i < seat1.length; i++) {
//			for (int j = 0; j < seat1[i].length; j++) {
//				System.out.print(t_f[i][j] + "\t");
//			} System.out.println();
//		}
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
		System.out.println("이용가능 : " + (left-count) + "석");
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
		System.out.println("이용가능 : " + (left-count) + "석");
	}
	
	public static void use() {
		
		System.out.print(">>수강번호 : ");
		int number = sc.nextInt();
		boolean check = Reserve.seatNumber.contains(number);
		System.out.println(check);
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
				
				// index = seat1[seatNo/10-1][seatNo%10+9];
				if(seatNo>1 && seatNo < 10) {
					if(t_f[0][seatNo-1].equals("true")) {
						for (int i = 0; i < 1; i++) {
							for (int j = seatNo; j <= seatNo; j++) {
								if(t_f[0][j-1].equals("true")) {
									t_f[0][j-1] = "false";
								}
							}
						}
						count++;
						System.out.println(floor +"층 - " + seatNo + "번 좌석이 배정되었습니다.");
						System.out.println("즐거운 코딩시간 되세요!");
						reserve.seatNumber.add(number);
						break;
					} else {
						System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
						break;
					}
					
				} else if(seatNo>10 && seatNo<20) {
					int a = seatNo%10;
					if(t_f[1][a-1].equals("true")) {
						for (int i = 1; i < 2; i++) {
							for (int j = a; j <= a; j++) {
								if(t_f[1][j-1].equals("true")) {
									t_f[1][j-1] = "false";
								}
							}
						}
						count++;
						System.out.println(floor +"층 - " + seatNo + "번 좌석이 배정되었습니다.");
						System.out.println("즐거운 코딩시간 되세요!");
						reserve.seatNumber.add(number);
						break;
					} else {
						System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
						break;
					}
				} else if(seatNo>20 && seatNo<30){
					int a = seatNo%20;
					if(t_f[2][a-1].equals("true")) {
						for (int i = 2; i < 3; i++) {
							for (int j = a; j <= a; j++) {
								if(t_f[2][j-1].equals("true")) {
									t_f[2][j-1] = "false";
								}
							}
						}
						count++;
						System.out.println(floor +"층 - " + seatNo + "번 좌석이 배정되었습니다.");
						System.out.println("즐거운 코딩시간 되세요!");
						reserve.seatNumber.add(number);
						break;
					} else {
						System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
						break;
					}
				} 
				
				else if(seatNo==10 || seatNo==20 || seatNo==30 || seatNo==40) {
					int a = seatNo/10;
					if(t_f[a-1][9].equals("true")) {
								if(t_f[a-1][9].equals("true")) {
									t_f[a-1][9] = "false";
								}
						count++;
						System.out.println(floor +"층 - " + seatNo + "번 좌석이 배정되었습니다.");
						System.out.println("즐거운 코딩시간 되세요!");
						reserve.seatNumber.add(number);
						break;
				}
					 else {
						System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
						break;
					}
				}
				
				else {
					int a = seatNo%30;
					if(t_f[3][a-1].equals("true")) {
						for (int i = 3; i < 4; i++) {
							for (int j = a; j <= a; j++) {
								if(t_f[3][j-1].equals("true")) {
									t_f[3][j-1] = "false";
								}
							}
						}
						count++;
						System.out.println(floor +"층 - " + seatNo + "번 좌석이 배정되었습니다.");
						System.out.println("즐거운 코딩시간 되세요!");
						reserve.seatNumber.add(number);
						break;
					} else {
						System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
						break;
					}
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
				System.out.println("==============이용현황================");
				ViewSeat2();
			
			System.out.print(">>좌석번호 : ");
			int seatNo2 = sc.nextInt();
			reserve.setSeatNo(seatNo2);
			
			if(seatNo2>=1 && seatNo2<=4) {
				if(t_f2[0][seatNo2-1].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = seatNo2; j <= seatNo2; j++) {
							if(t_f2[0][j-1].equals("true")) {
								t_f2[0][j-1] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo2 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else if(seatNo2>5 && seatNo2<=8) {
				int a = seatNo2%5;
				if(t_f2[1][seatNo2-5].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[1][a].equals("true")) {
								t_f2[1][a] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo2 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else if(seatNo2>8 && seatNo2<=12) {
				int a = seatNo2%8;
				if(t_f2[2][seatNo2-9].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[2][a-1].equals("true")) {
								t_f2[2][a-1] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo2 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else if(seatNo2>12 && seatNo2<=16) {
				int a = seatNo2%12;
				if(t_f2[3][seatNo2-13].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[3][a-1].equals("true")) {
								t_f2[3][a-1] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo2 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else {
				int a = seatNo2%16;
				if(t_f2[4][seatNo2-17].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[4][a-1].equals("true")) {
								t_f2[4][a-1] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo2 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
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
				System.out.println("==============이용현황================");
				ViewSeat3();
			
			System.out.print(">>좌석번호 : ");
			int seatNo3 = sc.nextInt();
			reserve.setSeatNo(seatNo3);
			
			if(seatNo3>=1 && seatNo3<=5) {
				if(t_f3[0][seatNo3-1].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = seatNo3; j <= seatNo3; j++) {
							if(t_f3[0][j-1].equals("true")) {
								t_f3[0][j-1] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else if(seatNo3>5 && seatNo3<=10) {
				int a = seatNo3%6;
				if(t_f3[1][seatNo3-6].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[1][a].equals("true")) {
								t_f3[1][a] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else if(seatNo3>10 && seatNo3<=15) {
				int a = seatNo3%11;
				if(t_f3[2][seatNo3-11].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[2][a].equals("true")) {
								t_f3[2][a] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else if(seatNo3>15 && seatNo3<=20) {
				int a = seatNo3%16;
				if(t_f3[3][seatNo3-16].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[3][a].equals("true")) {
								t_f3[3][a] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else if(seatNo3>20 && seatNo3<=25) {
				int a = seatNo3%21;
				if(t_f3[4][seatNo3-21].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[4][a].equals("true")) {
								t_f3[4][a] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
			}
			
			else { //26~30
				int a = seatNo3%26;
				if(t_f3[4][seatNo3-26].equals("true")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[4][a].equals("true")) {
								t_f3[4][a] = "false";
							}
						}
					}
					count++;
					System.out.println(floor +"층 - " + seatNo3 + "번 좌석이 배정되었습니다.");
					System.out.println("즐거운 코딩시간 되세요!");
					reserve.seatNumber.add(number);
					break;
				} else {
					System.out.println("이미 이용중 입니다. 다른 자리를 이용해주세요.");
					break;
				}
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
		if(seatNo < 10) {
			if(t_f[0][seatNo-1].equals("false")) {
				for (int i = 0; i < 1; i++) {
					for (int j = seatNo; j <= seatNo; j++) {
						if(t_f[0][j-1].equals("false")) {
							t_f[0][j-1] = "true";
						}
					}
				}
				System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
				System.out.println("다음에 또 이용해 주세요!");
				reserve.seatNumber.remove(number);
				// false로 바뀔 때마다 -1씩 카운팅
				count--;
			} else {
				System.out.println("빌린 좌석이 아닙니다.");
			}
			
		} else if(seatNo < 20) {
			int a = seatNo%10;
			if(t_f[1][a-1].equals("false")) {
				for (int i = 0; i < 1; i++) {
					for (int j = a; j <= a; j++) {
						if(t_f[1][j-1].equals("false")) {
							t_f[1][j-1] = "true";
						}
					}
				}
				System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
				System.out.println("다음에 또 이용해 주세요!");	
				reserve.seatNumber.remove(number);
				// false로 바뀔 때마다 -1씩 카운팅
				count--;
			} else {
				System.out.println("빌린 좌석이 아닙니다.");
			}
			
		} else if(seatNo < 30) {
			int a = seatNo%20;
			if(t_f[2][a-1].equals("false")) {
				for (int i = 0; i < 1; i++) {
					for (int j = a; j <= a; j++) {
						if(t_f[2][j-1].equals("false")) {
							t_f[2][j-1] = "true";
						}
					}
				}
				System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
				System.out.println("다음에 또 이용해 주세요!");
				reserve.seatNumber.remove(number);	
				// false로 바뀔 때마다 -1씩 카운팅
				count--;
			} else {
				System.out.println("빌린 좌석이 아닙니다.");
			}
		} else {
			int a = seatNo%20;
			if(t_f[3][a-1].equals("false")) {
				for (int i = 0; i < 1; i++) {
					for (int j = a; j <= a; j++) {
						if(t_f[3][j-1].equals("false")) {
							t_f[3][j-1] = "true";
						}
					}
				}
				System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
				System.out.println("다음에 또 이용해 주세요!");	
				reserve.seatNumber.remove(number);
				// false로 바뀔 때마다 -1씩 카운팅
				count--;
			} else {
				System.out.println("빌린 좌석이 아닙니다.");
			}
		}
		
		case 2 : /////////////////////////////////////////////////////////////////2층 반납
			if(seatNo>=1 && seatNo<=4) {
				if(t_f2[0][seatNo-1].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = seatNo; j <= seatNo; j++) {
							if(t_f2[0][j-1].equals("false")) {
								t_f2[0][j-1] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
				
			else if(seatNo>5 && seatNo<=8) {
				int a = seatNo%5;
				if(t_f2[1][seatNo-5].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[1][a].equals("false")) {
								t_f2[1][a] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
			
			else if(seatNo>8 && seatNo<=12) {
				int a = seatNo%8;
				if(t_f2[2][seatNo-9].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[2][a-1].equals("false")) {
								t_f2[2][a-1] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
			
			else if(seatNo>12 && seatNo<=16) {
				int a = seatNo%12;
				if(t_f2[3][seatNo-13].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[3][a-1].equals("false")) {
								t_f2[3][a-1] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
			
			else {
				int a = seatNo%16;
				if(t_f2[4][seatNo-17].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f2[4][a-1].equals("false")) {
								t_f2[4][a-1] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
				
			break;
		
		case 3 ://///////////////////////////////////////////////////////////////3층 반납
			if(seatNo>=1 && seatNo<=5) {
				if(t_f3[0][seatNo-1].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = seatNo; j <= seatNo; j++) {
							if(t_f3[0][j-1].equals("false")) {
								t_f3[0][j-1] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
			
			else if(seatNo>5 && seatNo<=10) {
				int a = seatNo%6;
				if(t_f3[1][seatNo-6].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[1][a].equals("false")) {
								t_f3[1][a] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
			
			else if(seatNo>10 && seatNo<=15) {
				int a = seatNo%11;
				if(t_f3[2][seatNo-11].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[2][a].equals("false")) {
								t_f3[2][a] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
			
			else if(seatNo>15 && seatNo<=20) {
				int a = seatNo%16;
				if(t_f3[3][seatNo-16].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[3][a].equals("false")) {
								t_f3[3][a] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
			}
			
			else if(seatNo>20 && seatNo<=25) {
				int a = seatNo%21;
				if(t_f3[4][seatNo-21].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[4][a].equals("false")) {
								t_f3[4][a] = "true";
							}
						}
					}
					System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
					System.out.println("다음에 또 이용해 주세요!");
					reserve.seatNumber.remove(number);
					// false로 바뀔 때마다 -1씩 카운팅
					count--;
				} else {
					System.out.println("빌린 좌석이 아닙니다.");
				}
}
			
			else { //26~30
				int a = seatNo%26;
				if(t_f3[4][seatNo-26].equals("false")) {
					for (int i = 0; i < 1; i++) {
						for (int j = a; j <= a; j++) {
							if(t_f3[4][a].equals("false")) {
								t_f3[4][a] = "true";
							}
						}
					}
				System.out.println(floor +"층 - " + seatNo + "번 좌석이 반납되었습니다.");
				System.out.println("다음에 또 이용해 주세요!");
				reserve.seatNumber.remove(number);
				// false로 바뀔 때마다 -1씩 카운팅
				count--;
			} else {
				System.out.println("빌린 좌석이 아닙니다.");
			}
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