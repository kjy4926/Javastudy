package servletTest;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet2 extends HttpServlet {
	@Override
	public void init() throws ServletException{
		System.out.println("서블릿 초기화");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setAttribute("now", new Date());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/now.jsp");
		dispatcher.forward(req, resp);
	}
}
