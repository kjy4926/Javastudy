package aop01;
//Proxy Pattern?
public class Proxy implements Person{
	private Person delegate;
	
	public Proxy(Person delegate) {
		this.delegate = delegate;
	}

	@Override
	public int usingComputer(String pwd) {
		System.out.println("부팅 후 " + pwd + "입력하여 로그인");
		return delegate.usingComputer(pwd);
	}

}
