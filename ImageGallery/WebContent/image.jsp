<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 위에거 : JSTL function 태그 - 문자열 조작, 문자열 길이를 지원 -->
<!-- fmt 태그 - 소수점 자리 -->

<c:import url="header.jsp">
	<c:param name="title" value="단독 이미지"></c:param>
</c:import>

<!-- 트랜젝션을 사용해서 ds 삭제 가능 -> 아래 코드에서도 dataSource="ds" 삭제 -->
<%-- <sql:setDataSource var="ds" dataSource="jdbc/webshop" /> --%>
<sql:transaction dataSource="jdbc/webshop">

<!-- image.param = id값 -> 1줄의 결과만 나옴 -->
<sql:query var="result" sql="select * from images where id=?">
	<sql:param>${param.image}</sql:param>
</sql:query>

<c:set var="image" scope="page" value="${result.rows[0]}" />
<c:set var="picname" scope="page" value="${image.stem}.${image.image_extension}" />
<c:set var="average_ranking" scope="page" value="${image.average_ranking}" />

<%-- action이 "rate"이면 rankings와 average_ranking을 업데이트 한다. sql update ranking  --%>
<c:if test='${param.action == "rate"}'>
	<c:set scope="page" var="newRating" 
		value="${(image.average_ranking * image.rankings + param.rating) / (image.rankings + 1)}" />
	<c:set scope="page" var="average_ranking" value="${newRating}"/>
	
	<sql:update sql="update images set average_ranking=?, rankings=? where id=?">
		<sql:param>${newRating}</sql:param>
		<sql:param>${image.rankings + 1}</sql:param>
		<sql:param>${param.image}</sql:param>
	</sql:update>
</c:if>

</sql:transaction> <!-- 트랜젝션은 sql 사용하는 부분까지 -->

<div class="container">
	<div class="heading">
      <h1><c:out value="${fn:toUpperCase(fn:substring(image.stem, 0, 1))}${fn:toLowerCase(fn:substring(image.stem, 1, -1))}" ></c:out></h1>
      <div class="rating">Rated: <fmt:formatNumber value="${image.average_ranking}" maxFractionDigits="1"/></div>
    </div>
    <div class="flex-box">
      <div class="picture">
        <div class="imageby">Image by <a href="#">${image.attribution_name}</a></div>
        <img src="${pageContext.request.contextPath}/pics/${picname}">
      </div>
      <div class="rating-radio">
      	<form action='<c:url value ="/gallery" />' method="post">
      	  <input type="hidden" name="action" value="rate" />
      	  <input type="hidden" name="image" value="${image.id}" />
        	<h3>점수를 선택하기</h3>
        	<div><input type="radio" name="rating" value="5" />5 - 최고! </div>
        	<div><input type="radio" name="rating" value="4" />4 - 좋은작품! </div>
        	<div><input type="radio" name="rating" value="3" />3 - 괜찮음 </div>
        	<div><input type="radio" name="rating" value="2" />2 - 그럭저럭 </div>
       		<div><input type="radio" name="rating" value="1" />1 - 지뢰작 </div>
        	<p>
        		<input type="submit" name="submit" value="OK">
        		<button><a href='<c:url value="/gallery?action=home"/>'>돌아가기</a></button>
        	</p>
      	</form>
      </div>
    </div>
</div>

<%-- <div class="container">
<!-- 첫번째 글자를 대문자로 사진 이름 출력 -->
<h2>
	<c:out value="${fn:toUpperCase(fn:substring(image.stem, 0, 1))}${fn:toLowerCase(fn:substring(image.stem, 1, -1))}" ></c:out>
</h2>

<div class="rating">Raited : </div>

<img src="${pageContext.request.contextPath}/pics/${picname}">

</div> --%>

<c:import url="footer.jsp"></c:import>
