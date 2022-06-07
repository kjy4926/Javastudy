package kgboostcamp_04_11_class;

public class RemoteController {
	private TV target; // �������� ��ϵ� tv
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
		// TV�� ������ ��� �ν��Ͻ��� �����Ͽ� ����ϹǷ� static�� ������� �ʴ´�.
		TV tv1 = new TV();
		TV tv2 = new TV();
		RemoteController remote = new RemoteController(tv1); // tv1 ������

		System.out.println("TV1 TV2 �ʱ� ����");
		tv1.printInfo();
		tv2.printInfo();
		System.out.println("-----------------------------------------\nRemote�� �̿��� Setter ����");
		// tv1 Setter
		remote.setPower();
		remote.setChannel(33);
		remote.setVolume(50);
		// tv2 Setter
		remote.setTarget(tv2);
		remote.setPower();
		remote.setChannel(99);
		remote.setVolume(39);
		System.out.println("���� ä�� ���� ���� �� TV1 TV2 ���� ���");
		tv1.printInfo();
		tv2.printInfo();
	}
}