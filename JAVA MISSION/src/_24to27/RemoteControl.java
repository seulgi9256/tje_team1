package _24to27;

public interface RemoteControl {
	
	int MAX_SPEED = 200;
	int MIN_SPEED = 30;
	
	void turnOn();
	void turnOff();
	void setSpeed(int speed);
	
	static void changeBattery() {
		System.out.println("배터리를 교환");
	}
	
}
