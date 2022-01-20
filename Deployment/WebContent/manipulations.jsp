<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- http://localhost:8090/Deployment/manipulations.jsp --%>
<% for(int i=0; i<5; i++){ %>
<%-- <p>이 태그는 5번 반복됩니다. --%>
<p> 이 태그는 <%= i %>번째 반복됩니다.
<% } %>

<%-- http://localhost:8090/Deployment/manipulations.jsp?id=7 --%>
<%
String id = request.getParameter("id");
if(id == null){
%>
<p> id가 입력되지 않았습니다.
<p> ID 파라미터 없음
<% } else {%>
<P> ID 파라미터 : <%= id %>
<% } %>
</body>
</html>