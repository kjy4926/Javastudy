package kgboostcamp_04_20_colletion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;

public class Info {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String name;
	private int age;
	
	Info(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Info)) {
			return false;
		}
		Info i = (Info)o;
		if(this.age == i.age && this.name.equals(i.name)) {
			System.out.println("same");
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {

		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((this.name == null) ? 0 : this.name.hashCode());
		hashCode = prime * hashCode + this.age;

		return hashCode;
	}
	
	public static void main(String[] args) {
		HashSet<Info> hset = new HashSet<Info>();
		// 임의로 5명 입력받을때까지 진행
		// name, age가 같으면 동일인물로 취급
		while(hset.size()<5) {
			try {
				boolean flag = true;
				System.out.print("이름 입력 : ");
				String name = br.readLine();
				System.out.print("나이 입력 : ");
				int age = Integer.parseInt(br.readLine());
				Info info = new Info(name, age);
				hset.add(info);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(Info i : hset) {
			System.out.printf("%s %d\n", i.getName(), i.getAge());
		}
	}
}