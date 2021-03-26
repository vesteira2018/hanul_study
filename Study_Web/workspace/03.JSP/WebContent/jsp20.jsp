<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
    
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
int age = Integer.parseInt(request.getParameter("age"));
String addr = request.getParameter("addr");
String tel = request.getParameter("tel");
MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);

dto.setName(request.getParameter("name"));
dto.setId(request.getParameter("id"));
dto.setPw(request.getParameter("pw"));
dto.setAge(Integer.parseInt(request.getParameter("age")));
dto.setAddr(request.getParameter("addr"));
dto.setTel(request.getParameter("tel"));
%> 

<jsp:useBean id="actionDTO" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="actionDTO"/>
</jsp:useBean>

<%
//현재페이지에서만 사용가능한 바인딩 객체 생성
//EL문법(표현식)에서 사용하기 위해
pageContext.setAttribute("dto", dto);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP20</title>
</head>
<body>
○ JSP 출력 <br />
이름 : <%=name %><br />
아이디 : <%=dto.getId() %><br />
주소 : <%=actionDTO.getAddr() %><br />
<br />

○ Action Tag 출력 : [jsp:useBean]으로 객체가 생성되어야 사용 가능<br />
이름 : <jsp:getProperty property="name" name="actionDTO"/><br />
아이디 : <jsp:getProperty property="id" name="actionDTO"/><br />
주소 : <jsp:getProperty property="addr" name="actionDTO"/><br />
<br />

○ EL 출력
이름 : ${param.name }(Parameter), ${dto.name }(DTO), ${actionDTO.name }(actionDTO)<br />
아이디 : ${param.id }(Parameter), ${dto.id }(DTO), ${actionDTO.id }(actionDTO)<br />
주소 : ${param.addr }(Parameter), ${dto.addr }(DTO), ${actionDTO.addr }(actionDTO)<br />

</body>
</html>