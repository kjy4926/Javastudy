package kgboostcamp_04_13;

import java.util.ArrayList;
import java.util.Scanner;

public class InfoManager {
	private static final int MAX_MEMBER_NUM = 5;
	private int id = 0;
	private ArrayList<Info> members = new ArrayList<Info>();
	
	// 멤버 등록
	public boolean addMember(String name, int age) {
		if(members.size()<MAX_MEMBER_NUM) {
			members.add(new Info(this.id, name, age));
			id++;
			return true;
		}
		else return false;
	}
	// 멤버 검색 -> ID, 이름, 나이로 3가지 검색 기능 제공
	// 이름와 나이 검색은 결과가 중복될 수 있음
	// ID 검색
	public void selectMemberById(int id) {
		Info mem = getMemberById(id);
		if(mem != null) mem.printInfo();
	}
	// 이름 검색
	public void selectMemberByName(String name) {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			if(mem.getName().equals(name)) {
				mem.printInfo();
			}
		}
	}
	// Age 검색
	public void selectMemberByAge(int age) {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			if(mem.getAge() == age) {
				mem.printInfo();
			}
		}
	}
	// 멤버 수정
	// 수정 및 삭제는 반드시 id로만 이루어진다.
	// 이름과 나이는 중복이 있을 수 있다.
	public void updateMember(int id) {
		Info mem = getMemberById(id);
		if(mem != null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("이름 입력 : ");
			String name = scan.nextLine();
			System.out.print("나이 입력 : ");
			int age = Integer.parseInt(scan.nextLine());
			mem.setName(name);
			mem.setAge(age);
		}
	}
	// 멤버 삭제
	public void removeMember(int id) {
		Info rm = getMemberById(id);
		if(rm != null) {
			members.remove(rm);
		}
	}
	// 멤버 목록 보기
	public void printMemberList() {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			System.out.printf("%d %s %d세\n", mem.getId(), mem.getName(), mem.getAge());
		}
	}
	// id로 멤버 얻어오기
	public Info getMemberById(int id) {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			if(mem.getId() == id) {
				return mem;
			}
		}
		return null;
	}
	// 멤버 수 얻어오기
	public int getMemberCount() {
		return this.members.size();
	}
	// Main
	public static void main(String[] args) {
		InfoManager manager = new InfoManager();
		manager.addMember("김진용", 27);
		manager.addMember("누군가", 22);
		manager.addMember("멤버", 27);
		manager.addMember("사람", 18);
		manager.addMember("노휴먼", 33);
		
		System.out.println("init");
		manager.printMemberList();
		
		System.out.println("id==3 remove");
		manager.removeMember(3);
		manager.printMemberList();
		
		System.out.println("search test");
		manager.selectMemberByAge(27);
		manager.selectMemberById(1);
		manager.selectMemberByName("노휴먼");
		
		System.out.println("id==4 update test");
		manager.updateMember(4);
		
		System.out.println("add memeber");
		manager.addMember("우애옹", 3);
		manager.addMember("우애옹투", 4);
		manager.printMemberList();
	}
}