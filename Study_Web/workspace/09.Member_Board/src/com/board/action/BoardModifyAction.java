package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.study.BoardDAO;
import com.board.study.BoardDTO;
import com.commons.action.Action;
import com.commons.action.ActionForward;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDTO dto = new BoardDTO();
		dto.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		dto.setBoard_subject(request.getParameter("board_subject"));
		dto.setBoard_content(request.getParameter("board_content"));
		
		BoardDAO dao = new BoardDAO();
		int succ = dao.boardUpdate(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (succ > 0) {
			out.println("<script>alert('수정성공!');");
			out.println("location.href='boardDetailAction.bo?board_num=" + dto.getBoard_num() + "';</script>");
		} else {
			out.println("<script>alert('수정실패!');");
			out.println("location.href='boardDetailAction.bo?board_num=" + dto.getBoard_num() + "';</script>");
		}
		
		return null;
	}
	
}
