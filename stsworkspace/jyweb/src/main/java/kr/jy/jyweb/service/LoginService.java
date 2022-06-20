package kr.jy.jyweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.jy.jyweb.entity.Member;
import kr.jy.jyweb.repository.MemberDao;

@Service
public class LoginService {
	
	private final MemberDao memberDao;
	
	@Autowired
	public LoginService(MemberDao memberDao) {this.memberDao = memberDao;}

	public boolean login(String id, String pwd) {
		boolean result = false;
		
		Member member = memberDao.selectById(id);
		if(member != null) {
			if(member.getPwd() == pwd) result = true;
		}
		
		return result;
	}
}
