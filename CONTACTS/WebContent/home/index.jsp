<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />
	<div class="container">
		<div class="jumbotron mt-5">
			<h1 class="display-4">못난이 농산품</h1>
			<p class="lead mt-3">JSP, Servlet, JDBC, MySQL, DataTables, Modal <small class="text-muted">(plugin jQuery)</small>.</p>
			<hr class="my-4">
			<p>
				못난이 농산품 판매 사이트입니다.
			</p>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
	<script>
		$('.nav-link').removeClass('active');
		$('#m-home').addClass('active');
	</script>
<jsp:include page="/includes/footer.jsp" />