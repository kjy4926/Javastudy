package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Backjoon2667 {
	static boolean[][] visited = new boolean[25][25]; // default == false
	static int[] dx = {-1,1,0,0}; // �� �� �� ��
	static int[] dy = {0,0,-1,1}; // �� �� �� ��
	static int n; // x, y ��
	static int apart_count = 0; // ���� ��
	static ArrayList<Integer> nums = new ArrayList<>(); // ���� �ο� ��
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[25][25];
	static int count;
	
	static void dfs(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// x, y �� ���� ���� ���̰�, ���� �湮���� �ʾҴٸ�
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] != true) {
				visited[nx][ny] = true;
				// �ش� ��尡 1�̶��
				if(map[nx][ny] == 1) {
					count += 1;
					nums.set(apart_count, count);
					dfs(nx, ny);
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			n = Integer.parseInt(br.readLine());
			// map �Է�
			for(int i=0;i<n;i++) {
				String data = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j] = data.charAt(j)-48;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					// �湮 x �ش� ��尡 1�̶��
					if(visited[i][j] != true && map[i][j] == 1) {
						visited[i][j] = true;
						nums.add(1);
						count = 1;
						dfs(i, j);
						apart_count += 1;
					}
				}
			}
			Collections.sort(nums);
			System.out.println(apart_count);
			for(int i=0;i<nums.size();i++) {
				System.out.println(nums.get(i));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// Algorithm -> DFS
// ��带 Ž���ϸ� 1�� ���� ��� visited�� true�� �����ϰ� dfs ����