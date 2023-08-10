package _11;

public class Rectangle {

	private double width;
	private double height;
	
	// 생성자
	public Rectangle() {
		
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
 
	
	//getter, setter
	public double getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public double getArea() {
		return (width * height);
	}
	
}
