package kgboostcamp_03_28;
import java.util.Scanner;

public class PrintPractice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // keyboard input scanner
		System.out.print("이니셜 입력 : ");
		String init = scan.nextLine();
		
		System.out.printf("당신의 이니셜은 %S입니다.\n", init);
		
		int i = 0;
		int[] grades = new int[3];
		int sum = 0;
		while(i < 3) {
			System.out.printf("%d번째 과목 성적 입력 : ", i+1);
			grades[i] = scan.nextInt();
			sum += grades[i];
			i++;
		}
		scan.nextLine(); // buffer clear
		
		System.out.printf("3과목 총합 점수 : %d\n3과목 평균 점수 : %.2f\n", sum, (double)sum/3);
		System.out.print("당신의 이름은 무엇입니까? : ");
		String name = scan.nextLine();
		System.out.printf("%s의 나이는 몇 살입니까? : ", name);
		int age = scan.nextInt();
		System.out.printf("%s님의 나이는 %d살입니다.\n", name, age);
		scan.close();
	}
}