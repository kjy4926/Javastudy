import java.util.Scanner;

class Solutions{
	// ���� ź �ð��� �Է¹޾� ��� ���
	public static int amusementPrice(int time) {
		int price = 3000; // �ʱ� ����
		int perPrice = 500; // ���� �ð� �� �߰� �ݾ�
		int baseTime = 30; // �⺻ �ð�
		int perUseTime = 10; // ��� �߰� ���� �ð�
		if(time <= 0) {
			return 0;
		}
		if(time < baseTime) {
			return price;
		}
		else {
			int add = ((time-baseTime)/perUseTime) * perPrice; // �߰����
			int remain = time % perUseTime; // ¥���� �ð�
			if(remain != 0) {
				add += perPrice;
			}
			return price+add;
		}
	}
	// ��� ���ö� ������ ���� ��� ���
	public static int lunchBox(int n) {
		int price = 0; // ���� ���ö� ���
		int baseCount = 10; // ���ö� ���� ������ �⺻ ����
		int basePrice = 2500; // ���ö� �⺻��
		int discountPrice = 2400; // ���ö� ���ΰ�
		if(n <= 0) {
			return 0;
		}
		if(n <= baseCount) {
			price = basePrice * n;
		}
		else {
			price = discountPrice * n;
		}
		return price;
	}
	// x ���� ���� ���� �ݾ� ���
	public static int disket(int n) {
		int price = 0; // ���� ���
		int basePrice = 5000; // ��ũ �⺻��
		int firstDiscountNum = 10; // ù��° ��� ���� ���� ��ũ ���� ����
		int secondDiscountNum = 100; // �ι�° ��� ���� ���� ��ũ ���� ����
		double firstDiscountRate = 0.9; // ù��° ��� ������
		double secondDiscountRate = 0.88; // �ι�° ��� ������
		if(n <= 0) {
			return 0;
		}
		if(n < firstDiscountNum) {
			price = n * basePrice;
		}
		else if(n >= firstDiscountNum && n < secondDiscountNum) {
			price = (int)((n * basePrice) * firstDiscountRate);
		}
		else {
			price = (int)((n * basePrice) * secondDiscountRate);
		}
		return price;
	}
	public static char gradeCalculator(int g1, int g2, int g3) {
		int sum = g1 + g2 + g3; // ����
		double avg = sum/3.0; // ���
		char grade = 'F'; // ����
		
		int stdA = 90;
		int stdB = 80;
		int stdC = 70;
		int stdD = 60;
		
		if (avg >= stdA) {
			grade = 'A';
		}
		else if(avg >= stdB) {
			grade = 'B';
		}
		else if(avg >= stdC) {
			grade = 'C';
		}
		else if(avg >= stdD) {
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		return grade;
	}
}

public class Training {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 1�� ���� ����
		System.out.print("���� ź �ð��� �Է��ϼ��� : ");
		int time = scan.nextInt();
		System.out.println("�� ź ��� : " + Solutions.amusementPrice(time));
		
		// 2�� ���� ����
		System.out.print("���ö� ������ �Է��ϼ��� : ");
		int lunch_num = scan.nextInt();
		System.out.println("���ö� ��� : " + Solutions.lunchBox(lunch_num));
		
		// 3�� ���� ����
		System.out.print("���� ������ �Է��ϼ��� : ");
		int disk_num = scan.nextInt();
		System.out.println("���� ���� ��� : " + Solutions.disket(disk_num));
		
		// 4�� ���� ����
		System.out.print("1��° ������ �Է��ϼ��� : ");
		int g1 = scan.nextInt();
		System.out.print("2��° ������ �Է��ϼ��� : ");
		int g2 = scan.nextInt();
		System.out.print("3��° ������ �Է��ϼ��� : ");
		int g3 = scan.nextInt();
		System.out.println("���� : " + Solutions.gradeCalculator(g1, g2, g3));
	}
}