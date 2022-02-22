<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/includes/header.jsp" />

<style>
.container{
  background-color: lightgray;
  display: flex;
}
.container2{
  margin-left: 40px;
}
.info{
  word-break:break-all;
}
h3{
  margin-bottom: 30px;
}
.btn:first-child{
  margin-right: 60px;
}
</style>

<h2>상품 디테일 페이지</h2>

<div class="container">
  <img src="<c:out value='${product.prodImg}' />" width="600" alt="상품사진" />
  <div class="container2">
    <h3>상품명: <c:out value="${product.prodName}" /></h3>
    <p>상품번호: <c:out value="${product.prodID}" /></p>
    <p>판매자ID: <c:out value="${product.farmID}" /></p>
    <p>가격: <c:out value="${product.prodPrice}" />원</p>
    <p>남은수량: <c:out value="${product.prodInven}" />개</p>
    <a class="btn btn-primary" href="#">장바구니 추가</a>
    <a class="btn btn-secondary mt-auto" href="<%= request.getContextPath() %>/reviewController?cmd=find&id=<c:out value="${product.prodID}" />">리뷰보기</a><jsp:include page="/includes/footerFar.jsp" />
  </div>
  <div class="info">
  <p>상품설명</p>
  <p><c:out value="${product.prodInfo}" /></p>
  </div>
</div>

<jsp:include page="/includes/footer.jsp" />

<script>
	$('.nav-link').removeClass('active');
	$('#m-product').addClass('active');
</script>
