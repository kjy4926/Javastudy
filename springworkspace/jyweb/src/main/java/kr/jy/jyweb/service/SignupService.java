package kr.jy.jyweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jy.jyweb.repository.MemberDao;

@Service
public class SignupService {
	private final MemberDao memberDao;
	
	@Autowired
	public SignupService(MemberDao memberDao) {this.memberDao = memberDao;}

	public boolean idCheck(String id) {
		// default -> 중복 x
		boolean result = false;
		
		if(memberDao.selectById(id) != null) {
			result = true;
		}
		System.out.println(result);
		return result;
	}
	
	public boolean signup(String id, String pwd, String email) {
		boolean result;
		result = memberDao.insert(id, pwd, email);
		return true;
	}
}
