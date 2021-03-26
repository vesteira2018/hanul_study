<%@page import="com.hanul.study.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
// String name = request.getParameter("name");
// String id = request.getParameter("id");
// String pw = request.getParameter("pw");
// int age = Integer.parseInt(request.getParameter("age"));
// String addr = request.getParameter("addr");
// String tel = request.getParameter("tel");
// MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);
%>

<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="dto" />
</jsp:useBean>

<%
MemberDAO dao = new MemberDAO();
int succ = dao.memberUpdate(dto);

if (succ > 0) {
	out.println("<script>alert('수정 성공!');");
	out.println("location.href='jsp06.jsp';</script>");
} else {
	out.println("<script>alert('수정 실패!');");
	out.println("location.href='jsp06.jsp';</script>");
}//if
%>