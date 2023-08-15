package JavaMission_13;

public class ModooDriver {
	public int power;

	public ModooDriver() {
	}

	public ModooDriver(int power) {
		this.power = power;
	}
	
	public void drive(DeliveryType type) {
		type.getName();
	}
	public void drive(DeliveryType type, Drink drink) {
		type.getName();
		drink.getName();
	}
	public int powerUp(Drink drink) {
		int total_power = drink.getPower(power);
		return total_power;
	}
}
