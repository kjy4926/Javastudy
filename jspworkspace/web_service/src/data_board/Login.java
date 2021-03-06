package data_board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Handler{

	@Override
	public String handling(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO mdao = MemberDAO.getInstance();
		if(mdao.login(req.getParameter("id"), req.getParameter("pwd"))) {
			req.getSession().setAttribute("loginID", req.getParameter("id"));
		}
		return "index";
	}
}