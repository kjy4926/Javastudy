package kgboostcamp_04_08_method;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 큰 수 반환
	public static int solution01(int a, int b) {
		return a>b?a:b;
	}
	// 두 수 사이의 합 반환
	// 사이이므로 a,b는 제외
	public static int solution02(int a, int b) {
		int sum = 0;
		for(int i=a+1;i<b;i++) {
			sum += i;
		}
		return sum;
	}
	// 홀 짝 반환
	// true -> 짝수 / false -> 홀수
	public static boolean solution03(int a) {
		return a%2==0?true:false;
	}
	// 1~n까지 홀수의 합 반환
	// n까지이므로 n 포함
	public static int solution04(int n) {
		int sum = 0;
		for(int i=1; i<n+1;i++) {
			sum += i;
		}
		return sum;
	}
	// 오버로딩 활용
	// N의 절대값 반환
	// cm to inch
	// file 용량
}