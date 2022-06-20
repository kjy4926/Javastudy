package aop09;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAspect {
	
	public void afterThrowing(JoinPoint jp) {
		System.out.println("예외 발생! AS신청!");
	}
}
