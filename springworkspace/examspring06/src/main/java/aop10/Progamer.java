package aop10;

import java.util.Scanner;

public class Progamer implements Person{
	public int usingComputer(String pwd) {
		System.out.println("[게임을 한다.]");
		Scanner in = new Scanner(System.in);
		System.out.print("게임 중 입력:");
		int state = in.nextInt();
		if(state == 1) {
			throw new RuntimeException("오류!");
		}
		return 100;
	}
}
