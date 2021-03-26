<%@page import="com.hanul.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
BoardDTO dto = (BoardDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardUpdateForm</title>
<style type="text/css">
.in {
	background-color: pink;
}
</style>
<script type="text/javascript">
function fnSubmit() {
	if (confirm("정말 수정하시겠습니까?")) {
		return true;
	}
	return false;
}

function fnReset() {
	if (confirm("수정된 내용이 초기화됩니다.\n초기화하시겠습니까?")) {
		return true;
	}
	return false;
}
</script>
</head>
<body>
	<div align="center">
	<h3>[게시판 글 수정하기]</h3>
	<form action="boardUpdate.do" method="post"
				onsubmit="return fnSubmit()" onreset="return fnReset()">
	<input type="hidden" name="b_num" value="${dto.b_num }" />
		<table border="1" width="80%">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="b_writer" value="${dto.b_writer }" 
				required="required" class="in" maxlength="20"/></td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td><input type="text" name="b_subject" value="${dto.b_subject }" 
				required="required" class="in" maxlength="50"/></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50" name="b_content" 
				required="required" maxlength="2000" class="in">${dto.b_content }</textarea></td>
			</tr>
			
			<tr>
				<th>수정할<br />비밀번호</th>
				<td>
					<input type="password" name="b_pwd" value="${dto.b_pwd }"
					required="required" maxlength="20" class="in"/>
					<input type="submit" value="수정하기" />
					<input type="reset" value="초기화하기" />
					<input type="button" value="목록보기" onclick="location.href='boardList.do'" />
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>