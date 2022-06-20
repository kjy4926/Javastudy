package spring;

//커맨드 객체(사용자 요청 정보를 담는 클래스)
public class RegisterRequest {
	private String email;
	private String password; // 비밀번호
	private String confirmPassword; //비밀번호 확인
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isPasswordEqualsToConfirmPassword() {
		return password.equals(confirmPassword);
	}
	
}





