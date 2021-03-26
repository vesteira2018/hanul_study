import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page.do")
public class PageServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1. 클라이언트의 요청을 받는다 : 매개변수를 가져온다
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//2. 비지니스 로직 : DB연동 → 별도에 클래스에 작성 (여기서는 생략)
		
		//3. 프리젠테이션 로직 : 결과를 응답 ▶  html, jsp
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("PageTurn.html에서 요청한 ID : " + id + "<br />");
		out.println("PageTurn.html에서 요청한 PW : " + pw + "<br />");
		out.println("</body>");
		
	}//service()

}//class
