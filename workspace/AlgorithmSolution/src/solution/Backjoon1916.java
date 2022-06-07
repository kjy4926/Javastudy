package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// ������, ����� �����ϴ� Node
class Node implements Comparable<Node>{
	private int dest;
	private int cost;
	
	Node(int d, int c){
		this.dest = d;
		this.cost = c;
	}
	
	public int getDest() {
		return this.dest;
	}
	public int getCost() {
		return this.cost;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return Integer.compare(this.cost, node.cost);
	}
}

public class Backjoon1916 {
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] minimum; // �湮 ��� ǥ
	static int V; // ���� ��
	static int E; // ���� ��
	static int source;
	static int dest;
	
	public static void main(String[] args) {
		try {
			V = Integer.parseInt(br.readLine()); // ���� ��
			E = Integer.parseInt(br.readLine()); // ������ ��
			minimum = new int[V];
			// �׷��� �ʱ�ȭ
			for(int i=0;i<V;i++) {
				graph.add(new ArrayList<Node>());
			}
			// �׷��� �Է�
			for(int i=0;i<E;i++) {
				// ��尡 1���� �����ϹǷ� s, d���� -1
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1; // start
				int d = Integer.parseInt(st.nextToken())-1; // dest
				int cost = Integer.parseInt(st.nextToken());
				graph.get(s).add(new Node(d, cost));
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			// ������ �� ���, ������ �Է¹ޱ� -> ������ ������ -1
			source = Integer.parseInt(st.nextToken())-1;
			dest = Integer.parseInt(st.nextToken())-1;
			// ���������� �Ÿ��� 0 �Է�
			pq.add(new Node(source, 0));
			minimum[source] = 0;
			// �� ��α��� ���� �ʱ�ȭ
			Arrays.fill(minimum, Integer.MAX_VALUE);
			// ���ͽ�Ʈ�� �˰���
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				int d = n.getDest(); // ������
				int c = n.getCost(); // ���
				// �̹� �ִ� ��ΰ� �����ϸ� ���� ��� Ȯ��
				if(minimum[d] < c) {
					continue;
				}
				// �̵��� ��ġ���� ���� �̵� ������ ��ε��� Ž���Ͽ� �ִܰŸ� ���� �� ť�� �Է�
				for(int i=0;i<graph.get(d).size();i++) {
					int next_dest = graph.get(d).get(i).getDest();
					int next_cost = c + graph.get(d).get(i).getCost();
					if(next_cost < minimum[next_dest]) {
						minimum[next_dest] = next_cost;
						pq.add(new Node(next_dest, next_cost));
					}
				}
			}
			System.out.println(minimum[dest]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> ���ͽ�Ʈ�� �˰���