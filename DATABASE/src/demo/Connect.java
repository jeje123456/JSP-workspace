package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //한글설정
		PrintWriter out = response.getWriter(); // out 객체를 사용하여 문자 출력 가능
		// import java.sql.Connection;
		Connection conn = null;
		
		try {
			// 0. 드라이버 로딩(최근에는 자동으로되서 필요없다고 하지만 만약을 위해서(JDK6이하) 설정)
			Class.forName("com.mysql.jdbc.Driver");
			// 1. DB 연결
			// conn = DriverManager.getConnection(url, user, password);
			// url = jdbc:mysql://MySQL이 있는 컴퓨터의 IP주소/사용할 데이터베이스? 인증 = 귀찮아서 끄기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/webshop?useSSL=false", "root", "1234");
		} catch (SQLException e) { //SQL 에러
			out.println("DB에 연결할 수 없습니다.");
			return;
		} catch (ClassNotFoundException e) { //드라이버 못찾을때
			out.println("드라이버 클래스를 찾을수 없습니다.");
			return;
		}
		
		out.println("DB 연결 테스트 완료!");
		
		try {
			conn.close(); // DB 연결 종료
		} catch (SQLException e) {
			out.println("DB 연결 종료 에러");
		}
	}
}
