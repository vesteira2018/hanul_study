<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP40</title>
</head>
<body>
<c:set var="str" value="   How   Are   You?   "/>
○ 원래문자열 : ${str}<br/>
○ 띄워쓰기 : How&nbsp;&nbsp;&nbsp;Are&nbsp;&nbsp;&nbsp;You?<br/>
○ 모두 대문자로 출력 : ${fn:toUpperCase(str) }<br />
○ 모두 대문자로 출력 : ${fn:toLowerCase(str) }<br />
○ 문자열의 길이 : ${fn:length(str) }<br />
○ 좌우 공백을 제거한 후 출력 : ${fn:trim(str) }<br />
○ 좌우 공백을 제거한 후 문자열의 길이 : ${fn:length(fn:trim(str)) }<br />
○ Are 문자의 위치 : ${fn:indexOf(str, "Are") }<br />
○ Are 문자를 Were로 변경 : ${fn:replace(str, "Are", "Were") }<br />
</body>
</html>