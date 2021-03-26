<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
ArrayList<String> dblist = (ArrayList<String>) request.getAttribute("dblist");
ArrayList<String> anslist = (ArrayList<String>) request.getAttribute("anslist");
ArrayList<String> oxlist = (ArrayList<String>) request.getAttribute("oxlist");
Integer cnt = (Integer) request.getAttribute("cnt");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 및 답안 확인</title>
<style type="text/css">
	@import url("SubFiles/css/poketmonResult.css");
</style>
</head>
<body>
<table border="1">
	<tr align="center">
		<td colspan="11">결과항목</td>		
	</tr>
	<tr>
		<td>&nbsp;문제&nbsp;번호&nbsp;</td>
		<%for (int i=1; i <= 10; i++){ 
			out.println("<td>" + i + "</td>");			
		} %>
	</tr>
	<tr>
		<td>정답</td>
		<%for (int i=0; i < dblist.size(); i++){ 
				out.println("<td>" + dblist.get(i) + "</td>");
		} %>
	</tr>
	<tr>
		<td>입력한 답</td>
		<%for (int i = 0; i < anslist.size(); i++){ 
			out.println("<td>" + anslist.get(i) + "</td>"); 
		} %>
	</tr>
	<tr>
		<td>O / X</td>
		<%for (int i = 0; i < oxlist.size(); i++){ 
			out.println("<td>" + oxlist.get(i) + "</td>"); 
		} %>
	</tr>
	<tr>
		<% if(cnt >= 6){ %>
		<td colspan="11" class="cong" >
				<%=cnt*10 %> 점입니다. 합격입니다. 
			<%}else { %>
		<td colspan="11" class="def" >
				<%=cnt*10 %> 점입니다. 불합격입니다. 
			<%} %>
		</td>
	</tr>
	<tr>
		<td colspan="11">
			<input type="button" value="다시풀기" onclick ="location.href='poketmonMain.html'" />
			<input type="button" value="메인페이지로" onclick ="location.href='TestMain.html'" />
		</td>
	</tr>
</table>
</body>
</html>