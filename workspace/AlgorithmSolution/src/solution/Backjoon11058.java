package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon11058 {
	static long[] dp = new long[101];
	static int n;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			for(int i=1;i<101;i++) {
				dp[i] = dp[i-1]+1;
				if(i>6) {
					for(int j=i-5;j<=i-3;j++) {
						dp[i] = Math.max(dp[i], dp[j]*((i-j)-1));
					}
				}
			}
			System.out.println(dp[n]);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// �ʱⰪ�� �Է� �� j-5���� j-3���� dp[j]*((i-j)-1)�� �����Ͽ�
// �ִ��� dp[i]�� �Է��Ѵ�.
// j-5 ~ j-3�� ���� -> c+a, c+c, c+v �� 3���� Ŭ���� �ʿ��ϸ�
// ���� ���� ������ ������ ������ 6�̱� �����̴�.