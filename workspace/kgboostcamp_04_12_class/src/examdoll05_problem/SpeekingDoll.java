package examdoll05_problem;

public class SpeekingDoll {
	private Battery battery;
	private String bType;
	private String message;
	public static final int REC_W = 12; //상수
	public static final int SPK_W = 15; //상수
	
	
	public SpeekingDoll(String bType){
		this.bType = bType;
		message = "녹음하세요.";
	}
	
	//배터리 삽입
	public Battery insertBattery(Battery battery) {
		if(!battery.getType().equals(bType)) {
			System.out.println("배터리 타입 오류!");
			return null;
		}
		Battery bTmp = removeBattery();
		this.battery = battery;
		return bTmp;
	}
	
	//배터리 제거
	public Battery removeBattery() {
		Battery bTmp = null;
		if(battery != null) {
			bTmp = battery;
		}
		return bTmp;
	}
	
	//녹음
	public void rec(String message) {
		System.out.println("rec()" + battery.getCap());
		if(battery == null)
			return;
		int w = battery.plus(REC_W);
		if(w == REC_W) {
			message = message;
		}
	}
	
	//출력
	public void speek() {
		System.out.println("speek()");
		int w = battery.plus(SPK_W);
		if(w == SPK_W)
			System.out.println("message:" + message);
		else
			System.out.println("...");
	}
	
}