<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 리다이렉트 : url이 바뀜 -> 새로운 페이지를 요청함 -->
<% response.sendRedirect("index.jsp"); %>
<!-- 주소창이 redirect.jsp가 아니라 index.jsp로 변경되어있음 -->
</body>
</html>