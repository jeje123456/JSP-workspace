<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
	String strId = request.getParameter("id");
	
	if(strId == null || strId.trim().equals("")) { // 아이디가 null이거나 공백이면
		out.print("아이디를 입력해 주세요.");
	} else {
		int id = Integer.parseInt(strId);
		
		try{
			String url = "jdbc:mysql://localhost:3307/demo?useSSL=false";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMP WHERE id=?");
			pstmt.setInt(1,id);
			
			ResultSet rs = pstmt.executeQuery(); // sql 실행 후 결과를 rs에 저장
			
			if(rs.next()){
				out.print(rs.getInt("id") + " " + rs.getString("name"));
			} else{
				out.print("테이블에 해당 id가 없습니다.");
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생시 예외 출력
		}
	}
%>