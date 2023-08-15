package JavaMission_13;

public class DeliveryType {

	protected String name;
	
	public DeliveryType() {
		
	}

	public DeliveryType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void work() {
		setName(name);
    }
}
