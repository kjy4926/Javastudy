package kgboostcamp_03_28;
import java.util.Scanner;

public class PrintPractice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // keyboard input scanner
		System.out.print("�̴ϼ� �Է� : ");
		String init = scan.nextLine();
		
		System.out.printf("����� �̴ϼ��� %S�Դϴ�.\n", init);
		
		int i = 0;
		int[] grades = new int[3];
		int sum = 0;
		while(i < 3) {
			System.out.printf("%d��° ���� ���� �Է� : ", i+1);
			grades[i] = scan.nextInt();
			sum += grades[i];
			i++;
		}
		scan.nextLine(); // buffer clear
		
		System.out.printf("3���� ���� ���� : %d\n3���� ��� ���� : %.2f\n", sum, (double)sum/3);
		System.out.print("����� �̸��� �����Դϱ�? : ");
		String name = scan.nextLine();
		System.out.printf("%s�� ���̴� �� ���Դϱ�? : ", name);
		int age = scan.nextInt();
		System.out.printf("%s���� ���̴� %d���Դϴ�.\n", name, age);
		scan.close();
	}
}