package aop00;

public class Main {
	public static void main(String[] args) {
		Programmer p1 = new Programmer();
		Progamer p2 = new Progamer();
		
		int useT1 = p1.usingComputer("1234");
		System.out.println("----------------");
		int useT2 = p2.usingComputer("4321");
		
		System.out.println(p1.getClass().getName() + "이용시간:" + useT1);
		System.out.println(p2.getClass().getName() + "이용시간:" + useT2);
	}
}
