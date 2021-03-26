<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));

out.println("num1 : " + num1 + "<br/>");
out.println("num2 : " + num2 + "<br/>");

if(num1 > num2){
	out.println("최대값 : " + num1 + "<br/>");
}

if(num1 < num2){
	out.println("최대값 : " + num2 + "<br/>");
}

if(num1 > num2){
	out.println("최소값 : " + num2 + "<br/>");
}

if(num1 < num2){
	out.println("최소값 : " + num1 + "<br/>");
}
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP32</title>
</head>
<body>
<!-- jsp32.jsp?num1=100&num2=50  -->
첫 번째 수(EL) : ${param.num1 }<br/>
두 번째 수(EL) : ${param.num2 }<br/>
<br/>

<%--
	<c:if test="조건식">실행문</c:if>
--%>

최대값 : 
<c:if test="${param.num1 - param.num2 > 0}">${param.num1}</c:if>
<c:if test="${param.num1 - param.num2 < 0}">${param.num2}</c:if>
<br/>

최소값 : 
<c:if test="${param.num1 - param.num2 > 0}">${param.num2}</c:if>
<c:if test="${param.num1 - param.num2 < 0}">${param.num1}</c:if>

</body>
</html>
