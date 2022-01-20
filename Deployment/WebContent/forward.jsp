<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 포워드 : url의 변동이 없음. 파라메터(request 요청정보)까지 같이 이동됨 -->
<!-- 리다이렉트 : url을 수정해서 새페이지로 이동함 -->
헬로우!
<jsp:forward page="index.jsp"/>
<!-- http://localhost:8090/Deployment/forward.jsp 열기 -->
<!-- forward.jsp의 헬로우를 볼 틈도 없이 index.jsp로 이동한다. 주소는 forward.jsp임. -->
</body>
</html>