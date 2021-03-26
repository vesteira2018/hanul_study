<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:choose>
	<c:when test="${category eq 'login'}">
		<c:set var="title" value="로그인: " /> 
	</c:when>
</c:choose>

<title>${title}IoT</title>
<link rel='icon' type='image/x-icon' href='imgs/hanul.ico'>
<link rel='stylesheet' type='text/css' 
		href='css/common.css?v=<%=new java.util.Date().getTime() %>'>
<script src='https://code.jquery.com/jquery-3.5.1.min.js'></script>

</head>
<body>
<div id='content'>
	<tiles:insertAttribute name="content"/>
</div>
</body>
</html>