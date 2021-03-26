<%@page import="com.hanul.study.SumMachine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
○ Servlet(Controller)의 역할 : MVC Project > Servlet01.java, Servlet02.java
	1. 클라이언트의 요청을 받는다. : HttpServletRequest
		- jsp03Main.html에서 전달한 매개변수(num1, num2)를 전달받는다.
	2. 비지니스 로직 : 별도의 클래스에 작성 후 결과를 리턴
		- SumMachine class의  getSum() 메소드를 호출하고 결과를 리턴
	3. 프리젠테이션 로직 : 결과를 출력(*.html, *.jsp)
		- jsp04.jsp 넘겨서 출력(동적페이지 전환) : forward()
--%>
<%
//1. 클라이언트의 요청을 받는다 : getParameter();
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));

//2. 비즈니스 로직 : 별도의 클래스에 작성 후 결과를 리턴
SumMachine sm = new SumMachine();
int sum = sm.getSum(num1, num2);

//3. 프리젠테이션 로직 : 결과를 출력 ▶ jsp04.jsp
request.setAttribute("num1", num1);	//바인딩 객체                        
request.setAttribute("num2", num2);
request.setAttribute("sum", sum);

RequestDispatcher rd = request.getRequestDispatcher("jsp04.jsp");
rd.forward(request, response);	//페이지 전환

%>