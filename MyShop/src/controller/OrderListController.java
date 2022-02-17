package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.OrderListDao;
import page.OrderList;

@WebServlet("/managerOrderlist")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderListDao managerOrderDao;
	
	@Resource(name = "jdbc/shop")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		managerOrderDao = new OrderListDao(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF8");
		// 상황연산자로 파라메타 cmd 값을 읽어서 액션으로 저장하는데 만약 값이 null이 아니면 request.getParameter("cmd")가 들어가고 null이면 "list"로 대체
		String action = request.getParameter("cmd") != null ? request.getParameter("cmd") : "list";
		
		switch (action) {
		case "delete": // 삭제하기
			delete(request, response);
			break;
		case "edit": // 수정하기 창을 보여줌
			showEditForm(request, response);
			break;
		case "update": // 실제 수정하기
			update(request, response);
			break;
		case "list": // 주문 내역 전체 출력
			ordersList(request, response);
			break;
		default: // 요청 주소가 기본 또는 잘못 되었을 경우 ordersList로 이동
			ordersList(request, response);
			break;
		} // switch문 끝
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void ordersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderList> ordersList = managerOrderDao.findAll(); // DB의 모든 주문내역 가져오기
		
		request.setAttribute("ordersList", ordersList);
		
		RequestDispatcher rd = request.getRequestDispatcher("orders/ordersList.jsp");
		rd.forward(request, response); // 리퀘스트를 유지하면서 ordersList.jsp페이지로 이동
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
