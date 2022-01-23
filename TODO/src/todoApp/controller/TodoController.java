package todoApp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todoApp.dao.TodoDao;
import todoApp.dao.TodoDaoImpl;
import todoApp.model.Todo;

// 서블릿이 기본"/"주소이면 다른 서블릿 "/resister", "/login" 등을 제외한 모든 요청을 여기에서 처리한다.
@WebServlet("/")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoDao todoDAO;

	public void init() {
		todoDAO = new TodoDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response); // post로 요청하더라도 get으로 처리
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getcontextPath() : localhost:8090/TODO 까지의 주소
		// getServletPath() : 요청주소가 localhost:8090/TODO/new => "/new" 가 action의 값
		String action = request.getServletPath();

		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertTodo(request, response);
			break;
		case "/delete":
			deleteTodo(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateTodo(request, response);
			break;
		case "/list":
			listTodo(request, response);
			break;
		default: // 요청 주소가 기본 또는 잘못 되었을 경우 로그인 페이지로 이동
			response.sendRedirect("login");  
			break;
		} // switch문 끝

	}

	private void listTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Todo> listTodo = todoDAO.selectAllTodos(); // DB에서 할일들을 가져와서 리스트에 저장
		request.setAttribute("listTodo", listTodo);		// 리스트를 리퀘스트에 저장
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void insertTodo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void updateTodo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
}
