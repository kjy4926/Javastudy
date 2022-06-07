package examservlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	private HashMap<String, Calculator> map = 
			new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		map.put("/add", new AddCalculator());
		map.put("/min", new MinCalculator());
		map.put("/mul", new MulCalculator());
		map.put("/div", new DivCalculator());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getMethod());
		String uri = req.getRequestURI();
		System.out.println("uri:" + uri);
		String ctxPath = req.getContextPath();
		System.out.println("ctxPath:" + ctxPath);
		String cmd = uri.substring(ctxPath.length());
		System.out.println("cmd:" + cmd);
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		String viewPage = "";
		try {
			Calculator handler = map.get(cmd);
			if(cmd.equals("/form")) {
				viewPage = "form";
			}
			else if(handler == null) {
				resp.sendRedirect(req.getContextPath());
				return;
			}else {
				viewPage = handler.calculate(req, resp);
			}
			System.out.println("뷰 페이지:"+prefix + viewPage + suffix);
			req.getRequestDispatcher(prefix + viewPage + suffix).forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}







