<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--여러줄 자바코드 작성--%>
	<%
	String user = request.getParameter("user");
	String id = request.getParameter("id");
	//jsp에서는 바로 out 객체를 사용 가능하다.
	out.println("유저 파라메터 : " + user);
	out.println("아이디 파라메터 : " + id);
	%>
<%-- http://localhost:8090/Deployment/parameters.jsp?user=Pengsu&id=123 --%>
</body>
</html>