package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon12026 {
	static int n;
	static char[] map = new char[1001];
	static int[] dp = new int[1001];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			String boj = br.readLine();
			int k = 1;
			// map �Է�
			for(char c : boj.toCharArray()) {
				map[k] = c;
				dp[k] = Integer.MAX_VALUE;
				k++;
			}
			// ���� ���� 0���� �ʱ�ȭ
			dp[1] = 0;
			for(int i=2;i<n+1;i++) {
				char now = map[i];
				char prev; // ���� ��ġ(i)�� ���� ���� �ʿ��� ���� ����� ��
				if(now == 'B') prev = 'J';
				else if(now == 'O') prev = 'B';
				else prev = 'O';
				for(int j=1;j<i;j++) {
					// prev�� ��ġ�ϰ�, �ش� ��ġ�� �̵��� �����ϴٸ�(MAX -> �湮 �Ұ�)
					if(map[j] == prev && dp[j] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[j]+(j-i)*(j-i));
					}
				}
			}
			System.out.println(dp[n]==Integer.MAX_VALUE ? -1 : dp[n]);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// �� �ڵ�� �ٸ� Ǯ�� Ȯ�� �� ���� ���� �ڵ��̴�.
// �Ʒ��� ���� ��� �ڵ�
//Queue<Integer> q = new LinkedList<Integer>();
//q.add(1);
//while(!q.isEmpty()) {
//	int i = q.poll();
//	char now = map[i];
//	char next;
//	if(now == 'B') next = 'O';
//	else if(now == 'O') next = 'J';
//	else next = 'B';
//	for(int j=i+1;j<n+1;j++) {
//		if(map[j] == next) {
//			if(dp[j] > dp[i]+(i-j)*(i-j)) {
//				dp[j] = Math.min(dp[j], dp[i]+(i-j)*(i-j));
//				q.add(j);
//			}
//		}
//	}
//}