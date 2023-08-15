package JavaMission_13;

public class Walker extends DeliveryType {

	public Walker() {
		
	}

	public Walker(String name) {
		this.name = name;
	}
	
	@Override
	public void work() {
		System.out.println(this.name + "(으/)로 배달을 수행중입니다.");
	}
}
