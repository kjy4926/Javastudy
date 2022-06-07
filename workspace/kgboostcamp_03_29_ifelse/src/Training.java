import java.util.Scanner;

class Solutions{
	// 말을 탄 시간을 입력받아 요금 계산
	public static int amusementPrice(int time) {
		int price = 3000; // 초기 가격
		int perPrice = 500; // 기준 시간 당 추가 금액
		int baseTime = 30; // 기본 시간
		int perUseTime = 10; // 요금 추가 기준 시간
		if(time <= 0) {
			return 0;
		}
		if(time < baseTime) {
			return price;
		}
		else {
			int add = ((time-baseTime)/perUseTime) * perPrice; // 추가요금
			int remain = time % perUseTime; // 짜투리 시간
			if(remain != 0) {
				add += perPrice;
			}
			return price+add;
		}
	}
	// 배달 도시락 개수에 따른 요금 계산
	public static int lunchBox(int n) {
		int price = 0; // 최종 도시락 요금
		int baseCount = 10; // 도시락 할인 미적용 기본 개수
		int basePrice = 2500; // 도시락 기본가
		int discountPrice = 2400; // 도시락 할인가
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
	// x 통의 디스켓 구매 금액 계산
	public static int disket(int n) {
		int price = 0; // 구매 요금
		int basePrice = 5000; // 디스크 기본가
		int firstDiscountNum = 10; // 첫번째 등급 할인 적용 디스크 구매 개수
		int secondDiscountNum = 100; // 두번째 등급 할인 적용 디스크 구매 개수
		double firstDiscountRate = 0.9; // 첫번째 등급 할인율
		double secondDiscountRate = 0.88; // 두번째 등급 할인율
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
		int sum = g1 + g2 + g3; // 총합
		double avg = sum/3.0; // 평균
		char grade = 'F'; // 학점
		
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
		// 1번 문제 실행
		System.out.print("말을 탄 시간을 입력하세요 : ");
		int time = scan.nextInt();
		System.out.println("말 탄 요금 : " + Solutions.amusementPrice(time));
		
		// 2번 문제 실행
		System.out.print("도시락 개수를 입력하세요 : ");
		int lunch_num = scan.nextInt();
		System.out.println("도시락 요금 : " + Solutions.lunchBox(lunch_num));
		
		// 3번 문제 실행
		System.out.print("디스켓 개수를 입력하세요 : ");
		int disk_num = scan.nextInt();
		System.out.println("디스켓 구매 요금 : " + Solutions.disket(disk_num));
		
		// 4번 문제 실행
		System.out.print("1번째 성적을 입력하세요 : ");
		int g1 = scan.nextInt();
		System.out.print("2번째 성적을 입력하세요 : ");
		int g2 = scan.nextInt();
		System.out.print("3번째 성적을 입력하세요 : ");
		int g3 = scan.nextInt();
		System.out.println("학점 : " + Solutions.gradeCalculator(g1, g2, g3));
	}
}