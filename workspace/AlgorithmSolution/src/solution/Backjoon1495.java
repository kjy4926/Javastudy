package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1495 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int s;
	static int p;
	static int m;
	static int[] dp = new int[1001];
	
	public static void main(String[] args) {
		try {
			Arrays.fill(dp, -1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			dp[s] = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=1;i<n+1;i++) {
				list.clear();
				int v = Integer.parseInt(st2.nextToken());
				for(int j=0;j<m+1;j++) {
					if(dp[j] == i-1) {
						int plus = j + v;
						int minus = j - v;
						if(plus >= 0 && plus <= m) list.add(plus);
						if(minus >= 0 && minus <= m) list.add(minus);
					}
				}
				for(int k : list) {
					dp[k] = i;
				}
			}
			int max = -1;
			for(int i=0;i<m+1;i++) {
				if(dp[i] == n) {
					max = i;
				}
			}
			System.out.println(max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// �ش� ������ DFS Ȥ�� BFS�� ���� Ǯ�ԵǸ� 2^N�� ���⵵�� ������.
// ���� ������ �ð��ʰ� Ȥ�� �޸��ʰ��� �߻��Ѵ�.
// �̸� �ذ��ϱ� ���� Volume dp�� ���������
// �ش� �迭�� i��° ���ְ� �������� ��Ҵ�.
// ���������� �Էµ� n�� ���� ���� ������ dp �迭 �� �� �ִ��� ����Ѵ�.
// �̷� ��� ���� �ִ� 50�� M�� �ִ� 1000�̹Ƿ� �ִ� �� 5������ ���길�� ����ȴ�.