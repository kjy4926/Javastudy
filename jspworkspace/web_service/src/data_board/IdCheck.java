package data_board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdCheck implements Handler{
	@Override
	public String handling(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO mdao = MemberDAO.getInstance();
		int idcheck = 0;
		// 중복이 아니라면
		if(!mdao.idCheck(req.getParameter("userId"))) {
			idcheck= 1;
		}
		req.setAttribute("idcheck", idcheck);
		return "idcheck";
	}
}
