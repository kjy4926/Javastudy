package aop04;

import org.aspectj.lang.JoinPoint;

public class FinishAspect {
	public void shutdown(JoinPoint jp) {
		String com = jp.getTarget().getClass().getSimpleName();
		System.out.println(com + " 컴퓨터 종료");
	}
}
