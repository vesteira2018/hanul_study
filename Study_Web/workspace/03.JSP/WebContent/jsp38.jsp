<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP38</title>
</head>
<body>
<c:set var="date" value="<%=new Date() %>"/>
<h3>날짜와 시간의 기본적인 표시 : ${date }</h3>
○ 오늘의 날짜 : <fmt:formatDate value="${date}" type="date"/><br/>
○ 현재의 시각 : <fmt:formatDate value="${date}" type="time"/><br/>
○ 날짜와 시각 : <fmt:formatDate value="${date}" type="both"/><br/>
○ short : <fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short"/><br/>
○ medium : <fmt:formatDate value="${date}" type="both" dateStyle="medium" timeStyle="medium"/><br/>
○ long : <fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long"/><br/>
○ full : <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full"/><br/>
○ pattern1 : <fmt:formatDate value="${date}" type="date" pattern="yyyy년 MM월 dd일(E)"/><br/>
○ pattern2 : <fmt:formatDate value="${date}" type="time" pattern="(a) hh시 mm분"/><br/>
</body>
</html>
