package kgboostcamp_03_30_switch_loop;
import java.util.Scanner;

class Solution {
	public static int n = 10;
	public static void multiplicationTable() {
		for(int i=2;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.printf("%d*%d=%2d ", i,j,i*j);
			}
			System.out.println();
		}
	}
	public static void mouse() {
		int rice = 8000000; // 100 * 80 * 1000 g
		int mouse_num = 2; // 암 수 한마리씩 2마리
		int mouse_increase = 10;
		int one_day_eat = 20;
		int count = 1;
		while(rice > 0) {
			rice -= (mouse_num * one_day_eat);
			count++;
			if(count % mouse_increase == 0) {
				mouse_num *= 2;
			}
		}
		System.out.println("days : " + count);
		System.out.println("mouse : " + mouse_num);
	}
	public static void deposit() {
		int day = 30;
		int deposit_money = 10;
		long money = 0;
		for(int i=0; i<day; i++) {
			money += deposit_money;
			deposit_money *= 2;
		}
		System.out.println(money + "원");
	}
	public static void oddNumSum() {
		int maxSum = 10000;
		int sum = 0;
		int oddNum = 1;
		while(true) {
			sum += oddNum;
			if(sum >= maxSum) {
				break;
			}
			oddNum += 2;
		}
		System.out.printf("합이 %d를 넘지 않는 마지막 홀수 : %d", maxSum, oddNum);
	}
}

class StarSolution {
	public static void star01() {
		for(int i=0;i<5;i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	public static void star02() {
		for(int i=0;i<5;i++) {
			System.out.println("*");
		}
	}
	public static void star03() {
		for(int i=0;i<5;i++) {
			System.out.println("*****");
		}
	}
	public static void star04() {
		for(int i=1;i<6;i++) {
			System.out.printf("%d%d%d%d%d\n", i,i,i,i,i);
		}
	}
	public static void star05() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d", j+1);
			}
			System.out.println();
		}
	}
	public static void star06() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d", j+i+1);
			}
			System.out.println();
		}
	}
	public static void star07() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<5;j++) {
				System.out.printf("%d", j+i);
			}
			System.out.println();
		}
	}
	public static void star08() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void star09() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void star10() {
		for(int i=5;i>0;i--) {
			String star = "";
			for(int j=0;j<i;j++) {
				star += "*";
			}
			System.out.printf("%5s\n", star);
		}
	}
	public static void star11() {
		for(int i=0;i<5;i++) {
			String star = "";
			for(int j=0;j<i+1;j++) {
				star += "*";
			}
			System.out.printf("%s\n", star);
		}
	}
}

public class LoopSolution {
	public static void main(String[] args) {
//		Solution.multiplicationTable();
//		Solution.mouse();
//		Solution.deposit();
//		Solution.oddNumSum();	
		StarSolution.star10();
	}
}