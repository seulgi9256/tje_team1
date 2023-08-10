package JavaMission_11;

public class Circle {
	private double radius;
	private double PI = Math.PI; 
	
	
	// 생성자
	public Circle() {
		
	}

	// getter, setter
	public Circle(double radius) {
		this.radius = radius;
	}


	public double getRadius() {
		return radius;
	}

 
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getPI() {
		return PI;
	}


	public void setPI(double pI) {
		PI = pI;
	}
	
	public double getArea() {
		return PI*(radius * radius);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", PI=" + PI + "]";
	}
	
}
