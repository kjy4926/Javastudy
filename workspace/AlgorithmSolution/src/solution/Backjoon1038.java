package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Backjoon1038 {
	static int n;
	static ArrayList<Long> table = new ArrayList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final long MAX_NUM = 9876543210L;
	
	// �����ϴ� ���� �迭�� ��� �Լ�
	// 9876543210 ������ ��� �����ϴ� ���� �迭�� �����Ѵ�.
	public static void decreaseNum(long range, long num) {
		if(num > MAX_NUM) return;
		table.add(num);
		for(int i=0;i<range;i++) {
			long nextnum = num*10+i;
			long nrange = nextnum%10;
			decreaseNum(nrange, nextnum);
		}
	}
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			// 1~9 �ʱ갪���� ���� �� ����
			for(int i=0;i<10;i++) {
				decreaseNum(i, i);
			}
			Collections.sort(table);
			// n�� table���� ũ�ٸ� ���� �Ұ����� �����ϴ� ���̴�.
			if(n>table.size()-1) {System.out.println(-1);}
			else {System.out.println(table.get(n));}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}