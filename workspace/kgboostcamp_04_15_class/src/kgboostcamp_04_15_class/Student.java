package kgboostcamp_04_15_class;

public class Student {
	private static final int SUBJECT_NUM = 3;
	private int id;
	private int age;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String name;
	
	// Constructor
	Student(int id, int age, String name){
		this.id = id;
		this.age = age;
		this.name = name;
		this.kor = 0;
		this.eng = 0;
		this.math = 0;
		this.setSum();
		this.setAvg();
	}
	// getter
	public int getId() {return this.id;}
	public int getAge() {return this.age;}
	public int getKor() {return this.kor;}
	public int getEng() {return this.eng;}
	public int getMath() {return this.math;}
	public int getSum() {return this.sum;}
	public double getAvg() {return this.avg;}
	public String getName() {return this.name;}
	// setter
	public void setAge(int age) {this.age = age;}
	public void setKor(int kor) {this.kor = kor; this.setSum(); this.setAvg();}
	public void setEng(int eng) {this.eng = eng; this.setSum(); this.setAvg();}
	public void setMath(int math) {this.math = math; this.setSum(); this.setAvg();}
	public void setSum() {this.sum = (getKor()+getEng()+getMath());}
	public void setAvg() {this.avg = ((getKor()+getEng()+getMath())/(double)Student.SUBJECT_NUM);}
	public void setName(String name) {this.name = name;}
	// toString
	public String toString() {
		return String.format("ID : %d / Age : %2d / Name : %s\n"
				+ "Kor : %3d / Eng : %3d / Math : %3d\n"
				+ "Sum : %3d / Avg : %3.2f", 
				this.getId(), this.getAge(), this.getName(),
				this.getKor(), this.getEng(), this.getMath(),
				this.getSum(), this.getAvg());
	}
}
