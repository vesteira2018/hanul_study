package com.hanul.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.BoardDAO;
import com.hanul.dto.BoardDTO;

public class BoardUpdateAction implements Action {
 @Override
public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	 request.setCharacterEncoding("UTF-8");
	 int b_num = Integer.parseInt(request.getParameter("b_num"));
	 String b_writer = request.getParameter("b_writer");
	 String b_subject = request.getParameter("b_subject");
	 String b_content = request.getParameter("b_content");
	 String b_pwd = request.getParameter("b_pwd");
	 BoardDTO dto = new BoardDTO(b_num, b_writer, b_subject, b_content, b_pwd);
	 
	 BoardDAO dao = new BoardDAO();
	 dao.boardUpdate(dto);
	 
	 ActionForward forward = new ActionForward();
	 forward.setPath("boardList.do");
	 forward.setRedirect(true);
	 return forward;
 	}
}
