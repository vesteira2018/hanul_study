<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//jsp18.jsp 넘겨준 바인딩 객체를 받는다
request.setCharacterEncoding("UTF-8");
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>

<jsp:useBean id="actionDTO" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="actionDTO"/>
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP19</title>
</head>
<body>
○ 이름<br />
	- JSP : <%=dto.getName() %>, <%=actionDTO.getName() %><br />
	- Action Tag : <jsp:getProperty property="name" name="actionDTO"/><br />
	- EL : ${dto.name }, ${actionDTO.name }
</body>
</html>