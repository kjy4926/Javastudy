package aop08;

public class Programmer implements Person{
	public int usingComputer(String pwd) {
		//System.out.println("컴퓨터 부팅 후 " + pwd + "를 입력하여 로그인");
		
		try {
			System.out.println("[코딩을 한다.]");
			//System.out.println("코딩 종료");
		}catch(Exception e) {
			if(e.getMessage().equals("부팅오류")) {
				System.out.println("AS를 신청한다.");
			}
		}
		
		//System.out.println("컴퓨터 종료");
		return 200;
	}
}
