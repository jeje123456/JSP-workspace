<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 페이지</h1>
<form action="/MVCForm/Controller" method="post">

<input type="hidden" name="action" value="dologin">
<input type="text" name="email" placeholder="email" value="<%=request.getAttribute("email")%>"><br>
<input type="text" name="password" placeholder="password" value=""><br>
<input type="submit" value="전송">

</form>

<!-- 로그인 실패 메세지를 form 아래 html 에 출력 -->
<h2><%= request.getAttribute("valmessage") %></h2>

</body>
</html>