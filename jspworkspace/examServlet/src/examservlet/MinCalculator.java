package examservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MinCalculator implements Calculator{
	@Override
	public String calculate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		req.setAttribute("result", n1 - n2);
		req.setAttribute("operation", "뺄셈");
		return "result";
	}
}








