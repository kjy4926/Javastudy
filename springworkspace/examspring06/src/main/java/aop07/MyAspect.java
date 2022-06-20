package aop07;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	
	public void bootingAndLogin(JoinPoint jp) {
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅:" + pwd + "입력 로그인");
	}
}
