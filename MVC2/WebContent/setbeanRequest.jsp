<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp에 자바 빈 객체 만들기 : id는 객체의 이름 / scope는 범위 -->
<!-- Request -->
<jsp:useBean id="user2" class="beans.User" scope="request" />

<!-- 자바 빈에 값을 입력하기 (set메소드)-->
<jsp:setProperty property="email" name="user2" value="son@naver.com"/>
<jsp:setProperty property="password" name="user2" value="1234"/>

<jsp:forward page="getbeanRequest.jsp" />
<!-- setbeanRequest에서 forward로 주소 변경 없이 파라미터가 함께 넘어가서 바로 값이 출력됨-->

</body>
</html>