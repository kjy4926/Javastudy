package examjava01;
import java.util.Scanner;

class Person{
	String name;
	int age;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
}

//public class Main{
//	public static void main(String[] args){
//		Student s = new Student("ȫ�浿");
//		Person p = s;	// ��ĳ����
//		p.name = "�̸��̴�.";
//
//		p.check = "������ ���� �߻�";	// ������ ���� �߻�
//	}
//}
public class Main {
	public static void main(String[] args){
		Person p = new Person("�׽�Ʈ", 25);
		String json = String.format(
				"name: %s\n"
				+ "age: %d", 
				p.getName(), p.getAge());
        System.out.println(json);
	}
}
