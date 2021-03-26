<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pw");

//id 존재 유무, pwd 일치성 ▶ DAO를 통해 DB와 연동해서 이상이 없으면
session.setAttribute("id", id);	//session 바인딩(연결) 객체를 생성
session.setMaxInactiveInterval(60);	//session 유지시간(초 단위)

//Cookie(쿠키) 설정 : 사용자쪽(Client)에 쿠키를 넣어준다.
Cookie ck = new Cookie("id", id);
ck.setMaxAge(600);	//쿠키의 유효시간 : 10분
response.addCookie(ck);

response.sendRedirect("LoginMain.jsp");
%>
