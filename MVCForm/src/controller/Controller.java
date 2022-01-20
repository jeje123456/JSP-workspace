package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// 저장되어 있는 이메일/패스워드/메세지를 초기화 => 로그인 정보는 post로 가므로 get에서는 초기화
		request.setAttribute("email", "");
		request.setAttribute("password", "");

		if(action == null) { 
			//액션값이 null값이면(잘못된 경우) index 페이지로 넘어감
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if (action.contentEquals("login")) { 
			//액션값이 login이면 login페이지로 넘어감 
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) { 
			//액션값이 null값이면(잘못된 경우) index 페이지로 넘어감
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if (action.contentEquals("dologin")) { 
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			// 속성 이름과 값을 저장
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			
			User user = new User(email, password);
			//유효성 검사에 통과하면 로그인성공 페이지로 파라메터 값을 전송
			if(user.validate()) {
				request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}
			else { //유효성 검사에서 실패했을때 실패 메세지를 request 객체에 파라메타로 추가
				// 파라메타 추가 = setAttribute("문자열", 저장할 변수)
				request.setAttribute("valmessage", user.getMessage());
				// 다시 로그인 페이지로 파라메타(email,password,message)를 가지고 되돌아감
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

}
