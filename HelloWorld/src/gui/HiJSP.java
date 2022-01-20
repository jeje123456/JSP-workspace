package gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet : 주소지정
// HttpServlet를 상속받는 클래스 = 서블랫
@WebServlet("/hi")
public class HiJSP extends HttpServlet{
	private static final long serialVersionUID = 1L;

	// 우클릭 source 오버라이딩해서 doGet, doPost 생성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get은 url 주소 요청시
		PrintWriter out = resp.getWriter(); // ȭ�鿡 ����ϴ�(�����ϴ�) out ��ü ����
		out.println("<html>");
		out.println("<b>Hi JSP!!");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form 요청시 예) 로그인 (주소창에 표시되지 않음)
		super.doPost(req, resp);
	}

	
}
