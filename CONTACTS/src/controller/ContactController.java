package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ContactDao;
import model.Contact;

@WebServlet("/contact")
public class ContactController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ContactDao contactDao;
	
	@Resource(name = "jdbc/demo")	//context.xml의 Connection Pool 연결
	private DataSource dataSource;  // DB 연결할 수 있는 Connection Pool 객체 = 서블렛에 연결되어있는 DataSource

	@Override 
	public void init() throws ServletException { // 서블릿 생성(시작)시 contactDao(DB객체에 dataSource)
		// 서블렛에서 ContactDao를 객체생성해서 DB연결 할 때 필요한 dataSource는 위의 'jdbc/demo'의 dataSource를 여기에 넣어줌
		contactDao = new ContactDao(dataSource);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contact> list = contactDao.findAll();
		list.forEach(contact -> System.out.println(contact.toString()));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
