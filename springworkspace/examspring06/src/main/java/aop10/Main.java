package aop10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop10.xml");
		
		Person alice = ctx.getBean("progamer", Person.class);
		Person bob = ctx.getBean("programmer", Person.class);
		try {
			int useTime1 = alice.usingComputer("1234");
			System.out.println("alice의 사용 시간:" + useTime1);
		}catch(Exception e) {
			System.out.println("alice에서 예외 발생");
		}
		
		System.out.println("==========");
		
		try {
			int useTime2 = bob.usingComputer("5678");
			System.out.println("bob의 사용 시간:" + useTime2);
		}catch(Exception e) {
			System.out.println("bob에서 예외 발생");
		}
	}
}
