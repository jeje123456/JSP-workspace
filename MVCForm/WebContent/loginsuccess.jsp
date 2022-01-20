<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인 성공!</h1>
<!-- loginsuccess 페이지에서 request.getArribute(속성이름)으로 값을 불러온다.-->
<p> 이메일 : <%= request.getParameter("email") %> 

</body>
</html>