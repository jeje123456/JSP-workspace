package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext(); //이 애플리케이션의 컨텍스트 객체 리턴
		//hits는 object형이기 때문에 integer 클래스로 형변환
		Integer hits = (Integer) context.getAttribute("hits"); //hits라는 속성값 가져오기
		
		if(hits == null) hits = 0; // 처음 한번 hits가 없을때 0으로 초기화
		else hits++; // hits값이 있다면 +1 해준다.
		
		context.setAttribute("hits", hits);// context에 hits라는 이름으로 hits 속성값 저장
		
		PrintWriter out = response.getWriter();
		out.println("Hits : " + hits);
		// Session은 브라우저별로 다른데 Context는 하나밖에 없어서 모두 공유된다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
