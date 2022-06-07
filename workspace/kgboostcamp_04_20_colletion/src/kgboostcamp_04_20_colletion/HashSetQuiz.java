package kgboostcamp_04_20_colletion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class HashSetQuiz {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void intHashSetTest() {
		HashSet<Integer> hset = new HashSet<Integer>();
		while(true) {
			System.out.printf("입력(현재길이:%d) : ", hset.size());
			try {
				int n = Integer.parseInt(br.readLine());
				if(hset.contains(n)) System.out.println("중복!");
				else {
					if(n==-1) break;
					hset.add(n);
					System.out.println(Arrays.toString(hset.toArray()));
				}
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void StringHashSetTest() {
		HashSet<String> hset = new HashSet<String>();
		while(true) {
			System.out.printf("입력(현재길이:%d) : ", hset.size());
			try {
				String str = br.readLine();
				if(hset.contains(str)) System.out.println("중복!");
				else {
					if(str.equals("quit")) break;
					hset.add(str);
					System.out.println(Arrays.toString(hset.toArray()));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		intHashSetTest();
		StringHashSetTest();
	}
}
