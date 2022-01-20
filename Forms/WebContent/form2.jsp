<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML 폼 Form</title>
</head>
<body>
<!-- action : 액션의 주소로 form안에 입력창에 입력한 데이터와 함께 서버로 요청 -->
<!-- action 주소는 domain 주소 포트번호 뒤부터 입력(서블릿 실행하여 확인) -->
<form action="/Forms/formhandler.jsp" method="get">

<!-- 전송 버튼을 클릭하면 Contoller로 요청함 -->
<input type="text" name="user" placeholder="유저"><br>
<input type="password" name="password" placeholder="페스워드"><br>
<input type="submit" value="전송">

</form>
</body>
</html>