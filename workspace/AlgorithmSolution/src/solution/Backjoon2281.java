package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon2281 {
	static int n;
	static int m;
	static int[] nums;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// max + 1 ����Ͽ� ���� �ε����� �ִ� 1002�� ����
	static int[][] dp = new int[1001][1002]; // [0] = ���� �� �̸� idx, [1] = �ش� �ٿ� ���� ���� ��
	
	public static int solution(int idx, int len) {
		if(idx >= n) return 0;
		if(dp[idx][len] != -1) return dp[idx][len];
		// ���� �ٿ� ���� ���
		dp[idx][len] = (m-len+1)*(m-len+1) + solution(idx+1, nums[idx]+1);
		// �̹� �ٿ� �ٿ� ���� ���
		if(len+nums[idx] <= m) {
			dp[idx][len] = Math.min(dp[idx][len], solution(idx+1, len+nums[idx]+1));
		}
		return dp[idx][len];
	}
	
	public static void main(String[] args) {	
		try {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			nums = new int[n];
			for(int i=0;i<n;i++) {
				nums[i] = Integer.parseInt(br.readLine());
			}
			for(int i=0;i<1001;i++) {
				Arrays.fill(dp[i], -1);
			}
			System.out.println(solution(0, 0));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}