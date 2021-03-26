import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/s01.do")
public class Servlet01 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1. 클라이언트의 요청을 받는다 ▶ HttpServletRequest
		//Form에서 입력한 매개변수 값을 가져온다 : getParameter();
		request.setCharacterEncoding("UTF-8");	//인코딩 설정
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		//2. 비즈니스 로직(num1 ~ num2 누적합 계산) ▶ 보통 별도의 Model(Class)를 생성한다
		int sum = 0;
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		
		//3. 프리젠테이션 로직 ▶ HttpServletResponse
		//결과를 html코드로 응답 : *.jsp ▶ View
		response.setContentType("text/html; charset=UTF-8");	//MIME Type
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("첫 번째 수 : " + num1 + "<br />");
		out.println("두 번째 수 : " + num2 + "<br />");
		out.println("두 수 사이의 누적합 : " + sum);
		out.println("</body>");
		
	}

}
