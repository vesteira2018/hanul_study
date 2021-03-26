<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%--
세션객체에 id 속성이 있으면, 해당값(id)을 가져와서 로그인 유지상태를 보여주고,
세션객체에 id 속성이 없으면, 로그인할 수 있는 화면을 보여준다.
--%>
<%
String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Left</title>
</head>
<body>
<%if (id != null) { //세션에 id값이 있다 : 로그인 상태 유지 %>
	<%=id %>님 방문을 환영합니다!<br />
	<a href="Logout.jsp">로그아웃</a>
<%} else { //세션에 id값이 없다 : 로그인하는 화면을 보여준다%>
	<form action="LoginProcess.jsp" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" required="required" /></td>
				<td rowspan="2"><input type="submit" value="로그인하기" /></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" required="required" /></td>
			</tr>
		</table>
	</form>
<%} %>
</body>
</html>