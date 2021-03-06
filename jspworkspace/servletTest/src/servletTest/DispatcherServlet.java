package servletTest;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet{
	private HashMap<String, Calculator> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		map.put("/add", new AddCalculator());
		map.put("/min", new MinCalculator());
		map.put("/mul", new MulCalculator());
		map.put("/div", new DivCalculator());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println(req.getMethod());
		String uri = req.getRequestURI();
		System.out.println(uri);
		String ctxPath = req.getContextPath();
		System.out.println(ctxPath);
		String cmd = uri.substring(ctxPath.length());
		System.out.println(cmd);
		String prefix = "/WEB-INF/views/";
		String subfix = ".jsp";
		
		
		Calculator handler = map.get(cmd);
		//String viewPage = handler.calculate(req, resp);
		//req.getRequestDispatcher(prefix + viewPage + subfix);
	}
}
