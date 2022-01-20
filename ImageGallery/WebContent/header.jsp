<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 폴더이름이 바뀔 경우를 대비해서 달러표시{pageContext.request.contextPath}=콘텍스트까지의 주소 사용 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<title>${param.title}</title>
</head>
<body>
<div class="headerWrapper">
	<div class="header">
		<img src="${pageContext.request.contextPath}/images/logo.png" />
		<span id="title"></span>
	</div>
</div>

<div class="content"> 