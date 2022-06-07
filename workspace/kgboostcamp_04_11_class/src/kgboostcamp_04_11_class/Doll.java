package kgboostcamp_04_11_class;

public class Doll {
	private String message;
	private Battery battery;
	private int useCost;
	
	Doll(){
		this.message = "default";
		useCost = 600;
	}
	
	// ������ ����
	public void setBattery(Battery b) {
		System.out.println("������ ����");
		this.battery = b;
		System.out.println("-- ���� ������ ���� --\n--------------------");
		b.printInfo();
	}
	// ���� �Է�
	public void setMessage(String m) {
		this.message = m;
	}
	// ���� ���
	// ���� ��� �� ���͸��� ����Ѵٰ� ����
	public String getMessage() {
		// ���͸� �ܷ��� ����ϴٸ�
		if(battery.use(useCost)) {
			int get = battery.getCapacity(useCost); // ���͸� ���
			System.out.printf("���͸� %d ���!\n", get);
			return this.message;
		}
		// ���͸��� �����ϴٸ�
		else {
			return "�������� �����մϴ�.";
		}
	}
	public static void main(String[] args) {
		Doll d1 = new Doll();
		Doll d2 = new Doll();
		
		d1.setBattery(new Battery());
		d2.setBattery(new Battery());
		// ������ ���� �Է�
		d1.setMessage("�ȳ��ϼ���!!!!!!!!");
		d2.setMessage("KG ��Ʈķ�� �Դϴ�.");
		
		System.out.println("------���� ���------");
		for(int i=0; i<3; i++) {
			System.out.println(d1.getMessage());
			System.out.println(d2.getMessage());
		}
	}
}
