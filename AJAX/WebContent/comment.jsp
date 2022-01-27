<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
	String comment = request.getParameter("comment");
String email = request.getParameter("email");

if (comment == null || comment.trim().equals("") || email == null || email.trim().equals("")) { //이메일에 @와 .이 있을 경우
	out.print("댓글 내용과 이메일을 적어주세요.");
} else {

	try {
		String url = "jdbc:mysql://localhost:3307/demo?useSSL=false";
		Connection conn = DriverManager.getConnection(url, "root", "1234");

		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO comment(comment, email) VALUES (?,?)");
		pstmt.setString(1, comment);
		pstmt.setString(2, email);
		int i = pstmt.executeUpdate(); // sql 실행 결과는 숫자로 1일때 정상 입력됨

		pstmt = conn.prepareStatement("SELECT * FROM comment ORDER BY id DESC");
		ResultSet rs = pstmt.executeQuery(); // sql 실행후 결과를 rs에 저장

		out.print("<hr>");
		out.print("<h2>Comments : </h2>");
		while (rs.next()) {
			out.print("<div class='box'>");
			out.print("<p>" + rs.getString(2) + "</p>");
			out.print("<p><strong>글쓴이 : " + rs.getString(3) + "</strong></p>");
			out.print("</div>");
		}
		conn.close();

	} catch (Exception e) {
		e.printStackTrace(); // 예외 발생시 예외 출력
	}
}
%>