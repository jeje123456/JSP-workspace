<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />
	<div class="container">
		<div class="jumbotron mt-5">
			<h1 class="display-4">연락처 관리</h1>
			<p class="lead mt-3">JSP, Servlet, JDBC, MySQL, DataTables, Modal <small class="text-muted">(plugin jQuery)</small>.</p>
			<hr class="my-4">
			<p>
				모달 창 및 jQuery DataTables 플러그인을 사용하여 연락처 추가, 보기, 
				업데이트 및 제거 기능이 있는 <br>간단한 연락처 관리 웹 응용 프로그램입니다.
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