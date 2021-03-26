<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
ArrayList<Integer> myAnswer = (ArrayList<Integer>) request.getAttribute("myAnswer");
Double score = (Double) request.getAttribute("score");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULT JSP</title>

<style type="text/css">
		@import url("SubFiles/css/Result.css");
</style>

</head>
<body>
	<div align="center">
		<table>
			<caption>[&nbsp;&nbsp;R&nbsp;&nbsp;E&nbsp;&nbsp;S&nbsp;&nbsp;U&nbsp;&nbsp;L&nbsp;&nbsp;T&nbsp;&nbsp;]</caption>
			
			<tr>
				<th colspan="5">응&nbsp;&nbsp;시&nbsp;&nbsp;자</th>
				<td colspan="6">${name }</td>
			</tr>
			
			<tr>
				<th>문&nbsp;&nbsp;제&nbsp;&nbsp;번&nbsp;&nbsp;호</th>
				<c:forEach var="i" begin="1" end="10">
					<td><c:out value="${i }" /></td>
				</c:forEach>
			</tr>
			
			<tr>
				<th>나&nbsp;&nbsp;의&nbsp;&nbsp;답&nbsp;&nbsp;안</th>
				<%for (int i = 0; i < myAnswer.size(); i++) {
					//답을 입력하지 않았을 경우 공백으로 출력
					if (myAnswer.get(i) == 0) {
						out.println("<td> </td>");						
					} else {
					//답을 입력했을 경우 나의 답안을 출력
						out.println("<td>" + myAnswer.get(i) + "</td>");
					}
				}	%>
			</tr>
			
			<tr>
				<th>정&nbsp;&nbsp;답</th>
				<c:forEach var="i" begin="0" end="9">
					<td><c:out value="${corrAnswer[i] }" /></td>
				</c:forEach>
			</tr>
			
			<tr>
				<th>O&nbsp;&nbsp;/&nbsp;&nbsp;X</th>
				<c:forEach var="i" begin="0" end="9">
					<td><c:out value="${checkAns[i] }" /></td>
				</c:forEach>
			</tr>
			
			<tr align="center">
				<th colspan="11">${corr }문제를 맞추었습니다. ${name }님의 점수는 ${score }점입니다.</th>
			</tr>
			
			<tr align="center">
				<% if (score >= 60) { %>
					<th colspan="11">
						합격입니다. 축하합니다.
					</th>
				<%} else { %>
					<th colspan="11">
						불합격입니다.
					</th>
				<%} %>
			</tr>
			
			<tr>
				<td colspan="11">
					<Input type="button" onclick="location.href='OMR_Main.html'" value="되돌아가기" />
					<Input type="button" onclick="location.href='TestMain.html'" value="메인페이지로" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>