import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.ResultDTO;

@WebServlet("/s07.do")
public class Servlet07 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//Servlet06.java(s06.do)에서 넘겨준 바인딩(연결) 객체를 받는다.
		//바인딩 객체를 반드시 클래스 타입으로 설정하고 casting 해야한다.
		Integer num1 = (Integer) request.getAttribute("num1");
		Integer num2 = (Integer) request.getAttribute("num2");
		Integer sum = (Integer) request.getAttribute("sum");
		ResultDTO dto = (ResultDTO) request.getAttribute("dto");
		
		//결과를 출력 : html, *.jsp
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<h3>request.forward()</h3>");
		out.println("첫 번째 정수 : " + num1 + "<br />");
		out.println("두 번째 정수 : " + num2 + "<br />");
		out.println("두 수 사이의 누적합 : " + sum + "<br />");
		out.println("<h3>request.forward()</h3>");
		out.println("첫 번째 정수 : " + dto.getNum1() + "<br />");
		out.println("두 번째 정수 : " + dto.getNum2() + "<br />");
		out.println("두 수 사이의 누적합 : " + dto.getSum() + "<br />");
		out.println("</body>");
		
	}//service()

}//class
