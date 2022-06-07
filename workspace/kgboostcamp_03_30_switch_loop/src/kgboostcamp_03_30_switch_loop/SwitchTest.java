package kgboostcamp_03_30_switch_loop;
import java.util.Scanner;

class SwitchProblems{
	// Quiz01
	// 정수 두 개를 입력 받아 사칙연산을 하는 계산기 만들기
	public static void calculator() {
		double result = 0; // 결과값, 나눗셈도 하므로 double
		boolean flag = false; // 연산자 정상 입력 판단
		Scanner scan = new Scanner(System.in);
		System.out.print("연산자 입력 : ");
		String operation = scan.next(); // 연산자
		System.out.print("첫번째 수를 입력하세요 : ");
		int n1 = scan.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
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
			System.out.println("잘못된 연산자 입력입니다.");
			break;
		}
		if(flag) {
			System.out.printf("%d %s %d = %.2f\n", n1, operation, n2, result);
		}
	}
	// Quiz 02
	// 성적표 만들기
	public static void grades() {
		String grade = "F"; // 학점
		int score = 0; // 점수
		Scanner scan = new Scanner(System.in);
		System.out.print("성적 입력 : ");
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
		System.out.println("학점 : " + grade);
	}
	// Quiz 03
	// 메뉴 만들어 관리프로그램 만들기
	// 1. 학생 이름 등록
	// 2. 국어, 영어, 수학 점수 입력
	// 3. 학생 이름 출력
	// 4. 총점 출력
	public static void menu() {
		String name = "default name";
		int korean = 0;
		int english = 0;
		int math = 0;
		int sum = 0;
		double avg = 0;
		int operation = 6; //  종료
		Scanner scan = new Scanner(System.in);

		System.out.println("1. 학생 이름 등록\r\n" + 
				"2. 국어, 영어, 수학 점수 입력\r\n" + 
				"3. 학생 이름 출력\r\n" + 
				"4. 총점 출력\n");
		System.out.print("메뉴를 선택하세요 : ");
		operation = scan.nextInt();
		scan.nextLine(); // buffer clear
		
		switch(operation) {
		case 1:
			System.out.println("학생 이름 등록 메뉴입니다.");
			System.out.print("등록할 이름을 입력하세요 : ");
			name = scan.nextLine();
			System.out.printf("등록하신 이름은 %s입니다.\n", name);
			break;
		case 2:
			System.out.println("국어 영어 수학 점수 입력 메뉴입니다.");
			System.out.print("국어 성적을 입력하세요 : ");
			korean = scan.nextInt();
			System.out.print("영어 성적을 입력하세요 : ");
			english = scan.nextInt();
			System.out.print("수학 성적을 입력하세요 : ");
			math = scan.nextInt();
			scan.nextLine(); // buffer clear
			sum = korean + english + math;
			avg = sum/3.0;
			break;
		case 3:
			System.out.println("학생 이름 출력 메뉴입니다.");
			System.out.println("현재 학생의 이름 : " + name);
			break;
		case 4:
			System.out.println("총점 출력 메뉴입니다.");
			System.out.println("총점 : " + sum);
			break;
		case 5:
			System.out.println("평균 출력 메뉴입니다.");
			System.out.println("평균 : " + avg);
			break;
		case 6:
			System.out.println("종료합니다.");
			break;
		default :
			System.out.println("존재하지 않는 메뉴입니다.");
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