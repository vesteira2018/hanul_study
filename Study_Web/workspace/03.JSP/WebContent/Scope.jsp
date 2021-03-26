<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 
○ scope.jsp 페이지에서 바인딩(연결) 객체를 생성하여 scopeUse.jsp로 넘긴다
	- scope 내장객체를 이용하여 바인딩 객체를 생성
	- pageContext, request, session, application
	- 형식 : 내장객체.setAttribute()
	- name : 문자열(식별자),  value : 공유객체(값)
	- request.setAttribute("dto", dto);
--%>

<%
//바인딩(연결) 객체 생성 : setAttribute();
pageContext.setAttribute("pageContextName", "홍길동");
request.setAttribute("requestName", "JAVA");
session.setAttribute("sessionName", "Servlet/JSP");
application.setAttribute("applicationName", "Android");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope JSP</title>
</head>
<body>
<%
//바인딩(연결) 객체를 받자 : getAttribute(); ▶ Class Type, Casting
String pageContextName = (String) pageContext.getAttribute("pageContextName");
String requestName = (String) request.getAttribute("requestName");
String sessionName = (String) session.getAttribute("sessionName");
String applicationName = (String) application.getAttribute("applicationName");
%>

<ul>
	<li>pageContext : <%=pageContextName %></li>
	<li>request : <%=requestName %></li>
	<li>session : <%=sessionName %></li>
	<li>application : <%=applicationName %></li>
</ul>
<br />
<a href='scopeUse.jsp'>ScopeUse 페이지로 이동</a>
</body>
</html>





























