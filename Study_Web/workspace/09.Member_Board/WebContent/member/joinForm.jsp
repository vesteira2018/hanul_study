<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Form</title>
</head>
<body>
	<div align="center">
		<h3>[회원가입]</h3>
		<form action="memberJoinAction.me" method="post">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="member_id" required="required" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="member_pw" required="required" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="member_name" required="required" /></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="member_age" required="required" /></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="member_gender" value="남" required="required" checked="checked"/>남자
						<input type="radio" name="member_gender" value="여" required="required" />여자
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="member_email" required="required" /></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="submit" value="회원가입" />
						<input type="reset" value="다시작성" />
						<input type="button" value="로그인" onclick="location.href='memberLogin.me'"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>