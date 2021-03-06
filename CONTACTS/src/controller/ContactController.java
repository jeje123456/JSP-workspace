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
import javax.sql.DataSource;

import dao.ContactDao;
import model.Contact;
import utills.Json;

@WebServlet("/contact")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContactDao contactDao;

	@Resource(name = "jdbc/demo") // context.xml의 Connection Pool 연결
	private DataSource dataSource; // DB 연결할 수 있는 Connection Pool 객체 = 서블렛에 연결되어있는 DataSource

	@Override
	public void init() throws ServletException { // 서블릿 생성(시작)시 contactDao(DB객체에 dataSource)
		// 서블렛에서 ContactDao를 객체생성해서 DB연결 할 때 필요한 dataSource는 위의 'jdbc/demo'의 dataSource를
		// 여기에 넣어줌
		contactDao = new ContactDao(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 출력 확인
		//List<ManagerOrder> ordersList = managerOrderDao.findAll();
		//ordersList.forEach(ManagerOrder -> System.out.println(ManagerOrder.toString()));
		
		req.setCharacterEncoding("UTF8");
		// 파라메타 cmd 값을 읽어서 액션으로 저장하는데 만약 값이 null이 아니면 req.getParameter("cmd")가 들어가고 null이면 "list"로 대체
		String action = req.getParameter("cmd") != null ? req.getParameter("cmd") : "list";

		switch (action) {
		case "post": // 새로 입력 저장
			save(req, resp);
			break;
		case "edit": // 수정하기 창을 표시
			edit(req, resp);
			break;
		case "update": // 실제 수정하기
			update(req, resp);
			break;
		case "delete": // 삭제하기
			delete(req, resp);
			break;
		default: // 전체 연락처를 화면에 테이블로 표시
			list(req, resp);
			break;
		}

		// 테스트용
		// List<Contact> list = contactDao.findAll();
		// list.forEach(contact -> System.out.println(contact.toString()));
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contact> contacts = contactDao.findAll(); //DB모든 연락처 가져오기
		req.setAttribute("contacts", contacts); // 받아온 연락처를 req에 저장
		RequestDispatcher rd = req.getRequestDispatcher("contact/list.jsp");
		rd.forward(req, resp); // 리퀘스트를 유지하면서 list.jsp페이지로 이동

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		boolean isDeleted = contactDao.delete(id);
		
		if(isDeleted) {
			System.out.println("삭제 완료!");
			new Json(resp).sendMessage(true, "연락처 삭제됨");
		}

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		Contact contact = new Contact();
		
		contact.setId(Integer.parseInt(req.getParameter("id")));
		contact.setName(req.getParameter("name"));
		contact.setEmail(req.getParameter("email"));
		contact.setPhone(req.getParameter("phone"));
		
		boolean isUpdated = contactDao.update(contact); // 참이면 저장완료
		
		if (isUpdated) {
			System.out.println("수정 완료!");
			new Json(resp).sendMessage(true, "연락처 수정됨");
		}

	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id")); //문자열 id를 정수 변환
		
		Contact contact = contactDao.find(id); // id로 연락처 객체 찾기
		if(contact != null) {
			System.out.println("찾기 완료!");
			new Json(resp).sendContact(contact); // 연락처를 상태와 제이슨으로 변환해서 출력
		}

	}

	private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contact contact = new Contact();
		
		contact.setName(req.getParameter("name"));
		contact.setEmail(req.getParameter("email"));
		contact.setPhone(req.getParameter("phone"));
		
		boolean isSaved = contactDao.save(contact); // 참이면 저장완료
		
		if (isSaved) {
			System.out.println("입력 완료!");
			new Json(resp).sendMessage(true, "연락처 입력됨");
		}
		
		//list(req, resp); // 다시 리스트 화면 출력 => ajax 사용전
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
