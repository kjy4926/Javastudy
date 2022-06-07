package kgboostcamp_03_30_switch_loop;
import java.util.Scanner;

class loopProblems{
	// 1부터 100까지의 합
	public static void problem01() {
		int sum = 0; // 합
		for(int i=1; i<101; i++) {
			sum += i;
		}
		System.out.println("1부터 100까지 숫자의 합 : " + sum);
	}
	// 1부터 100까지 홀수의 합과 짝수의 합
	public static void problem02() {
		int odd_num_sum = 0; // 홀수 합
		int even_num_sum = 0; // 짝수 합
		for(int i=1; i<101; i += 2) {
			odd_num_sum += i;
			even_num_sum += (i+1);
		}
		System.out.println("1부터 100까지 홀수의 합 : " + odd_num_sum);
		System.out.println("1부터 100까지 짝수의 합 : " + even_num_sum);
	}
	// 1부터 100까지 중 3의 배수만 출력
	public static void problem03() {
		for(int i=3; i<101; i+=3) {
			System.out.println(i);
		}
	}
	// 1부터 100까지의 수 중 3의 배수는 제외
	// 3의 배수이면서 5의 배수는 출력
	public static void problem04() {
		for(int i=1; i<101; i++) {
			if(i%3 != 0 || i%5 == 0) {
				System.out.println(i);
			}
		}
	}
	// 두 수를 입력 받아 두 수 사이의 합을 구하세요.
	public static void problem05() {
		int n1 = 0;
		int n2 = 0;
		int sum = 0; // 최종 합
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요 : ");
		n1 = scan.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
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
	// 사용자로부터 열 개의 정수를 입력 받아 평균을 구한다.
	public static void problem06() {
		int sum = 0;
		double avg = 0.0;
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			System.out.printf("%d번째 수를 입력하세요 : ", i+1);
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
