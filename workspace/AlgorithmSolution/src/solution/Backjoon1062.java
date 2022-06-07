package solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon1062 {
	private static int n = 0;
	private static int k = 0;
	private static int max = 0; // ��ȯ�� �ִ밪
	private static ArrayList<String> words = new ArrayList<>(); // �Էµ� ���ڿ�
	private static boolean[] visited = new boolean[26];
	public static void dfs(int start, int count) {
		if(count == k) {
			int n=0;
			for(String w:words) {
				boolean flag = true;
				for(int c:w.toCharArray()) {
					if(visited[c-97]!= true) {
						flag = false;
						break;
					}
				}
				if(flag)n++;
			}
			max = Math.max(max, n);
		}
		else {
			for(int i=start;i<26;i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i, count+1);
					visited[i] = false;
				}
			}
		}		
	}
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<visited.length;i++) {
			visited[i] = false;
		}
		try {
			String input = "";
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				input = br.readLine();
				words.add(input.substring(4,input.length()-4));
			}
			// a c i n t �ּ� 5���� ���ĺ��� �˾ƾ��Ѵ�.
			if(k<5) {
				System.out.println(0);
				return;
			}
			// a c i n t -> true
			visited['a'-'a'] = true;
			visited['c'-'a'] = true;
			visited['i'-'a'] = true;
			visited['n'-'a'] = true;
			visited['t'-'a'] = true;
			// ��� ���ĺ��� �ƴ� ��� ��� �ܾ �˰� �ִ�.
			if(k==26) {
				System.out.println(words.size());
				return;
			}
			dfs(0, 5);
			System.out.println(max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

// Algorithm
// 1. 5���� ������ 0 ����(anta tica�� �ּ� 5���� ���ĺ�)
// 2. k == 26 -> ��� ���ĺ��� �˰� �����Ƿ� n ����
// 3. dfs�� ���� ��� ���� ������ ���ĺ� �������� ��ȸ�� �� max ����