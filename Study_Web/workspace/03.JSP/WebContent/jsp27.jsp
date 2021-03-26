<%@page import="com.hanul.study.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//study[] 배열을 초기화 → 바인딩 객체 → jsp28.jsp 출력
String[] study = {"JAVA", "View", "SQL", "Servlet/JSP", "Android", "SPRING", "IoT", "Project"};
request.setAttribute("study", study);

//ArrayList<> 배열을 초기화 → 바인딩 객체 → jsp28.jsp 출력
ArrayList<String> list = new ArrayList<>();
list.add("오렌지");
list.add("바나나");
list.add("사과");
list.add("감");
list.add("멜론");
request.setAttribute("list", list);

//MemberDTO 객체를 생성하고 초기화 → 바인딩 객체 → jsp28.jsp 출력
MemberDTO dto = new MemberDTO();
dto.setName("한울");
dto.setId("hanul");
dto.setPw("1234");
dto.setAge(30);
dto.setAddr("광주시 서구 농성동");
dto.setTel("062-362-7797");
request.setAttribute("dto", dto);

//ArrayList<MemberDTO> 객체배열 생성 → 바인딩 객체 → jsp28.jsp 출력
ArrayList<MemberDTO> mlist = new ArrayList<>();
mlist.add(new MemberDTO("홍길동", "hong1", "1234", 11, "광주시", "010-1234-1234"));
mlist.add(new MemberDTO("홍길동", "hong2", "1234", 22, "광주시", "010-1234-1234"));
mlist.add(new MemberDTO("홍길동", "hong3", "1234", 33, "광주시", "010-1234-1234"));
mlist.add(new MemberDTO("홍길동", "hong4", "1234", 44, "광주시", "010-1234-1234"));
mlist.add(new MemberDTO("홍길동", "hong5", "1234", 55, "광주시", "010-1234-1234"));
request.setAttribute("mlist", mlist);

//RequestDispatcher rd = request.getRequestDispatcher("jsp28.jsp");
//rd.forward(request, response);

%>

<jsp:forward page="jsp28.jsp" />