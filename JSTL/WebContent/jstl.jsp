<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 태그 라이브러리(jstl taglib) 접두사 = prefix = "c"-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 출력 태그 -->
<c:out value="JSTL 안녕!"></c:out>

<!-- JSTL로 bean 객체 사용 : id가 test인 bean 객체 만들기 -->
<jsp:useBean id="test" class="beans.TestBean" />
<p> getInfo메소드 : <c:out value="${test.info}" />
<!-- 변수 사용 = 달러표시{ } -->
<br>
<hr>
<br>
<!-- 파라메타 가져오기 : 달러표시{param.이름} -->
파라메타: <c:out value="${param.name}" />

<!-- IF문 -->
<c:if test="${param.name == 'bob'}">
	헬로우 bob
</c:if>
<c:if test="${param.name != 'bob'}">
	bob이 아니군요.
</c:if>
<br>
<hr>
<br>
<!-- Switch 문 : JSTL choose, when(케이스), otherwise(디폴트) 사용 -->
<c:choose>
	<c:when test="${param.id == 1}">
		<b>아이디는 1이다.</b>
	</c:when>
	<c:when test="${param.id == 2}">
		<b>아이디는 2이다.</b>
	</c:when>
	<c:otherwise>
		<b>아이디는 1 또는 2가 아니다.</b>
	</c:otherwise>
</c:choose>
<br>
<hr>
<br>
<!-- 반복문 -->
<c:forEach var="i" begin="0" end="10" step="2">
	i의 값 : <c:out value="${i}" /> <br>
</c:forEach>

</body>
</html>