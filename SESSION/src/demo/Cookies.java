package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
		// 브라우저에서 쿠키들을 가져옴
		Cookie[] cookies = request.getCookies();
		// 쿠키가 있으면 전체 출력
		if (cookies == null) {
			out.println("No cookies <br>"); //쿠키없음
		} else { // 쿠키 있을때
			for(Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				
				out.println(name + " = " + value + "<br>");
			}
		}
		//user가 kim인 쿠키 c1 생성
		Cookie c1 = new Cookie("user", "Kim"); //쿠키 c1 생성
		Cookie c2 = new Cookie("user2", "Lee");
		
		c1.setMaxAge(300); // 300초동안 저장
		c2.setMaxAge(300);
		
		response.addCookie(c1); // 브라우저에 쿠키 저장
		response.addCookie(c2);
		
		out.println("Cookie saved <br>");
		out.println("</html>");		
	}
}
