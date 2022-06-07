package kgboostcamp_04_15_class;

import java.util.ArrayList;

public class StudentManager {
	private static final int MAX_STUDENT_NUM = 5;
	private int id = 1; // �л��� �Էµʿ� ���� �ڵ����� 1�� �þ id -> start 1
	private ArrayList<Student> students = new ArrayList<Student>();
	
	// �л� ���
	public void addStudent(int age, String name) {
		if(students.size() < MAX_STUDENT_NUM) {
			students.add(new Student(this.id, age, name));
			this.id++;
		}
	}
	// ���� ����
	public void setStudentScore(Student s, int kor, int eng, int math) {
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);
		s.setSum();
		s.setAvg();
	}
	// ��� ����
	public String[] showStudentsList() {
		String[] studentsList = new String[students.size()];
		for(int i=0;i<students.size();i++) {
			studentsList[i] = students.get(i).toString();
		}
		return studentsList;
	}
	// �л� ��� ��ȯ�ޱ�
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	// ��ɱ���
	// �˻�, ����, ���� ��� Student�� ��� ���� �������� ����Ͽ� ���� �����ϴ�.
	// �ش� ��ɵ��� �ʿ信 ���� �̸�, ����, ����, ����, ��� ���� �̿��� ���� ����
	// �ش� Ŭ���������� ���÷� �̸��� ���� �˻�, ����, �����ϴ� ��ɸ��� �����Ѵ�.
	public ArrayList<Student> searchStudentByName(String name) {
		ArrayList<Student> result = new ArrayList<Student>();
		for(int i=0;i<students.size();i++) {
			Student s = students.get(i);
			if(s.getName().equals(name)) {
				result.add(s);
			}
		}
		return result;
	}
	// �����ϱ�
	// ���� ���� � ���� �����ϴ��Ŀ� ���� �پ��ϰ� ���� �����ϴ�.
	// �ش� ���ǿ� �´� �ι��� �̸��� rename���� ����
	public void updateStduent(String name, String rename) {
		ArrayList<Student> result = searchStudentByName(name);
		for(int i=0;i<result.size();i++) {
			result.get(i).setName(rename);
		}
	}
	// �����ϱ�
	public void removeStduent(String name) {
		ArrayList<Student> result = searchStudentByName(name);
		for(int i=0;i<result.size();i++) {
			students.remove(result.get(i));
		}
	}
	public static void main(String[] args) {
		StudentManager stm = new StudentManager();
		int count = 1; // ���� �ʱ�ȭ �� ����
		stm.addStudent(17, "������");
		stm.addStudent(18, "ȫ����");
		stm.addStudent(17, "����Ŵ");
		stm.addStudent(19, "�ۺ���");
		stm.addStudent(18, "������");
		stm.addStudent(19, "�̵��"); // ����� �ο� �ʰ��� ����� �ȵȴ�.
		// ���� �ʱ�ȭ
		for(Student student : stm.getStudents()) {	
			stm.setStudentScore(student, count*15, count*20, count*11);
			count++;
		}	
		// �л� ��� ���
		System.out.println("�л� ����Ʈ �ʱ�ȭ");
		for(String s:stm.showStudentsList()) System.out.println(s);
		// ���� �׽�Ʈ
		System.out.println("������ -> ���� ����");
		stm.updateStduent("������", "����");
		for(String s:stm.showStudentsList()) System.out.println(s);
		System.out.println("���� ����");
		stm.removeStduent("����");
		for(String s:stm.showStudentsList()) System.out.println(s);
		System.out.println("����Ŵ �˻�");
		for(Student searchResult : stm.searchStudentByName("����Ŵ")) {
			System.out.println(searchResult.toString());
		}
	}
}