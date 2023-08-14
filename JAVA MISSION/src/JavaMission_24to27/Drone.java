package JavaMission_24to27;

public class Drone implements RemoteControl {
	
	private int speed;
	
	@Override
	public void turnOn() {
		System.out.println("Drone 전원을 켭니다.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("Drone 전원을 끕니다.");
		
	}
	@Override
	public void setSpeed(int speed) {
		// 속도 최댓값을 넘지 못하게 지정
		if( speed > RemoteControl.MAX_SPEED) {
			this.speed = RemoteControl.MAX_SPEED;
		}
		// 속도 최솟값을 넘지 못하게 지정
		else if ( speed < RemoteControl.MIN_SPEED) {
			this.speed = RemoteControl.MIN_SPEED;
		}
		else {
			this.speed = speed;
		}
		System.out.println("현재 Drone 속도 : " + this.speed);
		
	}
	

}
