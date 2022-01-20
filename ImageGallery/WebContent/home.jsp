<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<c:import url="header.jsp">
	<c:param name="title" value="홈페이지"></c:param>
</c:import>

<%-- 동적 컨텐츠(내용)이 들어감  --%>

<sql:setDataSource var="ds" dataSource="jdbc/webshop" />
<!-- ds = dataSource -->

<!-- results = sql 결과 배열(10개까지) -->
<%-- <sql:query var="results" dataSource="${ds}" sql="select * from images limit 10" /> --%>
<!-- 모든 이미지 -->
<sql:query var="results" dataSource="${ds}" sql="select * from images order by id" />

<table class="images">
<c:set var="tablewidth" value="8" />

<%-- results에는 쿼리의 실행결과이고 이것을 results.rows로 받아 한줄씩 row로 반복 --%>
<!-- results.rows = 리스트 --> <!-- DB에는 사진의 주소만 입력함 -->
<!-- 액션 = image/ 이미지 파라메타 = {image.id} -->
<!-- a태그로 사진 클릭 가능(마우스 올리면 주소 나올 -> 이 주소가 controller로 넘어가서 서버로 가야됨)-->
<c:forEach var="image" items="${results.rows}" varStatus="row">
			<!-- 행의 개수 나누기 8의 나머지값이 0 이면 tr로 나눔 : 8개가 한줄 -->
	<c:if test="${row.index % tablewidth == 0}"><tr></c:if>
	
	<c:set var="picname" scope="page" value="${image.stem}.${image.image_extension}" />

	<td>
		<a href="<c:url value="/gallery?action=image&image=${image.id}" />">
		<img src="${pageContext.request.contextPath}/pics/${picname}">
		</a>
	</td>
	
	<c:if test="${row.index+1 % tablewidth == 0}"></tr></c:if>
	
</c:forEach>

</table>

<c:import url="footer.jsp"></c:import>
