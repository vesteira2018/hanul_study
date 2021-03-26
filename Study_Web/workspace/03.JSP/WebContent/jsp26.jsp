<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP26</title>
</head>
<body>
<!-- jsp26.jsp?str1=korea&str2=kor -->
<%
//POJO(순수자바코드) : Servlet 방식
String str1 = request.getParameter("str1");
String str2 = request.getParameter("str2");
out.println("입력문자열 str1 : " + str1 + "<br />");
out.println("입력문자열 str2 : " + str2 + "<br />");
out.println("두 문자열이 같나요? " + (str1.equals(str2) ? "예" : "아니오"));
%>
<br /><br />

<%-- JSP : 표현식 --%>
입력문자열 str1 : <%=str1 %><br />
입력문자열 str2 : <%=str2 %><br />
두 문자열이 같나요? : <%=str1.equals(str2) ? "예" : "아니오" %>
<br /><br />

입력문자열 str1 : ${param.str1 }<br />
입력문자열 str2 : ${param.str2 }<br />
두 문자열이 같나요? : ${param.str1 == param.str2 ? "예" : "아니오"}<br />
두 문자열이 같나요? : ${param.str1 eq param.str2 ? "예" : "아니오"}<br />
</body>
</html>