<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>JSP페이지</h1>
    <h1>주소 : hello.jsp</h1>
	 <!-- <% %> : 여러줄 자바 스크립틀릿 : 자바코드 여러개 사용 가능-->
    <% 
			String text = " 오늘의 날짜는 : ";
			out.println(text); // out.println으로 출력
		%>
		<!-- <%= %> : 자바 한줄 Express 태그, 변수 1개를 화면에 바로 출력-->
		<%=new java.util.Date() %>
  </body>
</html>
