package servletTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	@Override
	public void init() throws ServletException{
		System.out.println("서블릿 초기화");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setAttribute("now", new Date());
		PrintWriter pw = resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head><title>now</title><head>");
		pw.println("<body>Now Date is");
		pw.println(new Date());
		pw.println("</body></html>");
		pw.flush();
		//RequestDispatcher dispatcher = req.getRequestDispatcher();
	}
}
