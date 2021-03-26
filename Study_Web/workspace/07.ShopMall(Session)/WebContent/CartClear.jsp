<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.removeAttribute("cart");	//1. 세션 객체에서 cart 속성값 제거
session.invalidate();	//2. 모든 세션 객체의 속성을 제거

response.sendRedirect("ShopMallMain.jsp");
%>