package kgboostcamp_04_11_class;

public class Battery {
	private String made; // 제조사
	private String size; // 규격
	private int capacity; // 규격 용량
	private double volt; // 전압
	private int remain; // 잔량
	
	// Constructor
	// 건전지 값은 미리 정해져 있는 것으로 설정
	Battery(){
		this.made = "에너자이저";
		this.size = "AAA";
		this.capacity = 1200;
		this.volt = 1.5;
		this.remain = 1200;
	}
	public boolean use(int n) {
		if(remain < n) {
			return false;
		}
		else {
			return true;
		}
	}
	public void printInfo() {
		System.out.printf("제조사 : %s / 규격 : %s / 용량 : %s\n전압 : %.1fV / 잔량 : %s\n",
				this.made, this.size, this.capacity,this.volt, this.remain);
	}
	public int getCapacity(int n) {
		this.remain -= n;
		return n;
	}
}