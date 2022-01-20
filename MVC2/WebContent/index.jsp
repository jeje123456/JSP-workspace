<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	<!-- MVC2 : context명 (앞의 주소는 상대주소로 생략)-->
	<!-- 
	<p><a href="/MVC2/Controller?action=login">Login 페이지로</a>
	<p><a href="/MVC2/Controller?action=about">About 페이지로</a>	
	-->
	<!-- context명이 바뀌어도 정상작동함 -->
	<%=request.getContextPath() %>
	<p><a href="<%=request.getContextPath() %>/Controller?action=login">Login 페이지로</a>
	<p><a href="<%=request.getContextPath() %>/Controller?action=about">About 페이지로</a>	
</body>
</html>