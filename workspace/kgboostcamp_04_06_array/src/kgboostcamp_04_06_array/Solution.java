package kgboostcamp_04_06_array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	// �迭 ���� �Է¹޾Ƽ� �迭 �����ϰ� �� �����غ���
	public static void solution07() {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �迭�� ���� �Է��ϼ��� : ");
		int n = scan.nextInt(); // �迭�� ����
		int[] arr = new int[n]; // ���� ���� �迭
		System.out.println("���� �Է��ϼ���.");
		for(int i=0;i<n;i++) {
			System.out.printf("%d��° �� : ", i+1);
			arr[i] = scan.nextInt();
		}
		System.out.println("�迭�� �Էµ� ���� : " + Arrays.toString(arr) + " �Դϴ�.");
		Arrays.sort(arr);
		System.out.println("���� �� ���� : " + Arrays.toString(arr));
	}
	// ���� �迭
	// �ʱ� �迭 ���� 3, �迭 ���̴� ���������� 3�� �þ�� ������
	public static void solution08() {
		Scanner scan = new Scanner(System.in);
		String value = "";
		String[] str_arr = new String[3]; // ���� 3���� �迭 �ʱ�ȭ
		int count = 0; // �迭 ���� �� count
		while(true) {
			System.out.printf("�Է�(�������:%d) : ", str_arr.length);
			String input = scan.nextLine(); // �Է°�
			str_arr[count] = input;
			value += (input+ ", ");
			count++;
			System.out.println(value);
			if(str_arr.length == count) {
				String[] new_arr = new String[str_arr.length+3]; // ���� �ø���
				// �̹� �ߴ��� �ݺ��ϹǷ� ������ �������� ���� ������ ���
				// ���� �� Arrays, ArrayList ����� ������� ����
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
		System.out.printf("�Է�(�������:%d) : ", arr.size());
		while(true) {
			int input = scan.nextInt();
			if(input == -1)break;
			if(arr.contains(input)) {
				System.out.println("�ߺ�!");
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
			System.out.printf("�Է�(�������:%d) : ", arr.size());
			String input = scan.nextLine();
			if(input.equals("quit"))break;
			if(arr.contains(input)) {
				System.out.println("�ߺ�!");
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
		// 1���� ������� Ž���Ͽ� �����Ǵ� ���� false�� ����
		// �� ������ max(5000)���� �ݺ�
		int max = 10000; // �ִ�
		boolean[] selfnum = new boolean[max]; // 1~max selfnum �Ǵ�
		int sum = 0; // ������ ����
		// �迭 �ʱ�ȭ
		for(int i=0;i<max;i++) {
			selfnum[i] = true;
		}
		for(int i=1;i<max+1;i++) {
			int thousand = i/1000; // õ�� �ڸ���
			int hundred = (i%1000)/100; // ���� �ڸ���
			int ten = (i%100)/10; // ���� �ڸ���
			int one = (i%10); // ���� �ڸ���
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