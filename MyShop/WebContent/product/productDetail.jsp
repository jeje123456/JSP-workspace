<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/includes/header.jsp" />

<h2>상품 디테일 페이지</h2>
<a href="<%= request.getContextPath() %>/reviewDetailFar.jsp">리뷰상세페이지</a>

<jsp:include page="/includes/footer.jsp" />

<script>
	$('.nav-link').removeClass('active');
	$('#m-product').addClass('active');
</script>
