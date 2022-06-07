package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2616 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n; // ������ ��
	static int[] nums; // �մ� �迭
	static int k; // ���������� �ִ� ���� ��
	static int[] sum;
	static int[][] dp = new int[4][50001]; // dp[i][j] = ������ i���϶� j������ �ִ�
	
	public static void solution() {
		for(int i=1;i<=3;i++) {
			for(int j=i*k;j<=n;j++) {
				// ���� j-1������ �ִ밪�� i-1�뿡�� j-k������ �ִ밪 + j������ �� �� ū ���� dp�� �����Ѵ�.
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + sum[j] - sum[j-k]);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			nums = new int[n+1];
			sum = new int [n+1];
			StringTokenizer	st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				nums[i+1] = Integer.parseInt(st.nextToken());
				sum[i+1] = sum[i] + nums[i+1];
			}
			k = Integer.parseInt(br.readLine());
			solution();
			System.out.println(dp[3][n]);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
