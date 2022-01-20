<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- JSP에 다른 파일 포함하기 --%>
<!-- 주석 : ctrl+shift+/ : 주석 -->
<!-- 정적 인클루드 : 미리 컴파일해둠, 자주 바꾸지 않을때 -->
<%@ include file="copyright.txt" %>
<br>
<!-- 동적 인클루드 : 볼때마다 새로고침, 자주 수정할때 -->
<!-- <jsp:include page="update.txt"></jsp:include>인데 txt뒤에 닫는 /쓰면 없어짐-->
<jsp:include page="update.txt"/>
<br>
<!-- jsp파일 포함하기 : 자바 변수등을 넣을려면 정적 include를 사용 -->
<%@ include file = "variable.jsp" %>
<%= name %>

<!-- 실행시(runtime)에 두개의 html중에 id가 있을 경우 login.html 없을 경우 fail.html -->
<% String id = request.getParameter("id"); %>

<!-- 정적 include하면 한글 깨짐, 영어만 됨 -->
<!-- 
<% if(id==null){ %>
<%@ include file="fail.html" %>
<% } else { %>
<%@ include file="login.html" %>
<% } %> 
-->

<!-- include할 파일이 결정될때는 동적 include -->
<% if(id==null){ %>
<jsp:include page="fail.html"/>
<% } else { %>
<jsp:include page="login.html"/>
<% } %>
</body>
</html>