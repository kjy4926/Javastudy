package data_board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	public String handling(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
