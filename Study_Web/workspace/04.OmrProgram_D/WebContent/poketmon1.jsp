<%@page import="java.util.Arrays"%>
<%@page import="com.hanul.poketmon.PoketmonDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
DB : 
<%
//DB에 저장되어 있는 답을 dblist로 불러오기
	PoketmonDAO dao = new PoketmonDAO();
	ArrayList<String> dblist = dao.getAnswer();
	for(int i = 0; i < dblist.size(); i++){
		out.println(dblist.get(i));
	}
%>	

<br/>
<br/>
사용자 입력 : 
<%
//내가 입력한 답을 anslist 에 저장
	ArrayList<String> anslist = new ArrayList<>();
	for(int i = 1; i <=10; i++){
		anslist.add( request.getParameter("ans" + i) ); 
		out.println(anslist.get(i-1));
	}
%>
<br/><br/>

<%
//정답 확인(OX) 아닌지 확인, 맞은 갯수 cnt 체크
int cnt = 0;
ArrayList<String> oxlist = new ArrayList<>();
for(int i = 0; i < dblist.size(); i++){
	if(anslist.get(i).equals(dblist.get(i)) ){
		oxlist.add(i, "O");
		out.print("O  ");
		cnt++;
	}
	if(!anslist.get(i).equals(dblist.get(i)) ){
		oxlist.add(i, "X");
		out.print("X  ");
	}
}
request.setAttribute("oxlist", oxlist);
request.setAttribute("dblist", dblist);
request.setAttribute("anslist", anslist);
request.setAttribute("cnt", cnt);
%>

<jsp:forward page="poketmon2.jsp" />








