package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.study.BoardDAO;
import com.commons.action.Action;
import com.commons.action.ActionForward;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDAO dao = new BoardDAO();
		boolean result = dao.isBoardWriter(board_num, id);	//작성자 확인
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (id.equals("admin") || result) {	//관리자 또는 로그인 아이디와 일지하는 경우
			int succ = dao.boardDelete(board_num);
			if (succ > 0) {
				out.println("<script>alert('삭제성공!');");
				out.println("location.href='boardList.bo';</script>");
			} else {
				out.println("<script>alert('삭제실패!');");
				out.println("location.href='boardList.bo';</script>");
			}
		} else {
			out.println("<script>alert('삭제권한이 없습니다!');");
			//out.println("location.href='boardDetailAction.bo?board_num=" + board_num + "';</script>");
			out.println("history.go(-1);</script>");
		}
		
		return null;
	}
	
}
