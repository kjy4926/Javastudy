package aop08;

import org.aspectj.lang.JoinPoint;

public class AfterReturningAspect {

	public void afterReturning(JoinPoint jp) {
		String computer = jp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "작업 종료");
	}
}
