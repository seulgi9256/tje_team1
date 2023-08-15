package JavaMission_13;

import java.util.Scanner;

public class Driver {
	
	static String drive = "";
	static String drink = "";
	static int vitality = 0;
	static DeliveryType type;
	static Drink dr;
	static ModooDriver md = new ModooDriver();
	public static void delivery() {
		System.out.println("================ 배달수단 ================");
		System.out.println("1. 도보");
		System.out.println("2. 자전거");
		System.out.println("3. 킥보드");
		System.out.println("4. 오토바이");
		System.out.println("0. 운행종료");
		System.out.println("========================================");
		System.out.print("입력>>");
	}
	public static void Drink() {
		System.out.println("================ 드링크 ================");
		System.out.println("1. 비타민음료(활력증가값 : 30)");
		System.out.println("2. 커피(활력증가값 : 20)");
		System.out.println("3. 에너지드링크(활력증가값 : 50)");
		System.out.println("0. 안마심(활력증가값 없음)");
		System.out.println("========================================");
		System.out.print("입력>>");
	}
	public static void walKer() {
		type = new Walker("도보");
		drive = type.getName();
	}
	public static void biCyCle() {
		type = new Bicycle("자전거");
		drive = type.getName();
	}
	public static void kickBoard() {
		type = new KickBoard("킥보드");
		drive = type.getName();
	}
	public static void motorCycle() {
		type = new MotorCycle("오토바이");
		drive = type.getName();
	}
	public static void vitaMinDrink() {
		dr = new VitaminDrink("비타민음료");
		drink = dr.getName();
	}
	public static void coFFee() {
		dr = new Coffee("커피");
		drink = dr.getName();
	}
	public static void enerGyDrink() {
		dr = new EnergyDrink("에너지드링크");
		drink = dr.getName();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int driver_select;
		int drink_select;
		int total = 100;
		do {
			delivery();
			driver_select = sc.nextInt();
			switch (driver_select) {
			case 1 : walKer(); break;
			case 2 : biCyCle(); break;
			case 3 : kickBoard(); break;
			case 4 : motorCycle(); break;
			case 0 : System.out.println("운행종료");
			}
			
			if(driver_select == 0) break;
			
			Drink();
			drink_select = sc.nextInt();
			switch (drink_select) {
			case 1: vitaMinDrink(); break;
			case 2: coFFee(); break;
			case 3: enerGyDrink(); break;
			case 0: drink = "안마심"; break;
			}
			dr.getPower();
			type.work();
			if(drink_select != 0) {
				total += md.powerUp(dr);
			}
			System.out.println("활력 : " + total);
			
		} while (driver_select != 0);

		sc.close();
	}

}
