package kgboostcamp_04_08_method;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// ū �� ��ȯ
	public static int solution01(int a, int b) {
		return a>b?a:b;
	}
	// �� �� ������ �� ��ȯ
	// �����̹Ƿ� a,b�� ����
	public static int solution02(int a, int b) {
		int sum = 0;
		for(int i=a+1;i<b;i++) {
			sum += i;
		}
		return sum;
	}
	// Ȧ ¦ ��ȯ
	// true -> ¦�� / false -> Ȧ��
	public static boolean solution03(int a) {
		return a%2==0?true:false;
	}
	// 1~n���� Ȧ���� �� ��ȯ
	// n�����̹Ƿ� n ����
	public static int solution04(int n) {
		int sum = 0;
		for(int i=1; i<n+1;i++) {
			sum += i;
		}
		return sum;
	}
	// �����ε� Ȱ��
	// N�� ���밪 ��ȯ
	// cm to inch
	// file �뷮
}