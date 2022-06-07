package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon2252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // �׷����� ǥ���ϴ� 2���� ���� ����Ʈ
	static int[] indegree; // �ش� ��带 ����Ű�� ���� ������ ��� �迭
	static int n; // ��� ��
	static int m; // �� ��(���� ��)
	
	public static void topologicalSort() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<n+1;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int node = q.poll();
			graph.get(0).add(node);
			for(int i=0;i<graph.get(node).size();i++) {
				int next = graph.get(node).get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]); // ����� ��
			m = Integer.parseInt(s[1]); // ������ ��
			indegree = new int[n+1];
			// graph ��� 1������ ǥ��, 0������ ������� ���� ����
			for(int i=0;i<n+1;i++) {
				graph.add(new ArrayList<Integer>());
			}
			// ������ �׷����� �Է�
			for(int i=0;i<m;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int src = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				graph.get(src).add(dest);
				indegree[dest] += 1;				
			}
			// ���� ����
			topologicalSort();
			// ��� ���
			for(int i=0;i<graph.get(0).size();i++) {
				System.out.printf("%d ", graph.get(0).get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}

// Algorithm -> ���� ����(TopologicalSort)