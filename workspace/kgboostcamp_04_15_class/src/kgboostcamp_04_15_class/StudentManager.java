package kgboostcamp_04_15_class;

import java.util.ArrayList;

public class StudentManager {
	private static final int MAX_STUDENT_NUM = 5;
	private int id = 1; // 학생이 입력됨에 따라 자동으로 1씩 늘어날 id -> start 1
	private ArrayList<Student> students = new ArrayList<Student>();
	
	// 학생 등록
	public void addStudent(int age, String name) {
		if(students.size() < MAX_STUDENT_NUM) {
			students.add(new Student(this.id, age, name));
			this.id++;
		}
	}
	// 점수 설정
	public void setStudentScore(Student s, int kor, int eng, int math) {
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);
		s.setSum();
		s.setAvg();
	}
	// 목록 보기
	public String[] showStudentsList() {
		String[] studentsList = new String[students.size()];
		for(int i=0;i<students.size();i++) {
			studentsList[i] = students.get(i).toString();
		}
		return studentsList;
	}
	// 학생 목록 반환받기
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	// 기능구현
	// 검색, 수정, 삭제 모두 Student의 멤버 값을 조건으로 사용하여 구현 가능하다.
	// 해당 기능들은 필요에 따라 이름, 나이, 점수, 총점, 평균 등을 이용해 구현 가능
	// 해당 클래스에서는 예시로 이름을 통해 검색, 수정, 삭제하는 기능만을 구현한다.
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
	// 수정하기
	// 수정 역시 어떤 값을 수정하느냐에 따라 다양하게 구현 가능하다.
	// 해당 조건에 맞는 인물의 이름을 rename으로 변경
	public void updateStduent(String name, String rename) {
		ArrayList<Student> result = searchStudentByName(name);
		for(int i=0;i<result.size();i++) {
			result.get(i).setName(rename);
		}
	}
	// 삭제하기
	public void removeStduent(String name) {
		ArrayList<Student> result = searchStudentByName(name);
		for(int i=0;i<result.size();i++) {
			students.remove(result.get(i));
		}
	}
	public static void main(String[] args) {
		StudentManager stm = new StudentManager();
		int count = 1; // 점수 초기화 용 변수
		stm.addStudent(17, "김진용");
		stm.addStudent(18, "홍승의");
		stm.addStudent(17, "요한킴");
		stm.addStudent(19, "송봉규");
		stm.addStudent(18, "김진용");
		stm.addStudent(19, "미등록"); // 여기는 인원 초과로 등록이 안된다.
		// 점수 초기화
		for(Student student : stm.getStudents()) {	
			stm.setStudentScore(student, count*15, count*20, count*11);
			count++;
		}	
		// 학생 목록 출력
		System.out.println("학생 리스트 초기화");
		for(String s:stm.showStudentsList()) System.out.println(s);
		// 갱신 테스트
		System.out.println("김진용 -> 진용 변경");
		stm.updateStduent("김진용", "진용");
		for(String s:stm.showStudentsList()) System.out.println(s);
		System.out.println("진용 제거");
		stm.removeStduent("진용");
		for(String s:stm.showStudentsList()) System.out.println(s);
		System.out.println("요한킴 검색");
		for(Student searchResult : stm.searchStudentByName("요한킴")) {
			System.out.println(searchResult.toString());
		}
	}
}