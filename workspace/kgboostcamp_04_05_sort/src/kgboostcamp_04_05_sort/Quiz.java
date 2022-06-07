package kgboostcamp_04_05_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Quiz {
	// 5�� �̸�, ���� �Է¹ް� ����ϱ�
	public static void solution04() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = 5;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> ages = new ArrayList<Integer>();
		
		for(int i=0;i<loop;i++) {
			String name = "";
			int age = 0;
			System.out.printf("%d��° ���� �Է�\n", i+1);
			try {
				System.out.print("�̸� : ");
				name = br.readLine();
				System.out.print("���� : ");
				age = Integer.parseInt(br.readLine());
				names.add(name);
				ages.add(age);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		for(int i=0;i<loop;i++) {
			System.out.printf("%d����\n", i+1);
			System.out.printf("�̸� : %s, ���� : %d��\n", names.get(i), ages.get(i));
		}
	}
	// �ֹι�ȣ ������
	public static void solution05(String id_number) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0; // ���� ����
		int checksum = -1; // ���� �ڵ�
		System.out.println("�Է� �ֹι�ȣ : " + id_number);
		int multi_num = 2; // ������ ���� 2~9
		for(int i=0;i<id_number.length()-1;i++) {
			char c = id_number.charAt(i);
			if(c=='-') {continue;}
			answer += Character.getNumericValue(c)*multi_num;
			multi_num++;
			if(multi_num==10) multi_num = 2;
		}
		checksum = 11-(answer % 11);
		if(checksum>9) checksum -= 10;
		System.out.printf("���� �ڵ� Ȯ�� : %d", checksum);
	}
	// id�� ������ �ڸ��� ���ڿ��� �Է����� �޴´�.
	// �ֹι�ȣ ������ �ڸ� ����Ͽ� ��ȯ
	public static int makeChecksum(String id) {
		int answer = 0; // ���� ����
		int checksum = -1; // ���� �ڵ�
		int multi_num = 2; // ������ ���� 2~9
		for(int i=0;i<id.length();i++) {
			char c = id.charAt(i);
			if(c=='-') {continue;}
			answer += Character.getNumericValue(c)*multi_num;
			multi_num++;
			if(multi_num==10) multi_num = 2;
		}
		checksum = 11-(answer % 11);
		if(checksum>9) checksum -= 10;
		return checksum;
	}
	// �ֹι�ȣ �����ϱ�
	public static String makeId() {
		int nowYear = 22;
		String id_number = "";
		Random rand = new Random();
		// yyMMdd ������ ���� ��¥ ����
		String year = String.format("%02d", rand.nextInt(100));
		String month = String.format("%02d", rand.nextInt(12)+1);
		String day = "";
		int s_code = 0; // ���� �ڵ� 1~4
		// ���ذ� 2022�� �̹Ƿ� 00~22�� 3,4 / �������� 1,2
		// 1900 ~ 1922�⵵ �����ڴ� ������� �ʽ��ϴ�.
		if(Integer.parseInt(year)>nowYear) s_code = rand.nextInt(2)+1;
		else s_code = rand.nextInt(2)+3;
		int id = rand.nextInt(90000)+10000; // ������ 5�ڸ� �ڵ� -> 10000~99999
		// ������ �ϼ��� �ٸ��Ƿ� ����ġ���� ���� day ����
		switch(month) {
		case "2":
			day = String.format("%02d", rand.nextInt(28)+1);
		case "4":
		case "6":
		case "9":
		case "11":
			day = String.format("%02d", rand.nextInt(30)+1);;
		default:
			day = String.format("%02d", rand.nextInt(31)+1);
		}
		String ymd = year + month + day; // yyMMdd
		id_number = ymd + "-" + Integer.toString(s_code) + Integer.toString(id);
		id_number += Integer.toString(makeChecksum(id_number));
		System.out.println("������ �ֹι�ȣ : " + id_number);
		return id_number;
	}
	public static void main(String[] args) {
		solution05(makeId());
	}
}