<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan01 JSP</title>
</head>
<body>
	<div align="center">
		<h3>[구구단 출력]</h3>
		<table border="1">
			<tr bgcolor="silver">
				<%for (int i = 2; i <= 9; i++) {%>
					<th><font color="red"><%=i %>단</font></th>
				<%} %>
			</tr>
			
			<%for (int i = 1; i <= 9; i++) { %>
			<%if (i % 2 == 0) { %>
			<tr align="center" bgcolor="lime">
			<%} else {%>
			<tr align="center" bgcolor="aqua">
			<%} %>
					<%for (int j = 2; j <= 9; j++) { %>
						<td><%if (i*j < 10) { %>
						<%=j + " × " + i + " = 0" + (i*j) %>
						<%} else { %>
						<%=j + " × " + i + " = " + (i*j) %>
						<%} %>
						</td>
					<%} %>
			</tr>
			<%} %>
		</table>
	</div>
</body>
</html>