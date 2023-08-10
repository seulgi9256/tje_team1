package JavaMission_18to23;

public class Point {
	int x, y;

	// 기본 생성자
	public Point() {
		
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
