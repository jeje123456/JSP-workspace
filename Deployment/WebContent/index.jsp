<%-- 디렉티브 태그로 import하기 --%>
<%@page import="gui.TextOutput"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 기본 페이지</h1>
<%-- java.util.Date()를 쓰거나 Date+ctrl+space해서 java.util import하기 --%>
	<%= new Date() %>
	<br>
<%-- 다른 클래스 import, 객체 생성 및 메소드 사용하기 --%>
	<%= new TextOutput().getInfo() %>
</body>
</html>