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
//		Student s = new Student("홍길동");
//		Person p = s;	// 업캐스팅
//		p.name = "이름이다.";
//
//		p.check = "컴파일 에러 발생";	// 컴파일 에러 발생
//	}
//}
public class Main {
	public static void main(String[] args){
		Person p = new Person("테스트", 25);
		String json = String.format(
				"name: %s\n"
				+ "age: %d", 
				p.getName(), p.getAge());
        System.out.println(json);
	}
}
