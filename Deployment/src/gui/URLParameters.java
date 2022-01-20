package gui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLParameters
 */
@WebServlet("/urlpara") //주소변경
public class URLParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// request = 요청객체   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8"); //한글이 나오게 설정됨
		//파라메터가 서버로 넘어가서 적용됨
		String user = request.getParameter("user"); //변수
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter(); 
		out.println("<html>");
		out.println("user parameter : " + user);	
		out.println("id parameter : " + id);
		out.println("</html>");
	}
//주소창에 ?로 user값 주기
//http://localhost:8090/Deployment/urlpara?user=Pengsu
//파라메터가 2개일때는 & 사용
//http://localhost:8090/Deployment/urlpara?user=Pengsu&id=123

}
