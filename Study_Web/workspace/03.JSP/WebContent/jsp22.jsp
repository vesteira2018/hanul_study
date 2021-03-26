<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//jsp21.jsp에서 넘겨준 바인딩 객체(sum)를 받는다.
//바인딩 객체는 Object type으로 넘어온다.
//Class type으로 받고 Casting 필수
request.setCharacterEncoding("UTF-8");
Integer sum = (Integer) request.getAttribute("sum");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP22</title>
</head>
<body>
○ 누적합(JSP) : <%=sum %><br />
○ 누적합(EL) : ${sum }<br />
</body>
</html>