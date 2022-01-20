<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Step1 : HTML form 작성 -->
<form action="todo-demo.jsp">
	새로운 할 일 : <input type="text" name="theItem" />
	<input type="submit" value="입력" />
</form>

<!-- Step1.5 : 입력받은 아이템을 테스트 출력 : 확인완료해서 주석처리 -->
<%-- <%= request.getParameter("theItem") %> --%>

<!-- Step2 : To do 리스트에 새 아이템 추가 -->
<%
	//세션에 todo리스트가 있는지 확인(기존의 todoList 가져오기/ 기존리스트가 없으면 null)
	List<String> items = (List<String>)session.getAttribute("todoList");

	// todo리스트가 존재하지 않는다면 새로만들기
	if (items == null){
		items = new ArrayList<String>();
		session.setAttribute("todoList", items);
	}
	// form에 입력한 데이터를 리스트에 추가하고 그 리스트를 세션에 저장
	String theItem = request.getParameter("theItem");
	// 입력한 값이 null값이나 공백이 아니면 입력
	if((theItem != null)&&(!theItem.trim().equals(""))){
		// 같은 내용이 없을때 추가(리스트에 같은 할일이 있으면 입력 안함)
		if(!items.contains(theItem.trim())){
			items.add(theItem);
			session.setAttribute("todoList", items);
		}
	}
%>

<!-- todoList 출력하기 -->
<hr>
<b>할 일 리스트 : </b>
<ol>
<%
	for(String temp : items) {
		out.println("<li>" + temp + "</li>");
	}
%>
</ol>
</body>
</html>