package JavaMission_13;

public class Coffee extends Drink {
	
	public Coffee() {
		
	}
	
	public Coffee(String name) {
		this.name = name;
	}
	
	public void getPower() {
		System.out.println(this.name + "(을/)를 마셨습니다.");
	}
	
	public int getPower(int power) {
		int coffe_power = 20;
		return coffe_power;
	}
	
}
