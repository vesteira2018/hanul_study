<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<String> list = new ArrayList<>();
list.add("멜론");
list.add("사과");
list.add("바나나");
list.add("오렌지");
list.add("파인애플");

//현재페이지에서만 사용할 바인딩 객체 생성 : EL문법(표현식)에서 사용
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP36</title>
</head>
<body>
○ JAVA for<br/>
<ul>
<%
for(int i = 0; i < list.size(); i++){
	out.println("<li>" + list.get(i) + "</li>");
}
%>

</ul>
<br/>

○ JAVA 향상된 for<br/>
<ul>
<%
for(String fruit : list){
	out.println("<li>" + fruit + "</li>");
}
%>
</ul>
<br/>

○ EL문법(표기법)<br/>
<ul>
	<li>${list[0]}</li>
	<li>${list[1]}</li>
	<li>${list[2]}</li>
	<li>${list[3]}</li>
	<li>${list[4]}</li>
</ul>
<br/>

○ JSTL core<br/>
<ul>
	<c:forEach var="fruit" items="${list}">
		<li>${fruit}</li>
	</c:forEach>
</ul>
</body>
</html>
