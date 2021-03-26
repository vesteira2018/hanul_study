<%@page import="com.hanul.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%
request.setCharacterEncoding("UTF-8");
BoardDTO dto = (BoardDTO) request.getAttribute("dto");
pageContext.setAttribute("enter", "\r\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail JSP</title>
<script type="text/javascript">
function fnDelete(b_pwd) {
	var user_pwd = document.detailForm.user_pwd.value;
	//alert("User password : " + user_pwd + "\nDB password : " + b_pwd);
	if (user_pwd.trim() == "") {	//비밀번호 불입력
		alert("비밀번호를 입력하세요");
		document.detailForm.user_pwd.value = "";
		document.detailForm.user_pwd.focus();
	} else if (user_pwd != b_pwd) {	//비밀번호 불일치
		alert("비밀번호가 잘못 입력되었습니다!");
		document.detailForm.user_pwd.value = "";
		document.detailForm.user_pwd.focus();
	} else {	//비밀번호 일치
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href = "boardDelete.do?b_num=" + ${dto.b_num};
		} else {
			document.detailForm.user_pwd.value = "";
			document.detailForm.user_pwd.focus();
		}
	}
}//fnDelete()

function fnUpdate(b_pwd) {
	var user_pwd = document.detailForm.user_pwd.value;
	//alert("User password : " + user_pwd + "\nDB password : " + b_pwd);
	if (user_pwd.trim() == "") {	//비밀번호 불입력
		alert("비밀번호를 입력하세요");
		document.detailForm.user_pwd.value = "";
		document.detailForm.user_pwd.focus();
	} else if (user_pwd != b_pwd) {	//비밀번호 불일치
		alert("비밀번호가 잘못 입력되었습니다!");
		document.detailForm.user_pwd.value = "";
		document.detailForm.user_pwd.focus();
	} else {	//비밀번호 일치
		location.href = "boardUpdateForm.do?b_num=" + ${dto.b_num};
	}
}//fnUpdate
</script>
</head>
<body>
	<div align="center">
	<h3>[글 내용 상세보기]</h3>
	<table border="1" width="80%">
		<tr align="center">
			<th>작성자</th>
			<td><%=dto.getB_writer() %></td>
			<th>조회수</th>
			<td>${dto.b_readcount }</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td colspan="3">${dto.b_subject }</td>
		</tr>
		
		<tr>
			<th>내용</th>
<%-- 			<td colspan="3"><%=dto.getB_content().replace("\r\n", "<br />") %></td> --%>
			<td colspan="3">${fn:replace(dto.b_content, enter, "<br />") }</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td colspan="3">
				<form name="detailForm">
					<input type="password" name="user_pwd" />
					<input type="button" value="수정" onclick="fnUpdate('${dto.b_pwd}')"/>
					<input type="button" value="삭제" onclick="fnDelete('${dto.b_pwd}')"/>
					<input type="button" value="목록보기" onclick="location.href='boardList.do'" />
				</form>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>