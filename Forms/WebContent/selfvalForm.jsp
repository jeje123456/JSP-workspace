<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- form에 입력한 내용을 셀프 검사해서 통과하면 Controller로 데이터 보냄 -->

<!-- 아래 form에 입력한 내용으로 user1 객체를 생성 -->
<jsp:useBean id="user1" class="beans.User3" scope="session" />
<jsp:setProperty property="*" name="user1"/>

<%  /* <jsp:setProperty 아래줄에 입력된 이메일,패스워드를 검사해서 적합하면 
	Controller 서블릿으로 forward 한다. */
	String action = request.getParameter("action");
	if(action != null && action.equals("formsubmit")){
		if(user1.validate()){
			request.getRequestDispatcher("/Controller").forward(request, response);
		}
	}
%>

<h2><%=user1.getMessage() %></h2>

<form action="/Forms/selfvalForm.jsp" method="post">

<input type="hidden" name="action" value="formsubmit">
<input type="text" name="email" placeholder="email" value="<%=user1.getEmail()%>"><br>
<input type="text" name="password" placeholder="password" value="<%=user1.getPassword()%>"><br>
<input type="submit" value="전송">

</form>

</body>
</html>