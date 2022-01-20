package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		/**같은세션(같은 브라우저 일때) 접속시 그 속성이 있으면 다시 저장할 필요가 없다. (중복)**/
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null) { // 카트 객체가 없을 경우 새로 생성
			cart = new Cart();
		}
		cart.setTotalItems(7);
		
		//session.setAttribute(name, value); 
		// 새션(서버) 객체에 속성 이름으로 값(Object타입=cart)을 저장
		session.setAttribute("cart", cart);
		
		getServletContext().getRequestDispatcher("/showcart.jsp").forward(request, response);
		/**
		 * Session 서블릿 => Cart클래스 객체 cart 만들고 세션에 저장 => JSP 페이지로 forward 
		 * => showcard.jsp 에서 session에서 객체를 불러와 카트의 아이템갯수 출력
		 * **/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
