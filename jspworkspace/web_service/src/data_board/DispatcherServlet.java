package data_board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private HashMap<String, Handler> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		map.put("/idcheck", new IdCheck());
		map.put("/signup", new SignUp());
		map.put("/login", new Login());
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
		String uri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String cmd = uri.substring(ctxPath.length());
		String prefix = "/docs/";
		String suffix = ".jsp";
		String viewPage = "";
		try {
			Handler handler = map.get(cmd);
			if(cmd.equals("/index")) {
				viewPage = "index";
			}
			else if(cmd.equals("/loginform")) {
				viewPage = "login";
			}
			else if(cmd.equals("/signupform")) {
				viewPage = "signup";
			}
			else if(handler == null) {
				return;
			}else {
				viewPage = handler.handling(req, resp);
			}
			req.getRequestDispatcher(prefix + viewPage + suffix).forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
