<%@page import="com.hanul.study.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
String[] studyJSP = (String[]) request.getAttribute("study");
ArrayList<String> listJSP = (ArrayList<String>) request.getAttribute("list");
MemberDTO dtoJSP = (MemberDTO) request.getAttribute("dto");
ArrayList<MemberDTO> mlistJSP = (ArrayList<MemberDTO>) request.getAttribute("mlist");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP28</title>
</head>
<body>
[배열을 받는 방법(JSP)]<br />
<%for (int i = 0; i <studyJSP.length; i++) { %>
	studyJSP[] 배열의 <%=i %> 번지(인덱스) 값 : <%=studyJSP[i] %><br />
<%} %>
<br />

[배열을 받는 방법(Servlet)]<br />
<%
for (int i = 0; i < studyJSP.length; i++) {
	out.println("studyJSP[] 배열의 " + i + "번지(인덱스) 값 : " + studyJSP[i] + "<br />");
}
%>
<br />

[배열을 받는 방법(EL)]<br />
studyJSP[] 배열의 0번지(인덱스) 값 : ${study[0] }<br />
studyJSP[] 배열의 1번지(인덱스) 값 : ${study[1] }<br />
studyJSP[] 배열의 2번지(인덱스) 값 : ${study[2] }<br />
studyJSP[] 배열의 3번지(인덱스) 값 : ${study[3] }<br />
studyJSP[] 배열의 4번지(인덱스) 값 : ${study[4] }<br />
studyJSP[] 배열의 5번지(인덱스) 값 : ${study[5] }<br />
studyJSP[] 배열의 6번지(인덱스) 값 : ${study[6] }<br />
studyJSP[] 배열의 7번지(인덱스) 값 : ${study[7] }<br />
<br />

[ArrayList를 받는 방법(JSP)])<br />
<%
for (int i = 0; i < listJSP.size(); i++) {
	out.println("ArrayList<> 배열의 " + i + "번지 값 : " + listJSP.get(i) + "<br />");
}
%>
<br />

[ArrayList를 받는 방법(EL)]<br />
ArrayList&lt&gt 배열의 0번지 값 : ${list[0] }<br />
ArrayList&lt&gt 배열의 1번지 값 : ${list[1] }<br />
ArrayList&lt&gt 배열의 2번지 값 : ${list[2] }<br />
ArrayList&lt&gt 배열의 3번지 값 : ${list[3] }<br />
ArrayList&lt&gt 배열의 4번지 값 : ${list[4] }<br />
<br />

[바인딩객체(dto)를 받는 방법(JSP)]<br />
이름 : <%=dtoJSP.getName() %><br />
아이디 : <%=dtoJSP.getId() %><br />
비밀번호 : <%=dtoJSP.getPw() %><br />
나이 : <%=dtoJSP.getAge() %><br />
주소 : <%=dtoJSP.getAddr() %><br />
전화번호 : <%=dtoJSP.getTel() %><br />
<br />

[바인딩객체(dto)를 받는 방법(EL)]<br />
이름 : ${dto.name }<br />
아이디 : ${dto.id }<br />
비밀번호 : ${dto.pw }<br />
나이 : ${dto.age }<br />
주소 : ${dto.addr }<br />
전화번호 : ${dto.tel }<br />
<br />

[ArrayList&ltMemberDTO&gt 객체배열을 받는 방법(JSP)]<br />
<%
for (int i = 0; i < mlistJSP.size(); i++) {
	out.println("mlistJSP[" + i + "] 번지 값 : ");
  out.println(mlistJSP.get(i).getName() + ", ");
  out.println(mlistJSP.get(i).getId() + ", ");
  out.println(mlistJSP.get(i).getPw() + ", ");
  out.println(mlistJSP.get(i).getAge() + ", ");
  out.println(mlistJSP.get(i).getAddr() + ", ");
  out.println(mlistJSP.get(i).getTel() + "<br />");
}
%>
<br />

[ArrayList&ltMemberDTO&gt 객체배열을 받는 방법(EL)]<br />
mlist [0]번지 값 : ${mlist[0].name }, ${mlist[0].id }, ${mlist[0].pw }, 
${mlist[0].age }, ${mlist[0].addr }, ${mlist[0].tel }<br /> 
mlist [1]번지 값 : ${mlist[1].name }, ${mlist[1].id }, ${mlist[1].pw }, 
${mlist[1].age }, ${mlist[1].addr }, ${mlist[1].tel }<br /> 
mlist [2]번지 값 : ${mlist[2].name }, ${mlist[2].id }, ${mlist[2].pw }, 
${mlist[2].age }, ${mlist[2].addr }, ${mlist[2].tel }<br /> 
mlist [3]번지 값 : ${mlist[3].name }, ${mlist[3].id }, ${mlist[3].pw }, 
${mlist[3].age }, ${mlist[3].addr }, ${mlist[3].tel }<br /> 
mlist [4]번지 값 : ${mlist[4].name }, ${mlist[4].id }, ${mlist[4].pw }, 
${mlist[4].age }, ${mlist[4].addr }, ${mlist[4].tel }<br /> 



</body>
</html>