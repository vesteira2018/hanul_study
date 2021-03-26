<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form method="post" action="signupRequest">
		<table border="1">
			<tr>
				<th>성명</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><label><input type="radio" name="gender" value="남" checked="checked"/>남</label>
				<label><input type="radio" name="gender" value="여" />여</label></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="age" /></td>
			</tr>
		</table><br />
		<input type="submit" value="HttpServletRequest" />
		<input type="submit" value="@RequestParam" onclick="action='signupRequestParam'" />
		<input type="submit" value="데이터객체" onclick="action='signupDataObject'" />
		<input type="submit" value="@PathVariable" onclick="go_submit(this.form)'" />
	</form>
	
<script type="text/javascript">
function go_submit(f) {
	f.action = 'joinPath/' + f.name.value + '/' + 
		f.gender.value + '/' + 
		f.email.value + '/' + 
		f.age.value;

	
}
</script>
</body>
</html>