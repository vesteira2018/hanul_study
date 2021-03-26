<%@page import="com.board.study.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.study.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%
request.setCharacterEncoding("UTF-8");
String id = (String)session.getAttribute("id");
MemberDAO dao = new MemberDAO();
String member_pw = dao.getMember_pw(id);

Integer nowPage = (Integer)request.getAttribute("page");
Integer maxPage = (Integer)request.getAttribute("maxPage");
Integer startPage = (Integer)request.getAttribute("startPage");
Integer endPage = (Integer)request.getAttribute("endPage");
Integer listCount = (Integer)request.getAttribute("listCount");
ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");

pageContext.setAttribute("nowPage", nowPage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
<script>
function fnModify(id, member_pw) {
	//alert("id : " + id + ", pw : " + member_pw);
	var pw = prompt("비밀번호를 입력하세요", "");
	//alert("pw : " + pw);
	
	if (member_pw == pw) {
		location.href = "memberDetailAction.me?member_id=" + id;
	} else {
		alert("비밀번호가 일치하지 않습니다");
	}
}
</script>
</head>
<body>
	<div align="center">
		<h3>[자유게시판]</h3>
		<table border="1">
			<tr>
				<th>번호</th>
				<th width="200">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<!-- 글목록 표시 -->
			<%
			if (list.size() == 0) {
				out.println("<tr><td colspan='5' align='center'>");
				out.println("작성된 글이 없습니다.</td></tr>");
			}
			
			for (int i = 0; i < list.size(); i++) {
				BoardDTO dto = list.get(i);
				pageContext.setAttribute("dto", dto);	
			%>
			<tr align="center">
				<td><%=dto.getBoard_num() %></td>
				<td align="left">
					<c:if test="${dto.board_re_lev ne 0 }">
						<c:forEach var="j" begin="1" end="${(dto.board_re_lev - 1) * 2 }">&nbsp;</c:forEach>
						└ RE: 
					</c:if>
					<a href="boardDetailAction.bo?board_num=<%=dto.getBoard_num() %>">
					<%=dto.getBoard_subject() %></a>
				</td>
				<td><%=dto.getBoard_id() %></td>
				<td><%=dto.getBoard_date() %></td>
				<td><%=dto.getBoard_readcount() %></td>
			</tr>
						
			<%} %>
			
			<!-- 페이징 처리 -->
			<tr align="center">
				<td colspan="5">
<%-- 					<% if (nowPage != startPage) { %>
						<a href="boardList.bo?page=<%=startPage %>">[첫 페이지]</a>&nbsp;
					<% } %>
					
					<% if (nowPage <= 1) { %>
						[이전]&nbsp;
					<% } else { %>
						<a href="boardList.bo?page=<%=nowPage - 1 %>">[이전]</a>&nbsp;
					<% } %>
					
					<% for (int i = startPage; i <= endPage; i++) { %>
						<% if (i == nowPage) { %>
							[<%=i %>]&nbsp;
						<% } else { %>
							<a href="boardList.bo?page=<%=i %>">[<%=i %>]</a>&nbsp;
						<% } %>
					<% } %>
					
					<% if (nowPage >= maxPage) { %>
						[다음]
					<% } else { %>
						<a href="boardList.bo?page=<%=nowPage + 1 %>">[다음]</a>
					<% } %>
					
					<% if (nowPage != endPage) { %>
						<a href="boardList.bo?page=<%=endPage %>">[마지막 페이지]</a>&nbsp;
					<% } %> --%>
					
					<c:if test="${nowPage ne startPage }">
						<a href="boardList.bo?page=${startPage}">[첫 페이지]</a>&nbsp;
					</c:if>
				
					<c:if test="${nowPage le 1} ">
						[이전]&nbsp;
					</c:if>
					<c:if test="${!(nowPage le 1) }">
						<a href="boardList.bo?page=${nowPage - 1}">[이전]</a>&nbsp;
					</c:if>
					
					<c:if test="${maxPage gt 5 }">
						...&nbsp;
						<c:forEach var="i" begin="${nowPage - 2 }" end="${nowPage + 2 }" step="1">
							<c:if test="${i eq nowPage }">[${i }]&nbsp;</c:if>
							<c:if test="${i ne nowPage }">
								<a href="boardList.bo?page=${i }">[${i }]</a>&nbsp;
							</c:if>
						</c:forEach>
						&nbsp;...
					</c:if>
					<c:if test="${maxPage le 5 }">
						<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
							<c:if test="${i eq nowPage }">[${i }]&nbsp;</c:if>
							<c:if test="${i ne nowPage }">
								<a href="boardList.bo?page=${i }">[${i }]</a>&nbsp;
							</c:if>
						</c:forEach>
					</c:if>
					
					<c:if test="${nowPage ge maxPage }">
						[다음]&nbsp;
					</c:if>
					<c:if test="${!(nowPage ge maxPage) }">
						<a href="boardList.bo?page=${nowPage + 1}">[다음]</a>&nbsp;
					</c:if>
					
					<c:if test="${nowPage ne endPage }">
						<a href="boardList.bo?page=${endPage}">[마지막 페이지]</a>&nbsp;
					</c:if>
				</td>
			</tr>
			
			
			<tr align="center">
				<td colspan="5">
					<%if (id != null && id.equals("admin")) {%>
						<input type="button" value="회원관리"
							onclick="location.href='memberListAction.me'" />
					<%} %>
					<input type="button" value="로그아웃" 
						onclick="location.href='memberLogout.me'" />
					<input type="button" value="글쓰기" 
						onclick="location.href='boardWrite.bo'" />
					<input type="button" value="회원정보수정" onclick="fnModify('<%=id %>', '<%=member_pw %>')" />
				</td>
			</tr>
			
			<!-- 조건검색 -->
			<tr align="center">
				<td colspan="5">
					<form action="boardSearch.bo" method="post">
						<select name="part">
							<option value="board_subject">제목</option>
							<option value="board_content">내용</option>
							<option value="board_id">작성자</option>
						</select>
						<input type="text" name="searchData" required="required" />
						<input type="submit" value="검색하기" />
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>