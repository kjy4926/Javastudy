package aop10;

import java.util.Scanner;

public class Programmer implements Person {
	
	public int usingComputer(String pwd) {
		System.out.println("[코딩을 한다.]");
		Scanner in = new Scanner(System.in);
		System.out.print("코딩 중 입력:");
		int state = in.nextInt();
		if(state == 1) {
			throw new RuntimeException("코딩 오류!");
		}
		return 200;
	}
}
