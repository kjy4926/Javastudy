import java.util.Scanner;
class Problems{
	// �Է��� �����Ͱ� 3�� ����� ��� ����Ͻÿ�.
	public static void problem01(int n) {
		if(n % 3 == 0) {
			System.out.printf("%d -> 3�� ����Դϴ�.\n", n);
		}
		else {
			System.out.printf("%d -> 3�� ����� �ƴմϴ�.\n", n);
		}
	}
	// ���� �Է� �޾� ¦, Ȧ���� �����Ͽ� ����Ͻÿ�.
	public static void problem02(int n) {
		if(n == 0) {
			System.out.printf("%d -> 0�Դϴ�.\n", n);
		}
		else if(n%2==1) {
			System.out.printf("%d -> Ȧ���Դϴ�.\n", n);
		}
		else {
			System.out.printf("%d -> ¦���Դϴ�.\n", n);
		}
	}	
	// �� ���� �Է� �޾� ū ���� ����Ͻÿ�.
	public static void problem03(int n, int m) {
		if(n == m) {
			System.out.println("�� ���� �����մϴ�.\n");
		}
		else if(n > m) {
			System.out.printf("ū ���� %d �Դϴ�.\n", n);
		}
		else {
			System.out.printf("ū ���� %d �Դϴ�.\n", m);
		}
	}
	// �� ���� �Է� �޾� ū ������� ����Ͻÿ�.
	public static void problem04(int n, int m, int l) {
		// 2��° ��(m)�� ���� ū ���
		if(m >= n && m >= l) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		// 3��° ��(l)�� ���� ū ���
		else if(l >= n && l >= m) {
			int tmp = n;
			n = l;
			l = tmp;
		}
		if(l > m) {
			int tmp = m;
			m = l;
			l = tmp;
		}
		System.out.printf("%d %d %d\n", n, m, l);
	}
	// �� ���� �Է� �޾� ū ���� ¦���̸� ����Ͻÿ�.
	public static void problem05(int n, int m) {
		if(n == m) {
			System.out.println("�� ���� �����մϴ�.\n");
		}
		else if(n > m) {
			if(n % 2 == 0) {
				System.out.printf("ū �� %d -> ¦���Դϴ�.\n", n);
			}
			else {
				System.out.printf("ū �� %d -> ¦���� �ƴմϴ�.\n", n);
			}
		}
		else {
			if(m % 2 == 0) {
				System.out.printf("ū �� %d -> ¦���Դϴ�.\n", m);
			}
			else {
				System.out.printf("ū �� %d -> ¦���� �ƴմϴ�.\n", m);
			}
		}
	}
	// �� ���� �Է� �޾� ���� ¦���̰� 3�� ����� ����Ͻÿ�.
	public static void problem06(int n, int m) {
		int sum = n+m;
		if(sum % 2 == 0 && sum % 3 == 0) {
			System.out.printf("�� ���� �� %d -> ¦���̸鼭 3�� ����Դϴ�.\n", sum);
		}
		else {
			System.out.printf("�� ���� �� %d -> ¦���̸鼭 3�� ����� �ƴմϴ�.\n", sum);
		}
	}
	// ���� �Է� �޾� ����Ͻÿ�.
	// ��, 3�� ����� �����ϰ� 3�� ����̸鼭 5�� ����� ���� ���
	public static void problem07(int n) {
		if(n % 3 != 0 || n % 5 == 0) {
			System.out.println(n);
		}
	}
	public static void printTable() {
		System.out.println("------------------------------------------------------");
		System.out.println("1. �Է��� �����Ͱ� 3�� ����� ��� ���");
		System.out.println("2. ���� �Է� �޾� ¦/Ȧ���� �����Ͽ� ���");
		System.out.println("3. �� ���� �Է� �޾� ū ���� ���");
		System.out.println("4. �� ���� �Է� �޾� ū ������� ���");
		System.out.println("5. �� ���� �Է� �޾� ū ���� ¦���̸� ���");
		System.out.println("6. �� ���� �Է� �޾� ���� ¦���̰� 3�� ����� ���");
		System.out.println("7. ���� �Է� �޾� ���(�� 3�� ��� ����, 3�� ����̸� 5�� ����̸� ���)");
		System.out.println("------------------------------------------------------");
	}
}

public class IfElse {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Problems.printTable();
		System.out.print("���� ��ȣ�� �Է��ϼ��� >> ");
		int flag = scan.nextInt();
		scan.nextLine(); // buffer clear
		// ���� �ϳ��� �Է� �޴� ���
		if (flag == 1 || flag == 2 || flag == 7) {
			System.out.print("���� �Է��ϼ��� : ");
			int n = scan.nextInt();
			if (flag == 1) {
				Problems.problem01(n);
			}
			else if(flag == 2) {
				Problems.problem02(n);
			}
			else { Problems.problem07(n); }
		}
		// ���� �� �Է� �޴� ���
		else if (flag == 3 || flag == 5 || flag == 6) {
			System.out.print("ù��° ���� �Է��ϼ��� : ");
			int n = scan.nextInt();
			System.out.print("�ι�° ���� �Է��ϼ��� : ");
			int m = scan.nextInt();
			if (flag == 3) {
				Problems.problem03(n, m);
			}
			else if(flag == 5) {
				Problems.problem05(n, m);
			}
			else { Problems.problem06(n, m); }
		}
		// ���� �� �Է� �޴� ���
		else if (flag == 4) {
			System.out.print("ù��° ���� �Է��ϼ��� : ");
			int n = scan.nextInt();
			System.out.print("�ι�° ���� �Է��ϼ��� : ");
			int m = scan.nextInt();
			System.out.print("����° ���� �Է��ϼ��� : ");
			int l = scan.nextInt();
			Problems.problem04(n, m, l);
		}
		// error
		else {
			System.out.println("�߸��� �Է��Դϴ�.\n");
		}
		scan.close();
	}
}