package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String page = null;
		if (action == null) {
			page = "/error.jsp";
		} else if (action.equals("login")) {
			page = "/login.jsp";
		} else if (action.equals("about")) {
			page = "/about.jsp";
		} else {
			page = "/error.jsp";
		}
		//getServletContext() = MVC2
		// MVC2/login.jsp를 forward로 보낸다.(파라메터 전달을 위해서 forward 사용)
		// Controller로 요청해서 Controller에서 forward로 로그인페이지로 보냄????
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}
}
