import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.MemberDAO;

@WebServlet("/s05.do")
public class Servlet05 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1. 클라이언트의 요청 : 매개변수를 가져온다
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		//2. 비지니스 로직 : 회원정보 삭제
		MemberDAO dao = new MemberDAO();
		int succ = dao.memberDelete(id);
		
		//3. 프리젠테이션 로직 : 결과 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (succ > 0) {
			out.println("<script>alert('삭제성공!');</script");
			out.println("<a href='MemberMain.html'>회원가입</a>");
			out.println("<br /><br />");
			out.println("<a href='s04.do'>회원목록보기</a>");
		} else {
			out.println("<script>alert('삭제실패!');</script");
			out.println("<a href='MemberMain.html'>회원가입</a>");
			out.println("<br /><br />");
			out.println("<a href='s04.do'>회원목록보기</a>");
		}//if
	}//service()

}//class
