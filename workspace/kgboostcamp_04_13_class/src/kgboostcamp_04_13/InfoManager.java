package kgboostcamp_04_13;

import java.util.ArrayList;
import java.util.Scanner;

public class InfoManager {
	private static final int MAX_MEMBER_NUM = 5;
	private int id = 0;
	private ArrayList<Info> members = new ArrayList<Info>();
	
	// ��� ���
	public boolean addMember(String name, int age) {
		if(members.size()<MAX_MEMBER_NUM) {
			members.add(new Info(this.id, name, age));
			id++;
			return true;
		}
		else return false;
	}
	// ��� �˻� -> ID, �̸�, ���̷� 3���� �˻� ��� ����
	// �̸��� ���� �˻��� ����� �ߺ��� �� ����
	// ID �˻�
	public void selectMemberById(int id) {
		Info mem = getMemberById(id);
		if(mem != null) mem.printInfo();
	}
	// �̸� �˻�
	public void selectMemberByName(String name) {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			if(mem.getName().equals(name)) {
				mem.printInfo();
			}
		}
	}
	// Age �˻�
	public void selectMemberByAge(int age) {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			if(mem.getAge() == age) {
				mem.printInfo();
			}
		}
	}
	// ��� ����
	// ���� �� ������ �ݵ�� id�θ� �̷������.
	// �̸��� ���̴� �ߺ��� ���� �� �ִ�.
	public void updateMember(int id) {
		Info mem = getMemberById(id);
		if(mem != null) {
			Scanner scan = new Scanner(System.in);
			System.out.print("�̸� �Է� : ");
			String name = scan.nextLine();
			System.out.print("���� �Է� : ");
			int age = Integer.parseInt(scan.nextLine());
			mem.setName(name);
			mem.setAge(age);
		}
	}
	// ��� ����
	public void removeMember(int id) {
		Info rm = getMemberById(id);
		if(rm != null) {
			members.remove(rm);
		}
	}
	// ��� ��� ����
	public void printMemberList() {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			System.out.printf("%d %s %d��\n", mem.getId(), mem.getName(), mem.getAge());
		}
	}
	// id�� ��� ������
	public Info getMemberById(int id) {
		for(int i=0;i<members.size();i++) {
			Info mem = members.get(i);
			if(mem.getId() == id) {
				return mem;
			}
		}
		return null;
	}
	// ��� �� ������
	public int getMemberCount() {
		return this.members.size();
	}
	// Main
	public static void main(String[] args) {
		InfoManager manager = new InfoManager();
		manager.addMember("������", 27);
		manager.addMember("������", 22);
		manager.addMember("���", 27);
		manager.addMember("���", 18);
		manager.addMember("���޸�", 33);
		
		System.out.println("init");
		manager.printMemberList();
		
		System.out.println("id==3 remove");
		manager.removeMember(3);
		manager.printMemberList();
		
		System.out.println("search test");
		manager.selectMemberByAge(27);
		manager.selectMemberById(1);
		manager.selectMemberByName("���޸�");
		
		System.out.println("id==4 update test");
		manager.updateMember(4);
		
		System.out.println("add memeber");
		manager.addMember("��ֿ�", 3);
		manager.addMember("��ֿ���", 4);
		manager.printMemberList();
	}
}