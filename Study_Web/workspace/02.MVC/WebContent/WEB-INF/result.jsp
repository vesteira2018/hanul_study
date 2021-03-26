<%@page import="com.hanul.study.ResultDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
ResultDTO dto = (ResultDTO) request.getAttribute("dto");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result JSP</title>
</head>
<body>
첫 번째 수 : <%=dto.getNum1() %> <br/>
두 번째 수 : <%=dto.getNum2() %> <br/>
두 수 사이의 누적합 : <%=dto.getSum()%>
</body>
</html>