package JavaMission_13;

public class Drink {

	protected String name;
	
	public Drink() {
		
	}

	public Drink(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void getPower() {
		setName(name);
	}

	public int getPower(int power) {
		int total_power = getPower(power);
		return total_power;
	}
	
}
