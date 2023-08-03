package _24to27;

public class RcCar implements RemoteControl{
	
	private int speed;
	
	@Override
	public void turnOn() {
		System.out.println("RcCar 전원을 켭니다.");
		
	}
	@Override
	public void turnOff() {
		System.out.println("RcCar 전원을 끕니다.");
		
	}
	@Override
	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		
	}
	
	

}
