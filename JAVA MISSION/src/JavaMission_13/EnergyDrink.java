package JavaMission_13;

public class EnergyDrink extends Drink {

	public EnergyDrink() {
		
	}
	public EnergyDrink(String name) {
		this.name = name;
	}
	
	public void getPower() {
		System.out.println(this.name + "(을/)를 마셨습니다.");
	}
	public int getPower(int power) {
		int enegy_power = 50;
		return enegy_power;
	}
}
