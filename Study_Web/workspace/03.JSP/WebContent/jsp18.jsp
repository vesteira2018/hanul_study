<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//jsp17.jsp 넘겨준 바인딩 객체를 받는다
request.setCharacterEncoding("UTF-8");
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>

<%
//dto 객체를 jsp19.jsp로 넘기자
request.setAttribute("dto", dto);
%>

<jsp:forward page="jsp19.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP18</title>
</head>
<body>
○ 이름(JSP) : <%=dto.getName() %><br />
○ 이름(Action Tag) : [jsp:useBean]으로 생성된 객체에서만 사용 가능<br />
○ 이름(EL) : ${dto.name }<br />

</body>
</html>