package spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext actx = new GenericXmlApplicationContext("appContext.xml");
		CountCalculator countcalc = actx.getBean("countcalc", CountCalculator.class);
		
		
		System.out.printf("%d+%d = %d\n", 1, 2, countcalc.add(1, 2));
		System.out.printf("%d-%d = %d\n", 3, 4, countcalc.min(3, 4));
		System.out.printf("%d*%d = %d\n", 5, 6, countcalc.mul(5, 6));
		System.out.printf("%d/%d = %d\n", 8, 2, countcalc.div(8, 2));
		System.out.println();
		
		System.out.printf("%d-%d = %d\n", 10, 3, countcalc.min(10, 3));
		System.out.printf("%d*%d = %d\n", 7, 5, countcalc.mul(7, 5));
		System.out.printf("%d/%d = %d\n", 15, 3, countcalc.div(15, 3));
		System.out.println();
		
		System.out.printf("%d*%d = %d\n", 8, 7, countcalc.mul(8, 7));
		System.out.printf("%d/%d = %d\n", 10, 2, countcalc.div(10, 2));
		System.out.println();
		
		System.out.printf("%d/%d = %d\n", 16, 4, countcalc.div(16, 4));
		System.out.println();
		
		System.out.println("COUNT");
		System.out.println("ADD : "+ countcalc.getCounter().getAddCount());
		System.out.println("MIN : "+ countcalc.getCounter().getMinCount());
		System.out.println("MUL : "+ countcalc.getCounter().getMulCount());
		System.out.println("DIV : "+ countcalc.getCounter().getDivCount());
	}
}
