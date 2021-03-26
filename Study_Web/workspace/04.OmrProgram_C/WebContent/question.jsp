<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>questionJSP</title>
<style type="text/css">
* {
	text-align: center;
	font-size: 1.4rem;
	color: white;
}

#examName{
	width: 30px;
}

table {
	background-image: url('images/bg0.jpg');
	background-size: contain;
}

input[type="radio"]{
	width: 20px;
	height: 20px;
}

#personNum{
	border: 0px;
	color: black;
}

input[type="submit"],
input[type="reset"] {
	color: black;
}
</style>
<script type="text/javascript">
	function fnSubmit() {
		if(confirm("제출 하시겠습니까?")){
			return true;
		}
		return false;
	}
	
	function fnReset(){
		if(confirm("작성내용이 초기화됩니다.\n 초기화 하시겠습니까?")){
			return true;
		}
		return false;
	}
</script>
</head>
<body>
<form action="checkAnswer.jsp" method="get" id="myForm" name="myForm"
			onsubmit="return fnSubmit()" onreset="return fnReset()">
	<table border="1">
	<caption>[답안작성지]</caption>
		<tr>
			<td>응시자</td>
			<td colspan="5">
				<input type="number" id="personNum" name="personNum" placeholder="수험번호" />
			</td>
		</tr>
		<tr>
			<td rowspan="2">구분</td>
			<td rowspan="2">문제번호</td>
			<td colspan="4">답란</td>
		</tr>
		<tr>
			<td> 1</td>
			<td> 2</td>
			<td> 3</td>
			<td> 4</td>
		</tr>
		<tr id="examName">
			<td rowspan="11">&nbsp;&nbsp;모바일&nbsp;&nbsp;<br/>&nbsp;&nbsp;앱개발&nbsp;&nbsp;<br/>&nbsp;&nbsp;전문가&nbsp;&nbsp;</td>
		</tr>
		<% for (int i=1; i <= 10; i++){%>
			<tr>
				<td><%=i %></td>
			<% for (int j = 1; j <= 4; j++){ %>
				<td><input type="radio" name="num<%=i %>"  value="<%=j %>" required="required"/></td>
			<%} %>
			</tr>
		<%} %>	
		<tr>
			<td colspan="6">
				<input type="submit" value="답안제출" />
				<input type="reset" value="초기화" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>