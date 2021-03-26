<%@page import="com.hanul.study.AnswerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
ArrayList<Integer> questionList = (ArrayList<Integer>) request.getAttribute("questionList");
ArrayList<Integer> answerList = (ArrayList<Integer>) request.getAttribute("answerList");
ArrayList<String> oxList = (ArrayList<String>) request.getAttribute("oxList");
Integer cnt = (Integer) request.getAttribute("cnt");
Integer personNum = (Integer) request.getAttribute("personNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resultJSP</title>
<style type="text/css">
*{
	font-size: 1.4rem;
	text-align: center;
	padding: 5px;
}

.cong{
	background-image: url('images/bg1.jpg');
	height: 50px;
	color: white;
}

.def{
	background-image: url('images/bg1.jpg');
	height: 50px;
	color: red;
}
</style>
</head>
<body>
<table border="1">
	<tr align="center">
		<td colspan="6">결과항목</td>		
		<td colspan="5">수험번호&nbsp;:&nbsp;<%=personNum %></td>		
	</tr>
	<tr>
		<td>&nbsp;문제&nbsp;번호&nbsp;</td>
		<%for (int i=1; i <= 10; i++){ %>
			<td>&nbsp;&nbsp;<%=i %>&nbsp;&nbsp;</td>
		<%} %>
	</tr>
	<tr>
		<td>&nbsp;정&nbsp;&nbsp;답&nbsp;</td>
		<%for (int i=0; i < answerList.size(); i++){ %>
			<td>
				<%out.println(answerList.get(i));%>
			</td>
		<%} %>
	</tr>
	<tr>
		<td>&nbsp;제출한&nbsp;답&nbsp;</td>
		<%for (int i = 0; i < questionList.size(); i++){ %>
			<td><%out.println(questionList.get(i)); %></td>
		<%} %>
	</tr>
	<tr>
		<td>&nbsp;O&nbsp;&nbsp;X&nbsp;</td>
		<%for (int i = 0; i < oxList.size(); i++){ %>
			<td><%out.println(oxList.get(i)); %></td>
		<%} %>
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
</table>
</body>
</html>