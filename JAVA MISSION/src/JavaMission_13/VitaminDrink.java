package JavaMission_13;

public class VitaminDrink extends Drink {

	public VitaminDrink() {
		
	}
	
	public VitaminDrink(String name) {
		this.name = name;
	}
	
	public void getPower() {
		System.out.println(this.name + "(을/)를 마셨습니다.");
	}
	public int getPower(int power) {
		int vitamin_power = 30;
		return vitamin_power;
	}
}
