package aop10;

import org.aspectj.lang.ProceedingJoinPoint;

public class WorkingAspect {
	public Object workingAdvice(ProceedingJoinPoint pjp) {
		//Before
		String pwd = (String)pjp.getArgs()[0];
		System.out.println("컴퓨터 부팅 및 " + pwd + "를 입력하여 로그인");
		
		String computer = null;
		Object result = null;
		try {
			result = pjp.proceed(pjp.getArgs()); //핵심 기능 호출 지점!
			//AfterReturning
			computer = pjp.getTarget().getClass().getSimpleName();
			System.out.println(computer + "작업 종료");
		}catch(Throwable e) {
			//AfterThrowing
			System.out.println(e.getMessage() + "문제로 AS신청!");
		}
		
		//After
		computer = pjp.getTarget().getClass().getSimpleName();
		System.out.println(computer + " 시스템 종료");
		
		return result;
	}
}
