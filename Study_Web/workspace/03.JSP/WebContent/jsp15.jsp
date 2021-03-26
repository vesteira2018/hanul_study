<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Date date = new Date();	//날짜와 시간 정보를 제공해주는 클래스
SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP15</title>
</head>
<body>
	<%=date %><br />
	<%=sdf.format(date) %>
</body>
</html>