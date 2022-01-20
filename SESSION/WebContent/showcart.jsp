<%@page import="demo.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Cart객체 생성을 위해서 Cart + c + s 로 import하기 -->
<% Cart cart = (Cart)session.getAttribute("cart"); %>

<p>장바구니 아이템 개수 : <%= cart.getTotalItems() %>



</body>
</html>