<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- controller 에서 저장한 orders(변수 : List<Order> orders)가 여기로 넘어옴 -->
	<c:forEach var="order" items="${orders}">
		<tr>
			<td><c:out value="${order.orderID}" /></td>
			<td><c:out value="${order.cartID}" /></td>
			<td><c:out value="${order.userID}" /></td>
			<td><c:out value="${order.userName}" /></td>
			<td><c:out value="${order.userAdd}" /></td>
			<td><c:out value="${order.userTel}" /></td>
			<td><c:out value="${order.prodID}" /></td>
			<td><c:out value="${order.prodName}" /></td>
			<td><c:out value="${order.prodPrice}" /></td>
			<td><c:out value="${order.prodQuantity}" /></td>
			<td><c:out value="${order.totalPrice}" /></td>
			<td><c:out value="${order.farmID}" /></td>
			<td><c:out value="${order.farmTel}" /></td>
			<td><c:out value="${order.farmCheck}" /></td>
			<td><c:out value="${order.TrackNum}" /></td>
			<td><c:out value="${order.is_status}" /></td>			
			<td>
				<button type="button" class="btn btn-info btn-sm btn-edit"
					data-id="<c:out value='${contact.id}' />">수정</button>
			</td>
			<td>
				<button type="button" class="btn btn-danger btn-sm btn-delete"
					data-id="<c:out value='${contact.id}' />" data-toggle="modal"
					data-target="#modal-delete">삭제</button>
			</td>
		</tr>
	</c:forEach>

</body>
</html>