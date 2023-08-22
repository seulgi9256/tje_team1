package JavaMission_24to27;

import java.util.Scanner;

/*
 * - RemoteControl 인터페이스를 선언하시오.
- RcCar 객체, Drone 객체를 생성하여, 
RemoteControl 인터페이스 변수에 대입하시오.
- RcCar 객체와 Drone 객체를 사용하는 프로그램을 자유롭게 완성하시오
 */
public class Driver {
	
	static int speed = 0;
	static Scanner sc = new Scanner(System.in);
	
	// 구동 프로그램 시작
	// 드론 : 모터 온, 속도 빠르게, 속도 느리게, 모터 오프, 배터리 교환
	// RC카 : 시동걸기, 속도 빠르게, 속도 느리게, 시동끄기, 배터리 교환
	
	public static void main(String[] args) {
		RemoteControl drone = new Drone();
		drone.turnOn();
		drone.setSpeed(200);
		drone.setSpeed(30);
		drone.turnOff();
		RemoteControl.changeBattery();
		System.out.println();
		
		RemoteControl rcCar = new RcCar();
		rcCar.turnOn();
		rcCar.setSpeed(100);
		rcCar.setSpeed(50);
		rcCar.turnOff();
		RemoteControl.changeBattery();
		
	}
	
	
	
	
	
	
}
