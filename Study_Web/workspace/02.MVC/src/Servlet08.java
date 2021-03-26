import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.SumMachine;

@WebServlet("/s08.do")
public class Servlet08 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//1. 클라이언트 요청 : 매개변수를 가져온다
		request.setCharacterEncoding("UTF-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
				
		//2. 비지니스 로직 : 별도의 클래스에 작성 (SumMachine.java)
		SumMachine sm = new SumMachine();
		int sum = sm.getSum(num1, num2);
		
		//3. 프리젠테이션 로직 : 결과를 응답 ▶ Servlet09.java(s09.do)
		//sendRedirect() 방식 : 단순한 페이지 전환만 필요할 경우(연결할 객체가 없는 경우)
		//url이 변경된다
		//response.sendRedirect("s09.do");	//페이지 호출
		
		//sendRedirect() 방식으로 페이지 전환할 경우
		//전달할 매개변수가 있다 ▶ method="get"방식
		response.sendRedirect("s09.do?num1=" + num1 + "&num2=" + num2 + "&sum=" + sum);
		
	}//service()

}//class
