<%@page import="com.hanul.study.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="dto" />
</jsp:useBean>

<%
MemberDAO dao = new MemberDAO();
int succ = dao.memberUpdate(dto);

if (succ > 0) {
	out.println("<script>alert('수정완료!');");
	out.println("location.href='list.jsp';</script>");
} else {
	out.println("<script>alert('수정실패!');");
	out.println("location.href='list.jsp';</script>");
}

%>
