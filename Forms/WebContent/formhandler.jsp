<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML 폼 Form</title>
</head>
<body>
<!-- jsp태그로 객체 생성 -->
<jsp:useBean id="user" class="beans.User" />
<!-- 파라미터로 필드 변수값 입력 받음 -->
<jsp:setProperty property="*" name="user"/>

<p> 유저 : <%= user.getUser() %>
<p> 비밀번호 : <%= user.getPassword() %>
</body>
</html>