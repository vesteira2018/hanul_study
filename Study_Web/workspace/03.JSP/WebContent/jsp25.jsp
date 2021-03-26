<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// int num1 = Integer.parseInt(request.getParameter("num1"));
// int num2 = Integer.parseInt(request.getParameter("num2"));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP25</title>
</head>
<body>
<!-- jsp25.jsp?num1=20&num2=10 -->
<%-- num1의 값(JSP) : <%=num1 %><br /> --%>
<%-- num2의 값(JSP) : <%=num2 %><br /> --%>
num1의 값(EL) : ${param.num1 }<br />
num2의 값(EL) : ${param.num2 }<br />
<br />
num1 + num2 : ${param.num1 }+${param.num2 }<br />
num1 + num2 : ${param.num1 + param.num2 }<br />
num1 - num2 : ${param.num1 - param.num2 }<br />
num1 * num2 : ${param.num1 * param.num2 }<br />
num1 / num2 : ${param.num1 / param.num2 }<br />
num1 % num2 : ${param.num1 % param.num2 }<br />
<br />
num1이 더 큰가요? ${param.num1 - param.num2 > 0}<br />
num1이 더 큰가요? ${param.num1 - param.num2 gt 0}<br />
num1이 더 큰가요? ${param.num1 > param.num2}<br />
num1이 더 큰가요? ${param.num1 gt param.num2}<br />
num1과 num2가 같나요? ${param.num1 == param.num2 ? "예" : "아니오" }<br />
num1과 num2가 같나요? ${param.num1 eq param.num2 ? "예" : "아니오" }<br />

<pre>
★ 주의! : 매개변수로 전달된 값(num1, num2)을 EL 비교연산자로만 사용할 경우에는,
매개변수값을 문자열로 인식하여 자릿수가 다를 경우 잘못된 결과가 나올 수 있다.
전달받은 매개변수를 JSTL문법(c:set)으로 변수값을 초기화하거나
상수값으로 변환하여 비교연산을 사용한다.
</pre>


<!-- 
> : gt
>= : ge
< : lt
<= : le
== : eq
!= : ne
-->

</body>
</html>