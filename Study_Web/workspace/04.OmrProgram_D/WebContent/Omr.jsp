<%@page import="com.hanul.answer.AnswerDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//한글도 가져와야하기에 UTF-8로 인코딩 세팅
request.setCharacterEncoding("UTF-8");

//응시자 이름을 불러온다
String name = request.getParameter("name");

//입력한 답을 ArrayList<> myAnswer에 저장한다
ArrayList<Integer> myAnswer = new ArrayList<>();
for (int i = 1; i <= 10; i++) {
	//답을 입력하지 않은 경우 0으로 저장하고 그렇지 않으면 내가 입력한 답을 저장한다
	if (request.getParameter("check" + i) == null) {
		myAnswer.add(0);
	} else {
		myAnswer.add(Integer.parseInt(request.getParameter("check" + i)));
	}
}

//서버에 저장된 답을 AnswerDAO → answerList()로 불러서 
//ArrayList<> corrAnswer에 저장한다
AnswerDAO dao = new AnswerDAO();
ArrayList<Integer> corrAnswer = dao.answerList();
for(int i = 0; i < corrAnswer.size(); i++){
	out.println(corrAnswer.get(i));
}

//정답 체크를 하고 ArrayList<> checkAns에 O, X로 표시
//맞춘 문제 수를 corr에 저장한다
//문항별 부분 배점을 적용해 score에 저장한다
int corr = 0;
double score = 0;
ArrayList<String> checkAns = new ArrayList<>();
for (int i = 0; i < corrAnswer.size(); i++) {
	if (myAnswer.get(i) == corrAnswer.get(i)) {
		checkAns.add(i, "O");
		corr++;
		switch (i) {
			case 0: score += 6;
							break;
			case 1: score += 7.5;
							break;
			case 2: score += 10;
							break;
			case 3: score += 6.5;
							break;
			case 4: score += 11.5;
							break;
			case 5: score += 12.5;
							break;
			case 6: score += 9;
							break;
			case 7: score += 13.5;
							break;
			case 8: score += 9.5;
							break;
			case 9: score += 14;
							break;
		}
	} else {
		checkAns.add(i, "X");
	}//if
}//for

//name, myAnswer, answer, checkAns, corr, score를 Result.jsp로 보낼 준비
request.setAttribute("name", name);
request.setAttribute("myAnswer", myAnswer);
request.setAttribute("corrAnswer", corrAnswer);
request.setAttribute("checkAns", checkAns);
request.setAttribute("corr", corr);
request.setAttribute("score", score);

%>

<%-- Result.jsp로 name, myAnswer, answer, checkAns, corr, score를 보낸다 --%>
<jsp:forward page="Result.jsp" />


