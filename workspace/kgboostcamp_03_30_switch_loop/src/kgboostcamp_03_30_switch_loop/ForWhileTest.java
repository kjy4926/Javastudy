package kgboostcamp_03_30_switch_loop;
import java.util.Scanner;

class loopProblems{
	// 1���� 100������ ��
	public static void problem01() {
		int sum = 0; // ��
		for(int i=1; i<101; i++) {
			sum += i;
		}
		System.out.println("1���� 100���� ������ �� : " + sum);
	}
	// 1���� 100���� Ȧ���� �հ� ¦���� ��
	public static void problem02() {
		int odd_num_sum = 0; // Ȧ�� ��
		int even_num_sum = 0; // ¦�� ��
		for(int i=1; i<101; i += 2) {
			odd_num_sum += i;
			even_num_sum += (i+1);
		}
		System.out.println("1���� 100���� Ȧ���� �� : " + odd_num_sum);
		System.out.println("1���� 100���� ¦���� �� : " + even_num_sum);
	}
	// 1���� 100���� �� 3�� ����� ���
	public static void problem03() {
		for(int i=3; i<101; i+=3) {
			System.out.println(i);
		}
	}
	// 1���� 100������ �� �� 3�� ����� ����
	// 3�� ����̸鼭 5�� ����� ���
	public static void problem04() {
		for(int i=1; i<101; i++) {
			if(i%3 != 0 || i%5 == 0) {
				System.out.println(i);
			}
		}
	}
	// �� ���� �Է� �޾� �� �� ������ ���� ���ϼ���.
	public static void problem05() {
		int n1 = 0;
		int n2 = 0;
		int sum = 0; // ���� ��
		Scanner scan = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��ϼ��� : ");
		n1 = scan.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		n2 = scan.nextInt();
		// swap
		if(n2 < n1) {
			int tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		for(int i = n1; i<=n2; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	// ����ڷκ��� �� ���� ������ �Է� �޾� ����� ���Ѵ�.
	public static void problem06() {
		int sum = 0;
		double avg = 0.0;
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			System.out.printf("%d��° ���� �Է��ϼ��� : ", i+1);
			sum += scan.nextInt();
		}
		avg = sum/10.0;
		System.out.println(avg);
	}
}

public class ForWhileTest {
	public static void main(String[] args) {
		loopProblems.problem01();
		loopProblems.problem02();
		loopProblems.problem03();
		loopProblems.problem04();
		loopProblems.problem05();
		loopProblems.problem06();
	}
}
