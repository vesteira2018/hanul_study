<%@page import="com.hanul.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setCharacterEncoding("UTF-8");
MemberDTO dto = (MemberDTO) request.getAttribute("dto");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result JSP</title>
</head>
<body>
	<div align="center">
		<h3>회원가입 처리결과</h3>
		<table border="1">
			<tr>
				<th>이름</th>
				<td><%= dto.getName() %></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><%= dto.getId() %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%= dto.getPw() %></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><%= dto.getAge() %></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><%= dto.getAddr() %></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="회원가입화면" onclick="location.href='index.html'"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>