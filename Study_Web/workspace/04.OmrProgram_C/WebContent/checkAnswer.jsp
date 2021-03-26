<%@page import="com.hanul.study.AnswerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.AnswerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Integer personNum = Integer.parseInt(request.getParameter("personNum"));

//내가 찍은 답을 ArrayList<Integer> questionList로 저장
ArrayList<Integer> questionList = new ArrayList<>();
for(int i = 1; i <= 10; i++){
	questionList.add(Integer.parseInt(request.getParameter("num" + i)));
}

out.println("나의 답");
out.println("<br/>");
//ArrayList<Integer> questionList값 확인
for(int i = 0; i < questionList.size(); i++){
	out.println(questionList.get(i));
}

out.println("<br/>");
out.println("<br/>");
out.println("서버용 답");
out.println("<br/>");

//서버에 저장된 답을 가져온다 answerList
AnswerDAO dao = new AnswerDAO();
ArrayList<Integer> answerList = dao.getAnswer();
for(int i = 0; i < answerList.size(); i++){
	out.println(answerList.get(i));
}

out.println("<br/>");
out.println("<br/>");
out.println("정답 확인");
out.println("<br/>");

//정답 확인(OX) 아닌지 확인, 맞은 갯수 cnt 체크
int cnt = 0;
ArrayList<String> oxList = new ArrayList<>();
for(int i = 0; i < answerList.size(); i++){
	if(questionList.get(i) == answerList.get(i)){
		oxList.add(i, "O");
		out.print("O  ");
		cnt++;
	}
	if(questionList.get(i) != answerList.get(i)){
		oxList.add(i, "X");
		out.print("X  ");
	}
}
request.setAttribute("personNum", personNum);
request.setAttribute("oxList", oxList);
request.setAttribute("answerList", answerList);
request.setAttribute("questionList", questionList);
request.setAttribute("cnt", cnt);
%>

<jsp:forward page="result.jsp" />