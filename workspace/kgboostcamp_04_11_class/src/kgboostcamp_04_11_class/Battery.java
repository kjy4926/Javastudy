package kgboostcamp_04_11_class;

public class Battery {
	private String made; // ������
	private String size; // �԰�
	private int capacity; // �԰� �뷮
	private double volt; // ����
	private int remain; // �ܷ�
	
	// Constructor
	// ������ ���� �̸� ������ �ִ� ������ ����
	Battery(){
		this.made = "����������";
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
		System.out.printf("������ : %s / �԰� : %s / �뷮 : %s\n���� : %.1fV / �ܷ� : %s\n",
				this.made, this.size, this.capacity,this.volt, this.remain);
	}
	public int getCapacity(int n) {
		this.remain -= n;
		return n;
	}
}