package JavaMission_17;

public class Reserve {
	int number; // 수강번호
	int floor; // 층수
	int seatNo; // 좌석번호
	boolean reserved; // 예약상태
	
	public Reserve() {
		this(0, 0, 0, false);
	}

	public Reserve(int number, int floor, int seatNo, boolean reserved) {
		this.number = number;
		this.floor = floor;
		this.seatNo = seatNo;
		this.reserved = reserved;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	
	public String toString() {
		return "Reserve [number=" + number + ", floor=" + floor + ", seatNo=" + seatNo + ", reserved=" + reserved + "]";
	}
	
	public void reserve(int seatNo) {
			reserved = true;
		
	}
	
	public void cancle(int seatNo) {
			reserved = false;
		
	
	}
}