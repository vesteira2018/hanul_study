package com.hanul.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.BoardDAO;
import com.hanul.dto.BoardDTO;

public class BoardInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 클라이언트의 요청을 받는다 : 매개변수 정보를 가져온다
		//▶ DTO로 묶어준다
		request.setCharacterEncoding("UTF-8");
		String b_writer = request.getParameter("b_writer");
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");
		String b_pwd = request.getParameter("b_pwd");
		
		/*BoardDTO dto = new BoardDTO();
		dto.setB_writer(b_writer);
		dto.setB_subject(b_subject);
		dto.setB_content(b_content);
		dto.setB_pwd(b_pwd);*/
		BoardDTO dto = new BoardDTO(b_writer, b_subject, b_content, b_pwd);
		
		//2. 비즈니스 로직 : DAO연동(DB접속, 쿼리 수행)
		BoardDAO dao = new BoardDAO();
		int succ = dao.boardInsert(dto);
		
		//3. 프리젠테이션 로직 : alert 창을 사용 ▶ PrintWriter	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (succ > 0) {
			out.println("<script>alert('등록완료!');");
			out.println("location.href='boardList.do';</script>");
		} else {
			out.println("<script>alert('등록실패!');");
			out.println("location.href='boardList.do';</script>");
		}
		
		return null;	//ActionForward가 필요하지 않는다.
	}
	
}
