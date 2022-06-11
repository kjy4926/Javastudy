package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
//		Hello hello = new Hello();
//		hello.setName("test");
//		System.out.println(hello.greet());
		Hello hello = ctx.getBean("hello", Hello.class);
		
		System.out.println(hello.greet());
	}
}