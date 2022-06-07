package kgboostcamp_04_06_array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	// 배열 길이 입력받아서 배열 생성하고 값 정렬해보기
	public static void solution07() {
		Scanner scan = new Scanner(System.in);
		System.out.print("생성할 배열의 길이 입력하세요 : ");
		int n = scan.nextInt(); // 배열의 길이
		int[] arr = new int[n]; // 값을 담을 배열
		System.out.println("값을 입력하세요.");
		for(int i=0;i<n;i++) {
			System.out.printf("%d번째 값 : ", i+1);
			arr[i] = scan.nextInt();
		}
		System.out.println("배열에 입력된 값은 : " + Arrays.toString(arr) + " 입니다.");
		Arrays.sort(arr);
		System.out.println("정렬 후 값은 : " + Arrays.toString(arr));
	}
	// 무한 배열
	// 초기 배열 길이 3, 배열 길이는 지속적으로 3씩 늘어나게 구현함
	public static void solution08() {
		Scanner scan = new Scanner(System.in);
		String value = "";
		String[] str_arr = new String[3]; // 길이 3으로 배열 초기화
		int count = 0; // 배열 인자 수 count
		while(true) {
			System.out.printf("입력(현재길이:%d) : ", str_arr.length);
			String input = scan.nextLine(); // 입력값
			str_arr[count] = input;
			value += (input+ ", ");
			count++;
			System.out.println(value);
			if(str_arr.length == count) {
				String[] new_arr = new String[str_arr.length+3]; // 길이 늘리기
				// 이미 했던걸 반복하므로 성능이 안좋으나 제일 간단한 방법
				// 제약 상 Arrays, ArrayList 모듈은 사용하지 않음
				for(int i=0;i<str_arr.length;i++) {
					new_arr[i] = str_arr[i]; 
				}
				str_arr = new_arr.clone(); // Deep Copy
			}
		}
	}
	public static void solution09Int() {
		Scanner scan = new Scanner(System.in);
		String value = "";
		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.printf("입력(현재길이:%d) : ", arr.size());
		while(true) {
			int input = scan.nextInt();
			if(input == -1)break;
			if(arr.contains(input)) {
				System.out.println("중복!");
			}
			else {
				arr.add(input);
				value += (Integer.toString(input)+", ");
				System.out.println(value);
			}
		}
		scan.close();
	}
	public static void solution09String() {
		Scanner scan = new Scanner(System.in);
		String value = "";
		ArrayList<String> arr = new ArrayList<String>();
		while(true) {
			System.out.printf("입력(현재길이:%d) : ", arr.size());
			String input = scan.nextLine();
			if(input.equals("quit"))break;
			if(arr.contains(input)) {
				System.out.println("중복!");
			}
			else {
				arr.add(input);
				value += (input+", ");
				System.out.println(value);
			}
		}
		scan.close();
	}
	public static void selfNumber() {
		// Algorithm -> Brute force searching
		// 1부터 순서대로 탐색하여 생성되는 수는 false로 변경
		// 이 과정을 max(5000)까지 반복
		int max = 10000; // 최댓값
		boolean[] selfnum = new boolean[max]; // 1~max selfnum 판단
		int sum = 0; // 리턴할 총합
		// 배열 초기화
		for(int i=0;i<max;i++) {
			selfnum[i] = true;
		}
		for(int i=1;i<max+1;i++) {
			int thousand = i/1000; // 천의 자리수
			int hundred = (i%1000)/100; // 백의 자리수
			int ten = (i%100)/10; // 십의 자리수
			int one = (i%10); // 일의 자리수
			int new_num = i+thousand+hundred+ten+one;
			if(new_num <= max) {
				selfnum[new_num-1] = false;
			}
		}
		for(int i=0;i<max;i++) {
			if(selfnum[i]==true) {
				sum += (i+1);
			}
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		selfNumber();
	}
}