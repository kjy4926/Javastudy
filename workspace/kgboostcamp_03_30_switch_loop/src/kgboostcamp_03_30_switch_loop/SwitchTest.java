package kgboostcamp_03_30_switch_loop;
import java.util.Scanner;

class SwitchProblems{
	// Quiz01
	// ���� �� ���� �Է� �޾� ��Ģ������ �ϴ� ���� �����
	public static void calculator() {
		double result = 0; // �����, �������� �ϹǷ� double
		boolean flag = false; // ������ ���� �Է� �Ǵ�
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �Է� : ");
		String operation = scan.next(); // ������
		System.out.print("ù��° ���� �Է��ϼ��� : ");
		int n1 = scan.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		int n2 = scan.nextInt();
		
		switch(operation) {
		case "+":
			result = n1+n2;
			flag = true;
			break;
		case "-":
			result = n1-n2;
			flag = true;
			break;
		case "*":
			result = n1*n2;
			flag = true;
			break;
		case "/":
			result = (double)n1/(double)n2;
			flag = true;
			break;
		default:
			flag = false;
			System.out.println("�߸��� ������ �Է��Դϴ�.");
			break;
		}
		if(flag) {
			System.out.printf("%d %s %d = %.2f\n", n1, operation, n2, result);
		}
	}
	// Quiz 02
	// ����ǥ �����
	public static void grades() {
		String grade = "F"; // ����
		int score = 0; // ����
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		score = scan.nextInt();
		switch(score/10) {
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default :
			grade = "F";
			break;
		}
		if(score % 10 >= 5 && grade != "F") {
			grade += "+";
		}
		System.out.println("���� : " + grade);
	}
	// Quiz 03
	// �޴� ����� �������α׷� �����
	// 1. �л� �̸� ���
	// 2. ����, ����, ���� ���� �Է�
	// 3. �л� �̸� ���
	// 4. ���� ���
	public static void menu() {
		String name = "default name";
		int korean = 0;
		int english = 0;
		int math = 0;
		int sum = 0;
		double avg = 0;
		int operation = 6; //  ����
		Scanner scan = new Scanner(System.in);

		System.out.println("1. �л� �̸� ���\r\n" + 
				"2. ����, ����, ���� ���� �Է�\r\n" + 
				"3. �л� �̸� ���\r\n" + 
				"4. ���� ���\n");
		System.out.print("�޴��� �����ϼ��� : ");
		operation = scan.nextInt();
		scan.nextLine(); // buffer clear
		
		switch(operation) {
		case 1:
			System.out.println("�л� �̸� ��� �޴��Դϴ�.");
			System.out.print("����� �̸��� �Է��ϼ��� : ");
			name = scan.nextLine();
			System.out.printf("����Ͻ� �̸��� %s�Դϴ�.\n", name);
			break;
		case 2:
			System.out.println("���� ���� ���� ���� �Է� �޴��Դϴ�.");
			System.out.print("���� ������ �Է��ϼ��� : ");
			korean = scan.nextInt();
			System.out.print("���� ������ �Է��ϼ��� : ");
			english = scan.nextInt();
			System.out.print("���� ������ �Է��ϼ��� : ");
			math = scan.nextInt();
			scan.nextLine(); // buffer clear
			sum = korean + english + math;
			avg = sum/3.0;
			break;
		case 3:
			System.out.println("�л� �̸� ��� �޴��Դϴ�.");
			System.out.println("���� �л��� �̸� : " + name);
			break;
		case 4:
			System.out.println("���� ��� �޴��Դϴ�.");
			System.out.println("���� : " + sum);
			break;
		case 5:
			System.out.println("��� ��� �޴��Դϴ�.");
			System.out.println("��� : " + avg);
			break;
		case 6:
			System.out.println("�����մϴ�.");
			break;
		default :
			System.out.println("�������� �ʴ� �޴��Դϴ�.");
			break;
		}
	}
}

public class SwitchTest {
	public static void main(String[] args) {
		//SwitchProblems.calculator();
		//SwitchProblems.grades();
		SwitchProblems.menu();
	}
}