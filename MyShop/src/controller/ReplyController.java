package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Reply;
import dao.ReplyDao;


@WebServlet("/replyController")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReplyDao replyDao;
	
	@Resource(name = "jdbc/shop")
	private DataSource datasource;

    @Override
	public void init() throws ServletException {
		// 서블릿 컨테이터가 서블릿 객체를 생성한 후 맨 처음 딱 한번만 호출되는 메서드. ReplyDao의 datasource를 가져와 replyDao객체에 저장하여 사용
		replyDao = new ReplyDao(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("cmd") != null ? request.getParameter("cmd") : "find";
		
		try {
			switch (action) {
			case "find":
				find(request, response);
				break;
			case "edit":
				edit(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			default:
				find(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println("잘못된 접근입니다.");
		}
	}
	
	private void find(HttpServletRequest request, HttpServletResponse response) {
		// 리뷰ID가 같은 reply테이블의 행이 있을 경우 덧글을 보여준다
		int id = Integer.parseInt(request.getParameter("replyID"));
		
		Reply reply = replyDao.find(id);
		if(reply != null) {
			System.out.println("답글 찾기 완료");
			System.out.println(reply);
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 덧글작성버튼을 눌렀을때 덧글작성메서드가 실행되도록
		Reply reply = new Reply();

		reply.setFarmID(request.getParameter("farmID"));
		reply.setReplyContent(request.getParameter("replyContent"));
		reply.setReviewID(Integer.parseInt(request.getParameter("reviewID")));
		
		boolean isSaved = replyDao.save(reply);	// true이면 저장성공, false이면 실패
		
		if(isSaved) {
			// 리뷰리스트로 가도록 테스트한 후 받아온 정보의 reviewID를 사용해 리뷰디테일페이지로 바로 접속할수있는지 테스트
			response.sendRedirect("reviewController");
			System.out.println("입력완료@@");
		}

	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 덧글삭제버튼을 눌렀을때 덧글삭제메서드가 실행되도록
		int id = Integer.parseInt(request.getParameter("replyID")); 
		
		boolean delete = replyDao.delete(id);
		
		if(delete) {
			response.sendRedirect("reviewController?cmd=list");
		}else {
			System.out.println("삭제실패");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
