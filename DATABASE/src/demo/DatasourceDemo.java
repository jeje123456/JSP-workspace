package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/DatasourceDemo")
public class DatasourceDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/webshop")
	private DataSource ds; // 데이터 소스 ds로 DB연결
	// DataSource 클래스 불러오기 : import javax.sql.DataSource;
	//@Resource(name = "jdbc/webshop") : context.xml의 name값과 같이 설정   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //한글설정
		PrintWriter out = response.getWriter(); // out 객체를 사용하여 문자 출력 가능
		// import java.sql.Connection;
		Connection conn = null;
		
		try {
			conn = ds.getConnection(); // 1. DB 연결
		} catch (SQLException e) { //SQL 에러
			out.println("DB에 연결할 수 없습니다.");
			return;
		}
		
		out.println("DB 연결 테스트 완료!");
		
		try {
			conn.close(); // 실제로는 conn을 닫는것 대신에 커넥션을 커넥션 풀로 반환
		} catch (SQLException e) {
			out.println("DB 연결 종료 에러");
		}
	}

}
