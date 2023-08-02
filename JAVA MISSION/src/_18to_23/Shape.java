package _18to_23;

public abstract class Shape {
	Point point;

	abstract double area();
	abstract double round();
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
}
