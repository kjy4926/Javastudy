package data_board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp implements Handler{

	@Override
	public String handling(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO mdto = new MemberDTO();
		mdto.setId(req.getParameter("id"));
		mdto.setPwd(req.getParameter("pwd"));
		mdto.setEmail(req.getParameter("email"));
		req.setAttribute("signupsuccess", mdao.signUp(mdto));
		return "signupSuccess";
	}
}
