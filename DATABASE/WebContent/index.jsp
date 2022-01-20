<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- request.getContextPath() : DATABASE 주소 -->
	<p> <a href="<%= request.getContextPath()%>/Controller?action=login">로그인</a>
	<p> <a href="<%= request.getContextPath()%>/Controller?action=createaccount">회원가입</a>
</body>
</html>