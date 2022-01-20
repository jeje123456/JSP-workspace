package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;

@WebServlet("/pass")
public class PassObjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 각각의 user 객체들을 다른 scope로 전달
		User user1 = new User("Bob", 1);
		User user2 = new User("Mike", 2);
		User user3 = new User("Sue", 3);
		// 리퀘스트 스코프 : 리퀘스트에 저장(receiveObjects.jsp로 열면 리퀘스트가 달라서 출력안됨)
		request.setAttribute("user1", user1);
		// 세션 스코프 : 세션에 저장(브라우저가 다르면 세션이 다르므로 출력 안 됨)
		HttpSession session = request.getSession();
		session.setAttribute("user2", user2);
		//컨텍스트 스코프 : 컨텍스트에 저장(브라우저가 달라도 출력 됨)
		ServletContext context = getServletContext();
		context.setAttribute("user3", user3);
		
		// map 객체 보내기
		Map<String, String> map = new HashMap<>();
		// map.put(key값, value값);
		map.put("fruit1", "apple");
		map.put("fruit2", "orange");
		request.setAttribute("mapList", map);
		
		// List 객체 보내기
		List<User> list = new ArrayList<User>();
		list.add(new User("dog", 1));
		list.add(new User("cat", 2));
		list.add(new User("cow", 3));
		session.setAttribute("list", list);
		
		//receiveObjects.jsp로 전송
		request.getRequestDispatcher("/receiveObjects.jsp").forward(request, response);
	}

}
