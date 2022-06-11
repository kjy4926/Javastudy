package spring01;

public class Hello {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	
	public String greet() {
		return String.format("%s님 안녕하세요.", name);
	}
}
