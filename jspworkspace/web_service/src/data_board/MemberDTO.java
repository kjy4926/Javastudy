package data_board;

import java.sql.Timestamp;

public class MemberDTO {
	private String id;
	private String pwd;
	private String email;
	private Timestamp signupdate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getSignupdate() {
		return signupdate;
	}
	public void setSignupdate(Timestamp signupdate) {
		this.signupdate = signupdate;
	}
}
