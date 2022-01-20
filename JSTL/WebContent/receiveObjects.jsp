<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> <c:out value="${user1.name}"></c:out>
<p> <c:out value="${user2.name}"></c:out>
<p> <c:out value="${user3.name}"></c:out>
<br><hr>

<!-- map 리스트 출력 -->
<p> <c:out value="${mapList.fruit1}"></c:out>
<p> <c:out value="${mapList.fruit2}"></c:out>
<p> <c:out value="${mapList['fruit1']}"></c:out>
<p> <c:out value="${mapList['fruit2']}"></c:out>
<br><hr>

<!-- arraylist 출력 (많이씀 중요!!!)-->
<c:forEach var="item" items="${list}">
	${item.id} : ${item.name} <br>
</c:forEach>
<br><hr>

<!-- 테이블 안에 입력 -->
<table border="1">
<tr>
	<th>ID</th><th>이름</th>
</tr>

<c:forEach var="item" items="${list}">
<tr>
	<td>${item.id}</td><td>${item.name}</td>
</tr>
</c:forEach>

</table>
</body>
</html>