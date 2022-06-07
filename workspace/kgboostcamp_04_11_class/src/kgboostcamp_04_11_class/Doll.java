package kgboostcamp_04_11_class;

public class Doll {
	private String message;
	private Battery battery;
	private int useCost;
	
	Doll(){
		this.message = "default";
		useCost = 600;
	}
	
	// 건전지 삽입
	public void setBattery(Battery b) {
		System.out.println("건전지 삽입");
		this.battery = b;
		System.out.println("-- 삽입 건전지 정보 --\n--------------------");
		b.printInfo();
	}
	// 음성 입력
	public void setMessage(String m) {
		this.message = m;
	}
	// 음성 출력
	// 음성 출력 시 배터리를 사용한다고 가정
	public String getMessage() {
		// 배터리 잔량이 충분하다면
		if(battery.use(useCost)) {
			int get = battery.getCapacity(useCost); // 배터리 사용
			System.out.printf("배터리 %d 사용!\n", get);
			return this.message;
		}
		// 배터리가 부족하다면
		else {
			return "건전지가 부족합니다.";
		}
	}
	public static void main(String[] args) {
		Doll d1 = new Doll();
		Doll d2 = new Doll();
		
		d1.setBattery(new Battery());
		d2.setBattery(new Battery());
		// 임의의 음성 입력
		d1.setMessage("안녕하세요!!!!!!!!");
		d2.setMessage("KG 부트캠프 입니다.");
		
		System.out.println("------음성 출력------");
		for(int i=0; i<3; i++) {
			System.out.println(d1.getMessage());
			System.out.println(d2.getMessage());
		}
	}
}
