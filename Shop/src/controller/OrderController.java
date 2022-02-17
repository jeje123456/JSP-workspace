package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.OrderDao;
import member.Order;

@WebServlet("/manager")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderDao orderDao;
	
	@Resource(name="jdbc/shop")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		orderDao = new OrderDao(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String action = request.getParameter("cmd") != null ? request.getParameter("cmd") : "orderList";
		
		switch (action) {
			case "update":
				update(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			default:
				ordersList(request, response);
				break;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void ordersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orders = orderDao.findAll();
		
		request.setAttribute("orders", orders);
		
		RequestDispatcher rd = request.getRequestDispatcher("manager/ordersList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
