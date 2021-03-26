<%@ page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
MVC Project 학습했던 Servlet 코드 (Servlet03.java) : 순수자바코드(POJO)
 request.setCharacterEncoding("UTF-8");	//인코딩 설정
1.
String name = request.getParameter("name");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
int age = Integer.parseInt(request.getParameter("age"));
String addr = request.getParameter("addr");
String tel = request.getParameter("tel");
MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);

2.
MemberDTO dto = new MemberDTO();
dto.setName(request.getParameter("name"));
dto.setId(request.getParameter("id"));
dto.setPw(request.getParameter("pw"));
dto.setAge(Integer.parseInt(request.getParameter("age")));
dto.setAddr(request.getParameter("addr"));
dto.setTel(request.getParameter("tel"));

MemberDAO dao = new MemberDAO();
dao.memberInsert(dto);
--%>

<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<%-- <jsp:setProperty property="name" name="dto" /> --%>
	<jsp:setProperty property="*" name="dto" />
</jsp:useBean> <!-- = MemberDTO dto = new MemberDTO(); -->

<jsp:useBean id="dao" class="com.hanul.study.MemberDAO" /> <!-- = MemberDAO dao = new MemberDAO(); -->

<%
int succ = dao.memberInsert(dto);

if (succ > 0) { 
	out.println("<script>alert('회원가입 성공!');");
	out.println("location.href='jsp05Main.html';</script>");
} else {
	out.println("<script>alert('회원가입 실패!');");
	out.println("location.href='jsp05Main.html';</script>");
}//if
%>