package aop08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("aop08.xml");
		
		Person alice = ctx.getBean("progamer", Person.class);
		Person bob = ctx.getBean("programmer", Person.class);
		
		int useTime1 = alice.usingComputer("1234");
		System.out.println("alice의 사용 시간:" + useTime1);
		
		System.out.println("==========");
		
		int useTime2 = bob.usingComputer("5678");
		System.out.println("bob의 사용 시간:" + useTime2);
	}
}
