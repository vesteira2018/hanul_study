<%@page import="com.board.study.BoardDTO"%>
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
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h3>[게시글 수정]</h3>
	<form action="boardModifyAction.bo" method="post">
		<input type="hidden" name="board_num" value="${dto.board_num }" />
		<table border="1">
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="board_subject" 
						value="${dto.board_subject }" maxlength="50" />
				</td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="15" cols="50" name="board_content">${dto.board_content }</textarea>
				</td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="수정하기" />
					<input type="reset" value="초기화하기" />
					<input type="button" value="목록보기" onclick="location.href='boardList.bo'" /> 
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>