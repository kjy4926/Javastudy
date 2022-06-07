package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Process implements Comparable<Process>{
	private int key;
	private int value;
	
	public Process(int k, int v) {
		this.key = k;
		this.value = v;
	}
	
	public int getKey() {return this.key;}
	public int getValue() {return this.value;}
	
	@Override
	public int compareTo(Process P) {
		if(this.value > P.getValue()) return 1;
		else if(this.value == P.getValue()) return 0;
		else return -1;
	}
}

public class Backjoon1700 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PriorityQueue<Process> maxHeap = new PriorityQueue<Process>(Collections.reverseOrder()); // ���� ������� ���μ����� ���� index �����ϴ� heap
	static HashMap<Integer, ArrayList<Integer>> schedule = new HashMap<>(); // key = ��ȣ / value = index -> ��� ������ ǥ
	static ArrayList<Integer> use = new ArrayList<>(); // ������� ��ǰ ��ȣ
	
	public static void main(String[] args) {
		int n = 0; // ��Ƽ�� ���� ��
		int k = 0; // ���� ��ǰ ��� Ƚ��
		int count = 0;
		int answer = 0;
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());			
			
			String[] sequence = br.readLine().split(" ");
			// HashMap init
			for(int i=0; i<k; i++) {
				int key = Integer.parseInt(sequence[i]);
				if(schedule.containsKey(key)) {
					schedule.get(key).add(i);
				}
				else {
					schedule.put(key, new ArrayList<Integer>());
					schedule.get(key).add(i);
				}
			}
			for(int i=0; i<k; i++) {
				int key = Integer.parseInt(sequence[i]);
				// �ܼ�Ʈ�� ����ٸ�
				if(count < n) {
					if(!use.contains(key)) {
						use.add(key);
						count++;
					}
				}
				// �ܼ�Ʈ�� ��á�ٸ�
				else {
					if(!use.contains(key)) {
						// ���� ������� Process �� ���� ���߿� ��� �� Process ����
						Process item = maxHeap.poll();
						while(maxHeap.size()>0 && !use.contains(item.getKey())){
							item = maxHeap.poll();
						}
						// ���� �� use�� key �߰�
						use.remove(Integer.valueOf(item.getKey()));
						use.add(key);
						answer += 1;
					}
				}
				// ����� ������ ����
				schedule.get(key).remove(0);
				// ���� �������� ����ٸ� ���� ������ �����Ƿ� value�� �ſ� ū ������ heap�� �Է�
				if(schedule.get(key).size() == 0) {
					maxHeap.add(new Process(key, Integer.MAX_VALUE));
				}
				// ������� �ʴٸ� ���� ������ ��ȣ�� value�� heap�� �Է�
				else {
					maxHeap.add(new Process(key, schedule.get(key).get(0)));
				}
			}
			System.out.println(answer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


// Algorithm -> Priority Queue ���
// ���� ��� ������ 1���� Ž���ϸ� Map�� idx ����
// ������� �� ��(�ܼ�Ʈ�� ���� ��) heap�� �ش� key�� ���� ��� idx�� �迭�� �Է�
// ���� ���� ��� ������ ���� ��� infinite �Է�
// MaxHeap���� root�� �ش��ϴ� key�� ���� ���� ���� �� ���� ���� input