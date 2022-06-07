package kgboostcamp_04_05_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Quiz {
	// 5명 이름, 나이 입력받고 출력하기
	public static void solution04() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = 5;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> ages = new ArrayList<Integer>();
		
		for(int i=0;i<loop;i++) {
			String name = "";
			int age = 0;
			System.out.printf("%d번째 정보 입력\n", i+1);
			try {
				System.out.print("이름 : ");
				name = br.readLine();
				System.out.print("나이 : ");
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
			System.out.printf("%d정보\n", i+1);
			System.out.printf("이름 : %s, 나이 : %d세\n", names.get(i), ages.get(i));
		}
	}
	// 주민번호 검증기
	public static void solution05(String id_number) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0; // 계산된 총합
		int checksum = -1; // 검증 코드
		System.out.println("입력 주민번호 : " + id_number);
		int multi_num = 2; // 곱해질 숫자 2~9
		for(int i=0;i<id_number.length()-1;i++) {
			char c = id_number.charAt(i);
			if(c=='-') {continue;}
			answer += Character.getNumericValue(c)*multi_num;
			multi_num++;
			if(multi_num==10) multi_num = 2;
		}
		checksum = 11-(answer % 11);
		if(checksum>9) checksum -= 10;
		System.out.printf("검증 코드 확인 : %d", checksum);
	}
	// id의 마지막 자리빈 문자열을 입력으로 받는다.
	// 주민번호 마지막 자리 계산하여 반환
	public static int makeChecksum(String id) {
		int answer = 0; // 계산된 총합
		int checksum = -1; // 검증 코드
		int multi_num = 2; // 곱해질 숫자 2~9
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
	// 주민번호 생성하기
	public static String makeId() {
		int nowYear = 22;
		String id_number = "";
		Random rand = new Random();
		// yyMMdd 형식의 랜덤 날짜 생성
		String year = String.format("%02d", rand.nextInt(100));
		String month = String.format("%02d", rand.nextInt(12)+1);
		String day = "";
		int s_code = 0; // 성별 코드 1~4
		// 올해가 2022년 이므로 00~22는 3,4 / 나머지는 1,2
		// 1900 ~ 1922년도 생일자는 고려하지 않습니다.
		if(Integer.parseInt(year)>nowYear) s_code = rand.nextInt(2)+1;
		else s_code = rand.nextInt(2)+3;
		int id = rand.nextInt(90000)+10000; // 나머지 5자리 코드 -> 10000~99999
		// 월별로 일수가 다르므로 스위치문을 통해 day 생성
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
		System.out.println("생성한 주민반호 : " + id_number);
		return id_number;
	}
	public static void main(String[] args) {
		solution05(makeId());
	}
}