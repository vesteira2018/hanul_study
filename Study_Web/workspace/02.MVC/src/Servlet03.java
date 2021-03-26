import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.MemberDAO;
import com.hanul.study.MemberDTO;

@WebServlet("/s03.do")	//Servlet URL Mapping 자동설정
public class Servlet03 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1. 클라이언트 요청을 받는다 : 폼의 매개변수를 가져온다
		request.setCharacterEncoding("UTF-8");	//인코딩 설정
//		String name = request.getParameter("name");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String addr = request.getParameter("addr");
//		String tel = request.getParameter("tel");
		
		MemberDTO dto = new MemberDTO();
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setAddr(request.getParameter("addr"));
		dto.setTel(request.getParameter("tel"));
		
		//2. 비지니스 로직 : DataBase 연동(DTO, VO, DAO)
		MemberDAO dao = new MemberDAO();
		int succ = dao.memberInsert(dto);
		
		//3. 프리젠테이션 로직 : 결과를 응답(*.html, *.jsp)
		response.setContentType("text/html; charset=UTF-8");	//MIME Type
		PrintWriter out = response.getWriter();	//응답할 준비 완료
		if (succ > 0) {
			out.println("<script>alert('회원가입 성공!');</script>");
			out.println("<a href='MemberMain.html'>회원가입화면</a>");
			out.println("<br /><br />");
			out.println("<a href='s04.do'>목록보기</a>");
		} else {
			out.println("<script>alert('회원가입 실패!');</script>");
			out.println("<a href='MemberMain.html'>회원가입화면</a>");
			out.println("<br /><br />");
			out.println("<a href='s04.do'>목록보기</a>");
		}//if
		
	}//service()

}//class
