package JavaMission_13;

public class MotorCycle extends DeliveryType {

	public MotorCycle() {
	}

	public MotorCycle(String name) {
		this.name = name;
	}
	@Override
	public void work() {
		System.out.println(this.name + "(으/)로 배달을 수행중입니다.");
	}
}
