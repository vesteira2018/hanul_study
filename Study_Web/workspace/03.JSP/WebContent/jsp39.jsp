<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP39</title>
</head>
<body>
<c:set var="num" value="123456789"/>
<h3>숫자포맷 : ${num}</h3>
○ 형식1 : <fmt:formatNumber value="${num}" groupingUsed="true"/><br/>
○ 형식2 : <fmt:formatNumber value="${num}" groupingUsed="false"/><br/>
○ 형식3 : <fmt:formatNumber value="${num}" pattern="#,##0" /><br/>
○ 형식4 : <fmt:formatNumber value="${num}" pattern="#,##0개" /><br/>

<h3>기타포맷 : 통화기호, 백분율</h3>
○ 금액1 : <fmt:formatNumber value="${num}" type="currency" /><br/>
○ 금액2 : <fmt:formatNumber value="${num}" type="currency" currencySymbol="￦"/><br/>
○ 금액3 : <fmt:formatNumber value="${num}" pattern="￦#,##0원"/><br/>
○ 백분율1 : <fmt:formatNumber value="0.123" type="percent"/><br/>
○ 백분율2 : <fmt:formatNumber value="0.123" pattern="0.00%"/>
</body>
</html>
