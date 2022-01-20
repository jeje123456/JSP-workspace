package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.security.auth.login.AccountException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.User;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/webshop")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // 한글설정
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action"); // action 파라메타 받기
		
		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if(action.equals("login")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if(action.equals("createaccount")) {
			request.setAttribute("message", "");
			request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
		}
		else {
			out.println("없는 액션입니다.");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //한글설정
		PrintWriter out = response.getWriter(); // out 객체를 사용하여 문자 출력 가능
		
		String action = request.getParameter("action"); //action = dologin 이 넘어옴
		
		if(action == null) { //doPost DB연결전 요청의 action 파라미터의 값이 null일때
			out.println("알 수 없는 요청입니다.");
			return;
		}
		
		Connection conn = null;
		
		try {
			conn = ds.getConnection(); // 1. DB 연결
		} catch (SQLException e) { //SQL 에러
			out.println("DB에 연결할 수 없습니다.");
			return;
		}
		
		//out.println("DB 연결 테스트 완료!");
		Account account = new Account(conn); //Account클래스 생성
		
		if(action.equals("dologin")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			request.setAttribute("email", email);
			request.setAttribute("password", ""); // 보안상 공백으로
			
			try {
				if(account.login(email, password)) {
					request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "아이디 또는 패스워드가 틀립니다.");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				request.setAttribute("message", "DB 에러 발생");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		else if (action.equals("createaccount")) { // 가입하기 페이지에서 작성후 가입하기 버튼 클릭시
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeatpassword");
			request.setAttribute("email", email); // 이메일 주소를 request에 저장
			
			if(!password.equals(repeatPassword)) { // 패스워드확인시 틀렸을때
				request.setAttribute("message", "패스워드가 틀렸습니다.");
				request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
			} else { // 패스워드 확인시 동일할때
				User user = new User(email, password);
				
				if(!user.validate()) { //유효성 검사 불합격시
					request.setAttribute("message", user.getMessage());
					request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
				}
				else { // 유효성 검사 합격시 email 중복 확인 후 새계정 만들기
					try {
						if(account.exists(email)) { // 같은 email이 있을 경우
							request.setAttribute("message", "이미 가입된 이메일이 있습니다.");
							request.getRequestDispatcher("/createaccount.jsp").forward(request, response);
						}
						else { // 같은 email이 없을 경우 새 계정을 만든다.
							account.create(email, password);
							request.getRequestDispatcher("/createsuccess.jsp").forward(request, response);
						}
					} catch (SQLException e) {
						request.setAttribute("message", "SQL 에러 발생");
						request.getRequestDispatcher("/error.jsp").forward(request, response);
					}
				}
			}		
		}
		
		try {
			conn.close(); // 실제로는 conn을 닫는것 대신에 커넥션을 커넥션 풀로 반환
		} catch (SQLException e) {
			out.println("DB 연결 종료 에러");
		}
	}

}
