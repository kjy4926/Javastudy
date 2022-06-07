import java.util.Scanner;
class Problems{
	// 입력한 데이터가 3의 배수인 경우 출력하시오.
	public static void problem01(int n) {
		if(n % 3 == 0) {
			System.out.printf("%d -> 3의 배수입니다.\n", n);
		}
		else {
			System.out.printf("%d -> 3의 배수가 아닙니다.\n", n);
		}
	}
	// 수를 입력 받아 짝, 홀수를 구분하여 출력하시오.
	public static void problem02(int n) {
		if(n == 0) {
			System.out.printf("%d -> 0입니다.\n", n);
		}
		else if(n%2==1) {
			System.out.printf("%d -> 홀수입니다.\n", n);
		}
		else {
			System.out.printf("%d -> 짝수입니다.\n", n);
		}
	}	
	// 두 수를 입력 받아 큰 수를 출력하시오.
	public static void problem03(int n, int m) {
		if(n == m) {
			System.out.println("두 수는 동일합니다.\n");
		}
		else if(n > m) {
			System.out.printf("큰 수는 %d 입니다.\n", n);
		}
		else {
			System.out.printf("큰 수는 %d 입니다.\n", m);
		}
	}
	// 세 수를 입력 받아 큰 순서대로 출력하시오.
	public static void problem04(int n, int m, int l) {
		// 2번째 수(m)이 가장 큰 경우
		if(m >= n && m >= l) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		// 3번째 수(l)이 가장 큰 경우
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
	// 두 수를 입력 받아 큰 수가 짝수이면 출력하시오.
	public static void problem05(int n, int m) {
		if(n == m) {
			System.out.println("두 수는 동일합니다.\n");
		}
		else if(n > m) {
			if(n % 2 == 0) {
				System.out.printf("큰 수 %d -> 짝수입니다.\n", n);
			}
			else {
				System.out.printf("큰 수 %d -> 짝수가 아닙니다.\n", n);
			}
		}
		else {
			if(m % 2 == 0) {
				System.out.printf("큰 수 %d -> 짝수입니다.\n", m);
			}
			else {
				System.out.printf("큰 수 %d -> 짝수가 아닙니다.\n", m);
			}
		}
	}
	// 두 수를 입력 받아 합이 짝수이고 3의 배수면 출력하시오.
	public static void problem06(int n, int m) {
		int sum = n+m;
		if(sum % 2 == 0 && sum % 3 == 0) {
			System.out.printf("두 수의 합 %d -> 짝수이면서 3의 배수입니다.\n", sum);
		}
		else {
			System.out.printf("두 수의 합 %d -> 짝수이면서 3의 배수가 아닙니다.\n", sum);
		}
	}
	// 수를 입력 받아 출력하시오.
	// 단, 3의 배수는 제외하고 3의 배수이면서 5의 배수인 수는 출력
	public static void problem07(int n) {
		if(n % 3 != 0 || n % 5 == 0) {
			System.out.println(n);
		}
	}
	public static void printTable() {
		System.out.println("------------------------------------------------------");
		System.out.println("1. 입력한 데이터가 3의 배수인 경우 출력");
		System.out.println("2. 수를 입력 받아 짝/홀수를 구분하여 출력");
		System.out.println("3. 두 수를 입력 받아 큰 수를 출력");
		System.out.println("4. 세 수를 입력 받아 큰 순서대로 출력");
		System.out.println("5. 두 수를 입력 받아 큰 수가 짝수이면 출력");
		System.out.println("6. 두 수를 입력 받아 합이 짝수이고 3의 배수면 출력");
		System.out.println("7. 수를 입력 받아 출력(단 3의 배수 제외, 3의 배수이며 5의 배수이면 출력)");
		System.out.println("------------------------------------------------------");
	}
}

public class IfElse {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Problems.printTable();
		System.out.print("예제 번호를 입력하세요 >> ");
		int flag = scan.nextInt();
		scan.nextLine(); // buffer clear
		// 수를 하나만 입력 받는 경우
		if (flag == 1 || flag == 2 || flag == 7) {
			System.out.print("수를 입력하세요 : ");
			int n = scan.nextInt();
			if (flag == 1) {
				Problems.problem01(n);
			}
			else if(flag == 2) {
				Problems.problem02(n);
			}
			else { Problems.problem07(n); }
		}
		// 수를 둘 입력 받는 경우
		else if (flag == 3 || flag == 5 || flag == 6) {
			System.out.print("첫번째 수를 입력하세요 : ");
			int n = scan.nextInt();
			System.out.print("두번째 수를 입력하세요 : ");
			int m = scan.nextInt();
			if (flag == 3) {
				Problems.problem03(n, m);
			}
			else if(flag == 5) {
				Problems.problem05(n, m);
			}
			else { Problems.problem06(n, m); }
		}
		// 수를 셋 입력 받는 경우
		else if (flag == 4) {
			System.out.print("첫번째 수를 입력하세요 : ");
			int n = scan.nextInt();
			System.out.print("두번째 수를 입력하세요 : ");
			int m = scan.nextInt();
			System.out.print("세번째 수를 입력하세요 : ");
			int l = scan.nextInt();
			Problems.problem04(n, m, l);
		}
		// error
		else {
			System.out.println("잘못된 입력입니다.\n");
		}
		scan.close();
	}
}