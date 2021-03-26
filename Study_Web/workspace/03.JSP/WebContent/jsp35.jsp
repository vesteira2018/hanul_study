<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String[] fruit = {"멜론", "사과", "바나나", "오렌지", "파인애플"};

//현재페이지에서만 사용할 바인딩 객체 생성 : EL문법(표현식)에서 사용
pageContext.setAttribute("fruit", fruit);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP35</title>
</head>
<body>
○ JAVA 반복문(배열 : for)<br/>
<ul>
<%
for(int i = 0; i < fruit.length; i++){
	out.println("<li>" + fruit[i] + "</li>");
}
%>
</ul>
<br/>

○ JAVA 반복문(배열 : 향상된 for문)<br/>
<ul>
<%
for(String str : fruit){
	out.println("<li>" + str + "</li>");
}
%>
</ul>
<br/>

<%--
○ JSTL core 반복문(배열) : <c:forEach>실행문</c:forEach>
	▶ <c:forEach var="반복변수명" items="${배열명}">
--%>
○ JSTL 반복문(배열)<br/>
<ul>
	<c:forEach var="i" items="${fruit }">
		<li>${i}</li>
	</c:forEach>
</ul>
</body>
</html>
