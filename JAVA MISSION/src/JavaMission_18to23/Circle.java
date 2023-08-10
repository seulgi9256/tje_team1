package JavaMission_18to23;

public class Circle extends Shape{
	double radius;
	
	public Circle() {
		this(0);
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	double area() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}
	@Override
	double round() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}
