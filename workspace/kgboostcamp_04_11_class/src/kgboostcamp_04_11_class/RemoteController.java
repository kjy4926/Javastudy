package kgboostcamp_04_11_class;

public class RemoteController {
	private TV target; // 리모컨에 등록된 tv
	RemoteController(TV tv){
		this.target = tv;
	}
	public void setTarget(TV tv) {
		this.target = tv;
	}
	public void setPower() {
		this.target.setPower();
	}
	public void setChannel(int n) {
		this.target.setChannel(n);
	}
	public void setVolume(int n) {
		this.target.setVolume(n);
	}
	
	public static void main(String[] args) {
		// TV와 리모컨 모두 인스턴스로 생성하여 사용하므로 static은 사용하지 않는다.
		TV tv1 = new TV();
		TV tv2 = new TV();
		RemoteController remote = new RemoteController(tv1); // tv1 리모컨

		System.out.println("TV1 TV2 초기 정보");
		tv1.printInfo();
		tv2.printInfo();
		System.out.println("-----------------------------------------\nRemote를 이용한 Setter 진행");
		// tv1 Setter
		remote.setPower();
		remote.setChannel(33);
		remote.setVolume(50);
		// tv2 Setter
		remote.setTarget(tv2);
		remote.setPower();
		remote.setChannel(99);
		remote.setVolume(39);
		System.out.println("전원 채널 볼륨 세팅 후 TV1 TV2 정보 출력");
		tv1.printInfo();
		tv2.printInfo();
	}
}